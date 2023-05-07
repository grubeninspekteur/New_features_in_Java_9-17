import java.util.stream.Stream;

public class Task {
  public Stream<Integer> repeatByValue(Stream<Integer> numbers) {
    return numbers.mapMulti((number, consumer) -> {
      for (int i = 0; i < number; i++) {
        consumer.accept(number);
      }
    });
  }
}