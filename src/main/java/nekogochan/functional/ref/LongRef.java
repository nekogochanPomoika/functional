
package nekogochan.functional.ref;

import java.util.function.LongConsumer;
import java.util.function.LongSupplier;

public class LongRef implements LongSupplier, LongConsumer{
  
  long value;

  public LongRef(long value) {
    this.value = value;
  }
  
  @Override
  public void accept(long value) {
    set(value);
  }
  @Override
  public long getAsLong() {
    return get();
  }
  
  public void set(long value) {
    this.value = value;
  }
  public long get() {
    return this.value;
  }
  
  public void add(long value) {
    this.value += value;
  }
  public void subtract(long value) {
    this.value -= value;
  }
  public void multiply(long value) {
    this.value *= value;
  }
  public void divide(long value) {
    this.value /= value;
  }
  
  public void increment() {
    add(1);
  }
  public void decrement() {
    subtract(1);
  }
}
