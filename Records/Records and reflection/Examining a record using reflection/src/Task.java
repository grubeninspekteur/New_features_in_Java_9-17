import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Task {

  public Optional<Map<String, Object>> getRecordValues(Object anObject)
      throws InvocationTargetException, IllegalAccessException {
    if (anObject.getClass().isRecord()) {
      Map<String, Object> valueByComponentName = new HashMap<>();

      RecordComponent[] recordComponents = anObject.getClass().getRecordComponents();

      for (RecordComponent component : recordComponents) {
        var name = component.getName();
        var value = component.getAccessor().invoke(anObject);
        valueByComponentName.put(name, value);
      }

      return Optional.of(valueByComponentName);
    } else {
      return Optional.empty();
    }
  }
}