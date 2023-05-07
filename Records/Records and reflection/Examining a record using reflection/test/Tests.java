import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

  private final Task task = new Task();

  @Test
  public void returnsEmptyOptionalForNonRecord() throws Exception {
    assertTrue("returns empty optional for non-record", task.getRecordValues("hello world").isEmpty());
  }

  @Test
  public void extractsRecordComponents() throws Exception {
    Optional<Map<String, Object>> recordValuesOpt = task.getRecordValues(new Point3D(10, 30, 100));

    assertTrue("recognizes a record", recordValuesOpt.isPresent());

    var recordValues = recordValuesOpt.get();

    assertEquals("has correct number of components extracted", 3, recordValues.size());
    assertEquals("has component 1 extracted", 10, recordValues.get("x"));
    assertEquals("has component 2 extracted", 30, recordValues.get("y"));
    assertEquals("has component 3 extracted", 100, recordValues.get("z"));
  }

  @Test
  public void handlesEmptyRecord() throws Exception {
    var recordValueOpt = task.getRecordValues(new EmptyRecord());

    assertTrue(recordValueOpt.isPresent());
    assertEquals(0, recordValueOpt.get().size());
  }

  public record Point3D(int x, int y, int z) {}

  public record EmptyRecord() {}
}