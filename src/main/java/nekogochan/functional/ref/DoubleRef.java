
package nekogochan.functional.ref;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

public class DoubleRef implements DoubleSupplier, DoubleConsumer{
  
  double value;

  public DoubleRef(double value) {
    this.value = value;
  }
  
  @Override
  public void accept(double value) {
    set(value);
  }
  @Override
  public double getAsDouble() {
    return get();
  }
  
  public void set(double value) {
    this.value = value;
  }
  public double get() {
    return this.value;
  }
  
  public void add(double value) {
    this.value += value;
  }
  public void subtract(double value) {
    this.value -= value;
  }
  public void multiply(double value) {
    this.value *= value;
  }
  public void divide(double value) {
    this.value /= value;
  }
  
  public void increment() {
    add(1.0);
  }
  public void decrement() {
    subtract(1.0);
  }
}
