package nekogochan.functional;

import nekogochan.sourcegenerator.InterfaceGenerator;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class SourceGenerator {

  public static final String PACKAGE = SourceGenerator.class.getPackageName();

  public static void main(String[] args) {
    generateFunctions();
  }

  private static void generateFunctions() {
    IntStream.range(0, 100)
             .boxed()
             .forEach(Unchecked.call(SourceGenerator::generateFunction_i_Interface));
  }

  private static void generateFunction_i_Interface(int argsCount) throws IOException {
    var templates = generateTemplates(argsCount);
    var args = generateArgs(argsCount);
    var l_args = generateLambdaArgs(argsCount);
    var gen = new InterfaceGenerator(PACKAGE + ".functional", "Function" + argsCount);
    gen.addImport("java.util.function.Function");
    gen.addClassTemplate(templates);
    gen.addClassTemplate("R");
    gen.addMethod("R apply(%s)".formatted(args));
    gen.addEmptyLine();
    gen.addDefaultMethod("<U> Function%s<%s, U> andThen(Function<R, U> op)".formatted(argsCount, templates),
                         """
                         return (%s) -> op.apply(this.apply(%s));
                         """.formatted(l_args, l_args));
    gen.writeLocal();
  }

  private static String generateTemplates(int T_count) {
    return prepareTemplate(T_count).collect(joining(", "));
  }

  private static String generateArgs(int T_count) {
    return prepareTemplate(T_count).map(T -> "%s %s".formatted(T, T.toLowerCase()))
                                   .collect(joining(", "));
  }

  private static String generateLambdaArgs(int T_count) {
    return prepareTemplate(T_count).map(String::toLowerCase).collect(joining(", "));
  }

  private static Stream<String> prepareTemplate(int T_count) {
    return IntStream.iterate(1, i -> i + 1)
                    .limit(T_count)
                    .mapToObj(i -> "T" + i);
  }
}
