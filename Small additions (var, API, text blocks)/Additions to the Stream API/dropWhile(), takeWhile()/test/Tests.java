import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class Tests {
  Task uut = new Task();

  @Test
  public void testSimpleList() {

    var sourceList = List.of("one", "two", "three", "START", "four", "five", "six", "STOP", "seven",
        "eight", "nine");
    var result = uut.getBetweenStartToEnd(sourceList);
    assertEquals(sourceList.toString(), List.of("four", "five", "six"), result);
  }

  @Test
  public void testEmptyList() {
    var result = uut.getBetweenStartToEnd(List.of("START", "STOP"));
    assertEquals("empty list works", List.of(), result);
  }
}