package nekogochan.functional.fuinction;

import nekogochan.functional.function.Fn;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FnTest {

  @Test
  void numbers() {
    var values = Stream.of(1, 2, 3, 4, 5, 6)
                       .map(Number::doubleValue)
                       .map(Fn.of(Math::pow).partial(2.0))
                       .map(Number::intValue)
                       .collect(toList());

    assertEquals(
      List.of(2, 4, 8, 16, 32, 64),
      values
    );
  }

  @Test
  void cats() {
    var blackCatConstructor = Fn.of(Cat::new)
                                .partialBack("black", "green");

    var tomas = blackCatConstructor.apply("Tomas", 10);
    var shnurok = blackCatConstructor.apply("Shnurok", 4);

    assertAll(
      () -> assertEquals(new Cat("Tomas", 10, "black", "green"),
                         tomas),

      () -> assertEquals(new Cat("Shnurok", 4, "black", "green"),
                         shnurok)
    );
  }

  static class Cat {
    private final String name;
    private final int age;
    private final String color;
    private final String eyesColor;

    public Cat(String name, int age, String color, String eyesColor) {
      this.name = name;
      this.age = age;
      this.color = color;
      this.eyesColor = eyesColor;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Cat cat = (Cat) o;
      return age == cat.age && Objects.equals(name, cat.name) && Objects.equals(color, cat.color) && Objects.equals(eyesColor, cat.eyesColor);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age, color, eyesColor);
    }
  }
}
