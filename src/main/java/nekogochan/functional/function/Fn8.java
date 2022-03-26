
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);

  default <U> Fn8<T1, T2, T3, T4, T5, T6, T7, T8, U> then(Function<R, U> op) {
    return (t1, t2, t3, t4, t5, t6, t7, t8) -> op.apply(this.apply(t1, t2, t3, t4, t5, t6, t7, t8));
  }

  default Fn7<T1, T2, T3, T4, T5, T6, T7, R> partialBack(T8 t8) {
    return (t1, t2, t3, t4, t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn6<T1, T2, T3, T4, T5, T6, R> partialBack(T7 t7, T8 t8) {
    return (t1, t2, t3, t4, t5, t6) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn5<T1, T2, T3, T4, T5, R> partialBack(T6 t6, T7 t7, T8 t8) {
    return (t1, t2, t3, t4, t5) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn4<T1, T2, T3, T4, R> partialBack(T5 t5, T6 t6, T7 t7, T8 t8) {
    return (t1, t2, t3, t4) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn3<T1, T2, T3, R> partialBack(T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return (t1, t2, t3) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn2<T1, T2, R> partialBack(T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return (t1, t2) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn1<T1, R> partialBack(T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return (t1) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn0<R> partialBack(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn0<R> partial(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn1<T8, R> partial(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return (t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn2<T7, T8, R> partial(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
    return (t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn3<T6, T7, T8, R> partial(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
    return (t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn4<T5, T6, T7, T8, R> partial(T1 t1, T2 t2, T3 t3, T4 t4) {
    return (t5, t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn5<T4, T5, T6, T7, T8, R> partial(T1 t1, T2 t2, T3 t3) {
    return (t4, t5, t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn6<T3, T4, T5, T6, T7, T8, R> partial(T1 t1, T2 t2) {
    return (t3, t4, t5, t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }

  default Fn7<T2, T3, T4, T5, T6, T7, T8, R> partial(T1 t1) {
    return (t2, t3, t4, t5, t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8);
  }
}
