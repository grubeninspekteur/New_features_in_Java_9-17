import java.util.List;

public class Task {
  public List<String> getBetweenStartToEnd(List<String> words) {
    return words.stream()
        .dropWhile(word -> !"START".equals(word))
        .skip(1)
        .takeWhile(word -> !"END".equals(word))
        .toList();
  }
}