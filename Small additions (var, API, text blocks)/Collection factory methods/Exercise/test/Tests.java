import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  Task uut = new Task();

  @Test
  public void isFarmAnimal() {
    assertFalse(uut.isFarmAnimal("duck"));
    assertFalse(uut.isFarmAnimal("alligator"));
    assertTrue(uut.isFarmAnimal("cow"));
    assertTrue(uut.isFarmAnimal("sheep"));
  }

  @Test
  public void getDescriptions() {
    assertTrue(uut.getDescriptions(null).isEmpty());
    assertTrue(uut.getDescriptions(List.of()).isEmpty());
    assertEquals(List.of("Cats meow", "A cow has hoofs", "Cats meow"), uut.getDescriptions(List.of("cat", "cow", "cat")));
  }

  @Test
  public void getAlligatorAsList() {
    assertEquals(List.of("alligator"), uut.getAlligatorAsList());
  }
}
