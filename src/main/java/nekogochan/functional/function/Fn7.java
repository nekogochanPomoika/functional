
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn7<T1, T2, T3, T4, T5, T6, T7, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);

  default <U> Fn7<T1, T2, T3, T4, T5, T6, T7, U> then(Function<R, U> op) {
    return (t1, t2, t3, t4, t5, t6, t7) -> op.apply(this.apply(t1, t2, t3, t4, t5, t6, t7));
  }

  default Fn6<T1, T2, T3, T4, T5, T6, R> $$(T7 t7) {
    return (t1, t2, t3, t4, t5, t6) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn5<T1, T2, T3, T4, T5, R> $$(T6 t6, T7 t7) {
    return (t1, t2, t3, t4, t5) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn4<T1, T2, T3, T4, R> $$(T5 t5, T6 t6, T7 t7) {
    return (t1, t2, t3, t4) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn3<T1, T2, T3, R> $$(T4 t4, T5 t5, T6 t6, T7 t7) {
    return (t1, t2, t3) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn2<T1, T2, R> $$(T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return (t1, t2) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn1<T1, R> $$(T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return (t1) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn0<R> $$(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn0<R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn1<T7, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
    return (t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn2<T6, T7, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
    return (t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn3<T5, T6, T7, R> __(T1 t1, T2 t2, T3 t3, T4 t4) {
    return (t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn4<T4, T5, T6, T7, R> __(T1 t1, T2 t2, T3 t3) {
    return (t4, t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn5<T3, T4, T5, T6, T7, R> __(T1 t1, T2 t2) {
    return (t3, t4, t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }

  default Fn6<T2, T3, T4, T5, T6, T7, R> __(T1 t1) {
    return (t2, t3, t4, t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7);
  }
}
