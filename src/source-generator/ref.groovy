import java.nio.file.Files
import java.nio.file.Path

def primitives = [
        ["int", "IntConsumer", "IntSupplier"],
        ["long", "LongConsumer", "LongSupplier"],
        ["double", "DoubleConsumer", "DoubleSupplier"]
]

def primitiveRefTemplate = (String type, String consumer, String supplier) -> {
    def Type = type[0].toUpperCase() + type.substring(1)
    def className = "${Type}Ref"
    return """
package nekogochan.functional.ref;

import java.util.function.$consumer;
import java.util.function.$supplier;

public class $className implements $supplier, ${consumer}{
  
  $type value;

  public $className($type value) {
    this.value = value;
  }
  
  @Override
  public void accept($type value) {
    set(value);
  }
  @Override
  public ${type} getAs$Type() {
    return get();
  }
  
  public void set($type value) {
    this.value = value;
  }
  public $type get() {
    return this.value;
  }
  
  public void add($type value) {
    this.value += value;
  }
  public void subtract($type value) {
    this.value -= value;
  }
  public void multiply($type value) {
    this.value *= value;
  }
  public void divide($type value) {
    this.value /= value;
  }
  
  public void increment() {
    add(${type == "double" ? "1.0" : "1"});
  }
  public void decrement() {
    subtract(${type == "double" ? "1.0" : "1"});
  }
}
"""
}

primitives.forEach {
    def path = Path.of("C:\\Users\\sgs08\\IdeaProjects\\functional\\src\\main\\java\\nekogochan\\functional\\ref")
    def Type = it[0][0].toUpperCase() + it[0].substring(1)
    Files.writeString(path.resolve("${Type}Ref.java"), primitiveRefTemplate(it[0], it[1], it[2]))
}