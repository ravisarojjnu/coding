# Java 8 Stream API Examples

This repository contains examples and explanations of using the Stream API in Java 8. The Stream API is a powerful and expressive feature introduced in Java 8 for processing sequences of elements in a functional style.

## Overview

The Stream API provides a set of high-level operations that allow you to express complex data manipulations easily. Here are some of the key features covered in this repository:

- **Filtering:** Using filter() to select elements based on a given predicate.
- **Mapping:** Applying a function to each element using map().
- **Sorting:** Sorting elements using sorted().
- **Collecting:** Collecting the elements of a stream into a collection using collect().
- **Reducing:** Reducing elements to a single value using reduce().
- **Grouping and Partitioning:** Grouping and partitioning elements using groupingBy() and partitioningBy().
- **Parallel Streams:** Using parallel streams to parallelize operations.

## Examples

### 1 Filtering

```java
   List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");

List<String> filteredNames = names.stream()
                                 .filter(name -> name.length() > 3)
                                 .collect(Collectors.toList());

System.out.println(filteredNames); // Output: [John, Alice]
```

### 2. Mapping

```java
   List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");

List<Integer> nameLengths = names.stream()
                               .map(String::length)
                               .collect(Collectors.toList());

System.out.println(nameLengths); // Output: [4, 3, 5, 3]
```

### 3. Sorting

```java
List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");

List<String> sortedNames = names.stream()
                               .sorted()
                               .collect(Collectors.toList());

System.out.println(sortedNames); // Output: [Alice, Bob, Doe, John]
```

### 4.Collecting

Collecting the elements of a stream into a collection using collect()
The collect() method in the Stream API is a terminal operation that transforms the elements of a stream into a different form, usually a collection like a List, Set, or Map. It is a versatile operation that allows you to customize the result using various collectors provided in the Collectors utility class.

```java
List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");

List<String> filteredNames = names.stream()
                                 .filter(name -> name.length() > 3)
                                 .collect(Collectors.toList());

System.out.println(filteredNames); // Output: [John, Alice]
```

### 5.Reducing

Reducing elements to a single value using reduce()
The reduce() operation in the Stream API is another terminal operation that combines the elements of a stream into a single result. It takes two parameters: an identity value and a binary operator. The binary operator is applied to the elements of the stream successively, reducing them to a single value.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);

System.out.println(sum); // Output: 15
```

### 6. Grouping and Partitioning

Grouping and partitioning elements using groupingBy() and partitioningBy()
The groupingBy() and partitioningBy() collectors in the Collectors utility class are useful for grouping elements of a stream based on certain criteria.

```java
List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");

Map<Integer, List<String>> groupedByLength = names.stream()
                                                 .collect(Collectors.groupingBy(String::length));

System.out.println(groupedByLength);

```

### 7. Parallel Streams

Using parallel streams to parallelize operations
Java 8 introduced the concept of parallel streams to take advantage of multi-core processors and perform operations concurrently.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.parallelStream()
                 .reduce(0, Integer::sum);

System.out.println(sum);
```
