import java.util.Arrays;

public record ArrayHolder(int[] items) {

  public ArrayHolder {
    items = Arrays.copyOf(items, items.length);
  }

  @Override
  public int[] items() {
    return Arrays.copyOf(items, items.length);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrayHolder that = (ArrayHolder) o;
    return Arrays.equals(items, that.items);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(items);
  }

  // not mandatory for the solution, but prints prettier test failures
  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}