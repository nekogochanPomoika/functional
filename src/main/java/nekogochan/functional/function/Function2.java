package nekogochan.functional.function;

import java.util.function.Function;

public interface Function2<T1, T2, R> {
  R apply(T1 t1, T2 t2);

  default <U> Function2<T1, T2, U> andThen(Function<R, U> op) {
    return (t1, t2) -> op.apply(this.apply(t1, t2));
  }
}
