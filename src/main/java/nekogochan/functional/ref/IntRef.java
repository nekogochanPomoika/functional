
package nekogochan.functional.ref;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class IntRef implements IntSupplier, IntConsumer{
  
  int value;

  public IntRef(int value) {
    this.value = value;
  }
  
  @Override
  public void accept(int value) {
    set(value);
  }
  @Override
  public int getAsInt() {
    return get();
  }
  
  public void set(int value) {
    this.value = value;
  }
  public int get() {
    return this.value;
  }
  
  public void add(int value) {
    this.value += value;
  }
  public void subtract(int value) {
    this.value -= value;
  }
  public void multiply(int value) {
    this.value *= value;
  }
  public void divide(int value) {
    this.value /= value;
  }
  
  public void increment() {
    add(1);
  }
  public void decrement() {
    subtract(1);
  }
}
