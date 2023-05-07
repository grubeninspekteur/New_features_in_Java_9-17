public record Absolute(int value) {
  public Absolute {
    value = Math.abs(value);
  }
}
