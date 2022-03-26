
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn4<T1, T2, T3, T4, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4);

  default <U> Fn4<T1, T2, T3, T4, U> then(Function<R, U> op) {
    return (t1, t2, t3, t4) -> op.apply(this.apply(t1, t2, t3, t4));
  }

  default Fn3<T1, T2, T3, R> partialBack(T4 t4) {
    return (t1, t2, t3) -> this.apply(t1, t2, t3, t4);
  }

  default Fn2<T1, T2, R> partialBack(T3 t3, T4 t4) {
    return (t1, t2) -> this.apply(t1, t2, t3, t4);
  }

  default Fn1<T1, R> partialBack(T2 t2, T3 t3, T4 t4) {
    return (t1) -> this.apply(t1, t2, t3, t4);
  }

  default Fn0<R> partialBack(T1 t1, T2 t2, T3 t3, T4 t4) {
    return () -> this.apply(t1, t2, t3, t4);
  }

  default Fn0<R> partial(T1 t1, T2 t2, T3 t3, T4 t4) {
    return () -> this.apply(t1, t2, t3, t4);
  }

  default Fn1<T4, R> partial(T1 t1, T2 t2, T3 t3) {
    return (t4) -> this.apply(t1, t2, t3, t4);
  }

  default Fn2<T3, T4, R> partial(T1 t1, T2 t2) {
    return (t3, t4) -> this.apply(t1, t2, t3, t4);
  }

  default Fn3<T2, T3, T4, R> partial(T1 t1) {
    return (t2, t3, t4) -> this.apply(t1, t2, t3, t4);
  }
}
