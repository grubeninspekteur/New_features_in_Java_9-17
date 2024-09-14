public record Range(int from, int to) {
  public Range(int from, int to) {
    if (from > to) {
      throw new IllegalArgumentException("to" + to + " may not be less than from " + from);
    }

    this.from = from;
    this.to = to;
  }
}