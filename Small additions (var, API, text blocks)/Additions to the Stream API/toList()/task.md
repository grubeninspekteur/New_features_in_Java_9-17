# Additions to the stream API

## toList()

As you know, you can collect the results of a stream using the Collector API.
There are many powerful collectors, and you can even define your own.

One collector however is used a lot more than any other: [Collectors.toList()](psi_element://java.util.stream.Collectors#toList).
Because of this, a convenient [toList()](psi_element://java.util.stream.Stream#toList) has been added directly to `Stream`.

Note that there is **no toSet()**.
It is not a goal to add a method for each collection type.
The collectors API is deliberately designed like it is, because it allows the addition of
collectors without having to change the Stream API.

`toList()` is not available on primitive streams (like [IntStream](psi_element://java.util.stream.IntStream)), which makes sense since
generics require objects (for now, at least).
However, you can use the operator [boxed()](psi_element://java.util.stream.IntStream#boxed) to box these first and then use `toList()`.

> **Warning:** `toList()` returns an _immutable_ list.
> While the JavaDoc says there are no guarantees about the mutability of the returned list,
> `Collectors.toList()` in OpenJDK de facto returns an `ArrayList`.
> If your code was relying on this implementation detail, it will break after refactoring to
> `toList()`.
> 
> In general, your code should treat any list you got as a parameter or return type as of unknown mutability,
> and make a copy if you need to change it.