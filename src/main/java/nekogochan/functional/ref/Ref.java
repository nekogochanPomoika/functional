package nekogochan.functional.ref;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ref<T> implements Supplier<T>, Consumer<T> {

  T value;

  public Ref(T value) {
    this.value = value;
  }

  @Override
  public void accept(T t) {
    set(t);
  }

  @Override
  public T get() {
    return value;
  }

  public void set(T value) {
    this.value = value;
  }
}
