import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    Task task = new Task();

    assertEquals(List.of(), task.repeatByValue(Stream.of(0, 0, 0)).toList());
    assertEquals(List.of(1), task.repeatByValue(Stream.of(1)).toList());
    assertEquals(List.of(3, 3, 3, 2, 2, 1, 4, 4, 4, 4), task.repeatByValue(Stream.of(0, 3, 2, 1, 0, 4)).toList());
    assertEquals(List.of(), task.repeatByValue(Stream.of()).toList());
  }
}