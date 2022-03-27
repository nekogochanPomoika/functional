
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10);

  default <U> Fn10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, U> then(Function<R, U> op) {
    return (t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) -> op.apply(this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
  }

  default Fn9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $$(T10 t10) {
    return (t1, t2, t3, t4, t5, t6, t7, t8, t9) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn8<T1, T2, T3, T4, T5, T6, T7, T8, R> $$(T9 t9, T10 t10) {
    return (t1, t2, t3, t4, t5, t6, t7, t8) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn7<T1, T2, T3, T4, T5, T6, T7, R> $$(T8 t8, T9 t9, T10 t10) {
    return (t1, t2, t3, t4, t5, t6, t7) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn6<T1, T2, T3, T4, T5, T6, R> $$(T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1, t2, t3, t4, t5, t6) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn5<T1, T2, T3, T4, T5, R> $$(T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1, t2, t3, t4, t5) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn4<T1, T2, T3, T4, R> $$(T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1, t2, t3, t4) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn3<T1, T2, T3, R> $$(T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1, t2, t3) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn2<T1, T2, R> $$(T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1, t2) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn1<T1, R> $$(T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return (t1) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn0<R> $$(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn0<R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
    return () -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn1<T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
    return (t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn2<T9, T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
    return (t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn3<T8, T9, T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
    return (t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn4<T7, T8, T9, T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
    return (t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn5<T6, T7, T8, T9, T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
    return (t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn6<T5, T6, T7, T8, T9, T10, R> __(T1 t1, T2 t2, T3 t3, T4 t4) {
    return (t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn7<T4, T5, T6, T7, T8, T9, T10, R> __(T1 t1, T2 t2, T3 t3) {
    return (t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn8<T3, T4, T5, T6, T7, T8, T9, T10, R> __(T1 t1, T2 t2) {
    return (t3, t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }

  default Fn9<T2, T3, T4, T5, T6, T7, T8, T9, T10, R> __(T1 t1) {
    return (t2, t3, t4, t5, t6, t7, t8, t9, t10) -> this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
  }
}
