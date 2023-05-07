import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  final String input = """
      duck
      Duck
      elephant
      DUCk
      cOW
      elePHAnt
      cow
      """;

  @Test
  public void testSolution() throws IOException, URISyntaxException {
    Task task = new Task();

    Map<String, Integer> result = task.countAnimals(new ByteArrayInputStream(input.getBytes()));

    assertEquals(3, result.size());
    assertEquals(Integer.valueOf(2), result.get("cow"));
    assertEquals(Integer.valueOf(2), result.get("elephant"));
    assertEquals(Integer.valueOf(3), result.get("duck"));
  }
}