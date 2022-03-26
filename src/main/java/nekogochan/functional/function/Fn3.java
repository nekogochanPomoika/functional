
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn3<T1, T2, T3, R> {
  R apply(T1 t1, T2 t2, T3 t3);

  default <U> Fn3<T1, T2, T3, U> then(Function<R, U> op) {
    return (t1, t2, t3) -> op.apply(this.apply(t1, t2, t3));
  }

  default Fn2<T1, T2, R> partialBack(T3 t3) {
    return (t1, t2) -> this.apply(t1, t2, t3);
  }

  default Fn1<T1, R> partialBack(T2 t2, T3 t3) {
    return (t1) -> this.apply(t1, t2, t3);
  }

  default Fn0<R> partialBack(T1 t1, T2 t2, T3 t3) {
    return () -> this.apply(t1, t2, t3);
  }

  default Fn0<R> partial(T1 t1, T2 t2, T3 t3) {
    return () -> this.apply(t1, t2, t3);
  }

  default Fn1<T3, R> partial(T1 t1, T2 t2) {
    return (t3) -> this.apply(t1, t2, t3);
  }

  default Fn2<T2, T3, R> partial(T1 t1) {
    return (t2, t3) -> this.apply(t1, t2, t3);
  }
}
