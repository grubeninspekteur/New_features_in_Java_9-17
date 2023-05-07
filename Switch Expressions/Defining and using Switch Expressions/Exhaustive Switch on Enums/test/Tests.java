import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testEnumHasPlatinum() {
    var hasPlatinum = Arrays.stream(Achievement.values()).anyMatch(v -> v.name().equals("PLATINUM"));
    assertTrue("Enum should have PLATINUM value", hasPlatinum);
  }

  @Test
  public void testAchievementSentences() {
    Task uut = new Task();

    assertEquals("You've achieved BRONZE! Good job!", uut.getAchievementCongratulations(Achievement.BRONZE));
    assertEquals("You've achieved SILVER! Well done!", uut.getAchievementCongratulations(Achievement.SILVER));
    assertEquals("You've achieved GOLD! Excellent work!", uut.getAchievementCongratulations(Achievement.GOLD));
    assertEquals("You've achieved PLATINUM! Perfect solution!", uut.getAchievementCongratulations(Achievement.valueOf("PLATINUM")));
  }
}