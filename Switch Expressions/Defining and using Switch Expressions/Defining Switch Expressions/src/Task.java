public class Task {
  public boolean isPrime(int number) {
    return switch (number) {
      case 2, 3, 5, 7 -> true;
      case 1, 4, 6, 8, 9, 10 -> false;
      default -> throw new IllegalArgumentException("Input out of range: " + number);
    };
  }
}