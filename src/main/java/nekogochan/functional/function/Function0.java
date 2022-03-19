package nekogochan.functional.function;

import java.util.function.Function;

public interface Function0<, R> {
  R apply();

  default <U> Function0<, U> andThen(Function<R, U> op) {
    return () -> op.apply(this.apply());
  }
}
