import java.nio.file.Files
import java.nio.file.Path
import java.util.function.Function
import java.util.stream.Stream

import static java.util.stream.Collectors.joining

def join = (List T) -> String.join(", ", T)

def joinTemplates = (List T) -> T.stream().collect(joining(", ", "<", ">"))

def mapList = (List T, Function op) -> T.stream().map({ op.apply(it) }).toList()

def asTemplates = (List T) -> joinTemplates(mapList(T, { it }))

def asParameters = (List T) -> join(mapList(T, { "${it} ${it.toLowerCase()}" }))

def asArgs = (List T) -> join(mapList(T, { it.toLowerCase() }))

def push = (String value, List T) -> {
    def newList = new ArrayList(T)
    newList.add(value)
    return newList
}

def concat = (List a, List b) -> {
    def newList = new ArrayList(a)
    newList.addAll(b)
    return newList
}

def interfaceTemplate = (List T, List partial) -> {
    def __maybeExtends = {
        switch (T.size()) {
            case 0: return [
                    "import java.util.function.Supplier;",
                    "extends Supplier<R> ",
                    """
  @Override
  default R get() {
    return this.apply();
  }"""
            ]
            case 1: return [
                    null,
                    "extends Function<T1, R>",
                    null
            ]
            case 2: return [
                    "import java.util.function.BiFunction;",
                    "extends BiFunction<T1, T2, R> ",
                    null
            ]
            default: return [
                    null,
                    null,
                    null
            ]
        }
    }()

    var maybeImport = Optional.ofNullable(__maybeExtends[0]).map({ it + "\n" }).orElse("")
    var maybeExtend = Optional.ofNullable(__maybeExtends[1]).orElse("")
    var maybeOverride = Optional.ofNullable(__maybeExtends[2]).map({ it + "\n" }).orElse("")
    var maybePartial = partial.size() == 0 ? ""
            : "\n" + String.join("\n", partial)

    return """
package nekogochan.functional.function;
${maybeImport}
import java.util.function.Function;

public interface Fn${T.size()}${asTemplates(push("R", T))} ${maybeExtend}{
  R apply(${asParameters(T)});
${maybeOverride}
  default <U> Fn${T.size()}${asTemplates(push("U", T))} then(Function<R, U> op) {
    return (${asArgs(T)}) -> op.apply(this.apply(${asArgs(T)}));
  }${maybePartial}
}
"""
}

def __partialTemplate = (List memArgs, List nonMemArgs, String name = "partial", boolean reverse = false) -> {
    var allArgs = reverse ? concat(nonMemArgs, memArgs) : concat(memArgs, nonMemArgs)
    return """
  default Fn${nonMemArgs.size()}${asTemplates(push("R", nonMemArgs))} ${name}(${asParameters(memArgs)}) {
    return (${asArgs(nonMemArgs)}) -> this.apply(${asArgs(allArgs)});
  }"""
}

def partialTemplate = (List T, int argsCount) -> {
    var memArgs = T.subList(0, argsCount + 1)
    var nonMemArgs = T.subList(argsCount + 1, T.size())
    return __partialTemplate(memArgs, nonMemArgs, "__")
}

def partialBackTemplate = (List T, int argsCount) -> {
    var memArgs = T.subList(argsCount, T.size())
    var nonMemArgs = T.subList(0, argsCount)
    return __partialTemplate(memArgs, nonMemArgs, "\$\$", true)
}

def utilClassTemplate = (List T) -> {
    def methods = Stream
            .iterate(0, i -> i + 1)
            .limit(T.size() + 1)
            .map({ T.subList(0, it) })
            .map({
                def templates = asTemplates(push("R", it))
                def _Fn = "Fn${it.size()}${templates}"
                return """
  static ${templates} ${_Fn} fn(${_Fn} it) {
    return it;
  }"""
            })
            .collect(joining("\n"))
    return """
package nekogochan.functional.function;

public interface Fn {
${methods}
}
"""
}

for (int count = 0; count <= 10; count++) {
    def T = Stream.iterate(1, { it + 1 })
            .map({ "T" + it })
            .limit(count)
            .toList()

    def partial = new ArrayList()

    def pushPartial = (op) -> {
        for (int i = 0; i < count; i++) {
            partial.push(op(T, i))
        }
    }

    pushPartial(partialTemplate)
    pushPartial(partialBackTemplate)

    def code = interfaceTemplate(T, partial)
    def path = Path.of("C:\\Users\\sgs08\\IdeaProjects\\functional\\src\\main\\java\\nekogochan\\functional\\function")

    Files.writeString(path.resolve("Fn${count}.java"), code)
    if (count == 10) Files.writeString(path.resolve("Fn.java"), utilClassTemplate(T))
}
