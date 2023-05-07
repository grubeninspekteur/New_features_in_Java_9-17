public record Range(int from, int to) {
  public Range(int from, int to) {
    if (from > to) {
      throw new IllegalArgumentException("from " + from + " may not be smaller than to " + to);
    }

    this.from = from;
    this.to = to;
  }
}