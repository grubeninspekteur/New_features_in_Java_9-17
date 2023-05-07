import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void createsValidRange() {
    try {
      var range1 = new Range(1, 2);
      var range2 = new Range(3, 3);
      var range3 = new Range(-1, 2);

      assertEquals(1, range1.from());
      assertEquals(3, range2.to());
      assertEquals(-1, range3.from());
      assertEquals(2, range3.to());
    } catch (IllegalArgumentException e) {
      fail("valid range should not throw exception");
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void disallowsNegativeRange() {
    new Range(5, 1);
  }
}