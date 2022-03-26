
package nekogochan.functional.function;
import java.util.function.Supplier;

import java.util.function.Function;

public interface Fn0<R> extends Supplier<R> {
  R apply();

  @Override
  default R get() {
    return this.apply();
  }

  default <U> Fn0<U> then(Function<R, U> op) {
    return () -> op.apply(this.apply());
  }
}
