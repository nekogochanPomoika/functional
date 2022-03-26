
package nekogochan.functional.function;

import java.util.function.Function;

public interface Fn1<T1, R> extends Function<T1, R>{
  R apply(T1 t1);

  default <U> Fn1<T1, U> then(Function<R, U> op) {
    return (t1) -> op.apply(this.apply(t1));
  }

  default Fn0<R> partialBack(T1 t1) {
    return () -> this.apply(t1);
  }

  default Fn0<R> partial(T1 t1) {
    return () -> this.apply(t1);
  }
}
