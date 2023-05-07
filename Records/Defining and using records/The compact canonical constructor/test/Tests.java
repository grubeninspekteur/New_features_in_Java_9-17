import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    assertEquals(5, new Absolute(5).value());
    assertEquals(7, new Absolute(-7).value());
  }
}