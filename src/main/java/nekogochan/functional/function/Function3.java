package nekogochan.functional.function;

import java.util.function.Function;

public interface Function3<T1, T2, T3, R> {
  R apply(T1 t1, T2 t2, T3 t3);

  default <U> Function3<T1, T2, T3, U> andThen(Function<R, U> op) {
    return (t1, t2, t3) -> op.apply(this.apply(t1, t2, t3));
  }
}
