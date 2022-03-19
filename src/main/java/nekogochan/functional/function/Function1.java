package nekogochan.functional.function;

import java.util.function.Function;

public interface Function1<T1, R> {
  R apply(T1 t1);

  default <U> Function1<T1, U> andThen(Function<R, U> op) {
    return (t1) -> op.apply(this.apply(t1));
  }
}
