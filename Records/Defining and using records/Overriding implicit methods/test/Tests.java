import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
  private final int[] items = new int[]{1, 2, 3};

  private ArrayHolder uut;

  @Before
  public void setUp() throws Exception {
    uut = new ArrayHolder(items);
  }

  @Test
  public void doesNotChangeByMutatingArrayPassedToConstructor() {
    assertEquals("reading the array yields the same value", 2, uut.items()[1]);

    items[0] = 42;

    assertEquals("mutating the array used to construct ArrayHolder should not change record array state", 1, uut.items()[0]);
  }

  @Test
  public void holdsCopyEqualsInvariant() {
    var otherArrayHolder = new ArrayHolder(uut.items());

    assertEquals("a copy made using the accessor and new() should be equal to the original", uut, otherArrayHolder);
    assertEquals("a copy made using the accessor and new() should have the same hash code as the original", uut.hashCode(), otherArrayHolder.hashCode());
  }

  @Test
  public void doesNotChangeByMutatingArrayFromAccessor() {
    uut.items()[0] = 42;

    assertEquals("mutating the array returned by the accessor should not change record array state", 1, uut.items()[0]);
  }

  @Test
  public void isNotJustEqualsReturnTrue() {
    assertNotEquals("are you cheating? :)", uut);
    assertNotEquals(new ArrayHolder(new int[] {4, 5, 6}), uut);
  }
}