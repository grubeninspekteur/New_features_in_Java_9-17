import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  private final Task uut = new Task();

  @Test
  public void recognizesPrimeNumbers() {
    Map<Integer, Boolean> isPrimeExpected = Map.of(
        1, false,
        2, true,
         3, true,
        4, false,
        5, true,
        6, false,
        7, true,
        8, false,
        9, false,
        10, false
    );

    for (int i = 1; i <= 10; i++) {
      var isPrime = isPrimeExpected.get(i);
      var message = "recognizes " + i  + (isPrime ? " as prime" : " as not prime");
      assertEquals(message, isPrime, uut.isPrime(i));
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwsForZero() {
    uut.isPrime(0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void throwsForNegativeNumber() {
    uut.isPrime(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwsForGreaterThanTen() {
    uut.isPrime(11);
  }

}