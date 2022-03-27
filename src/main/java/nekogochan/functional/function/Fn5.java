
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn5<T1, T2, T3, T4, T5, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);

  default <U> Fn5<T1, T2, T3, T4, T5, U> then(Function<R, U> op) {
    return (t1, t2, t3, t4, t5) -> op.apply(this.apply(t1, t2, t3, t4, t5));
  }

  default Fn4<T1, T2, T3, T4, R> $$(T5 t5) {
    return (t1, t2, t3, t4) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn3<T1, T2, T3, R> $$(T4 t4, T5 t5) {
    return (t1, t2, t3) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn2<T1, T2, R> $$(T3 t3, T4 t4, T5 t5) {
    return (t1, t2) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn1<T1, R> $$(T2 t2, T3 t3, T4 t4, T5 t5) {
    return (t1) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn0<R> $$(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
    return () -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn0<R> __(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
    return () -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn1<T5, R> __(T1 t1, T2 t2, T3 t3, T4 t4) {
    return (t5) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn2<T4, T5, R> __(T1 t1, T2 t2, T3 t3) {
    return (t4, t5) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn3<T3, T4, T5, R> __(T1 t1, T2 t2) {
    return (t3, t4, t5) -> this.apply(t1, t2, t3, t4, t5);
  }

  default Fn4<T2, T3, T4, T5, R> __(T1 t1) {
    return (t2, t3, t4, t5) -> this.apply(t1, t2, t3, t4, t5);
  }
}
