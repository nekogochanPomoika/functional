
package nekogochan.functional.function;
import java.util.function.BiFunction;

import java.util.function.Function;

public interface Fn2<T1, T2, R> extends BiFunction<T1, T2, R> {
  R apply(T1 t1, T2 t2);

  default <U> Fn2<T1, T2, U> then(Function<R, U> op) {
    return (t1, t2) -> op.apply(this.apply(t1, t2));
  }

  default Fn1<T1, R> partialBack(T2 t2) {
    return (t1) -> this.apply(t1, t2);
  }

  default Fn0<R> partialBack(T1 t1, T2 t2) {
    return () -> this.apply(t1, t2);
  }

  default Fn0<R> partial(T1 t1, T2 t2) {
    return () -> this.apply(t1, t2);
  }

  default Fn1<T2, R> partial(T1 t1) {
    return (t2) -> this.apply(t1, t2);
  }
}
