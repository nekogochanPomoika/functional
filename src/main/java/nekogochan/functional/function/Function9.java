package nekogochan.functional.function;

import java.util.function.Function;

public interface Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
  R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);

  default <U> Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, U> andThen(Function<R, U> op) {
    return (t1, t2, t3, t4, t5, t6, t7, t8, t9) -> op.apply(this.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9));
  }
}
