import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

import java.util.ArrayList;
import java.util.List;

public class IntermediateRecord {

  public static void main(String[] args) {
    User john = new User("john.doe", "john.doe@example.org");
    User jane = new User("jane.doe", "jane.doe@example.org");
    User jack = new User("jack.london", "jack.london@example.org");

    List<Secret> logins = List.of(
        new Secret(john, 127),
        new Secret(jane, 57),
        new Secret(jack, 30),
        new Secret(john, 12),
        new Secret(jane, 20),
        new Secret(jack, 32)
    );

    System.out.println(getUsersSortedByPrimeFactorCount(logins));
  }

  private static List<User> getUsersSortedByPrimeFactorCount(List<Secret> logins) {
    record UserWithPrimeFactorCount(User user, int primeFactorCount) {}

    return logins.stream()
        .map(login -> new UserWithPrimeFactorCount(login.user(), getPrimeFactors(login.nonce()).size()))
        .sorted(comparing(UserWithPrimeFactorCount::primeFactorCount, reverseOrder()))
        .map(UserWithPrimeFactorCount::user)
        .distinct()
        .toList();
  }

  // example of an expensive computation you don't want to redo on every
  // comparison of two elements during sorting
  public static List<Integer> getPrimeFactors(int number) {
    List<Integer> factors = new ArrayList<>();

    while (number % 2 == 0) {
      factors.add(2);
      number /= 2;
    }

    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      while (number % i == 0) {
        factors.add(i);
        number /= i;
      }
    }

    if (number > 2) {
      factors.add(number);
    }

    return factors;
  }

  record Secret(User user, int nonce) {}

  record User(String userName, String email) {}
}
