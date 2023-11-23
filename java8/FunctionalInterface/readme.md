# Functional Interfaces in Java

This repository serves as a guide to understanding and working with functional interfaces in Java. Functional interfaces play a crucial role in the functional programming paradigm introduced in Java 8, enabling the use of lambda expressions and streams.

## Table of Contents

- [Functional Interfaces in Java](#functional-interfaces-in-java)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Functional Interface](#functional-interface)
  - [Lambda Expressions](#lambda-expressions)
  - [Built-in Functional Interfaces](#built-in-functional-interfaces)
  - [Functional Interfaces in Java Standard Library](#functional-interfaces-in-java-standard-library)

## Introduction

In Java 8, the introduction of functional interfaces provided a way to represent single-method interfaces more compactly, making it easier to work with APIs that rely on these interfaces. This guide explores the key concepts related to functional interfaces and demonstrates their usage through examples.

## Functional Interface

A functional interface is an interface with only one abstract method. It can have multiple default or static methods, but the presence of a single abstract method is essential for it to be considered a functional interface. Java 8 introduced the `@FunctionalInterface` annotation to mark interfaces as functional interfaces.

## Lambda Expressions

Lambda expressions are a concise way to express instances of functional interfaces. They provide a clear and concise syntax for writing anonymous methods, making code more readable and expressive.

```java
// Example of a lambda expression
Runnable runnable = () -> System.out.println("Hello, Functional Interfaces!");
```

## Built-in Functional Interfaces

Java 8 introduced a set of built-in functional interfaces in the `java.util.function` package, providing a versatile toolkit for functional programming. Some of the key interfaces include:

- **Predicate:** Represents a boolean-valued function of one argument. It is commonly used for filtering elements.

```java
  Predicate<String> isNotEmpty = str -> !str.isEmpty();
```

- **Function:** Represents a function that accepts one argument and produces a result. It's often used for transforming or mapping values.

```java
Function<Integer, String> convertToString = Object::toString;
```

- **Consumer:**  Represents an operation that accepts a single input argument and returns no result. It's useful for performing actions on elements.

```java
Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
```

- **Supplier:** Represents a supplier of results. It has no input arguments and produces a result.
  
```java
Supplier<Double> getRandomNumber = Math::random;
```

- **UnaryOperator and BinaryOperator:**  Special cases of functions where the input and output types are the same. UnaryOperator takes one argument, while BinaryOperator takes two.

```java
UnaryOperator<Integer> square = x -> x * x;
BinaryOperator<Integer> add = Integer::sum;
```

These built-in functional interfaces provide a foundation for working with lambda expressions and streams, simplifying common programming patterns and promoting more expressive code.

## Functional Interfaces in Java Standard Library

Many components of the Java Standard Library leverage functional interfaces. Collections, streams, and other APIs often accept functional interfaces as arguments, allowing developers to pass behavior more easily.

For example, the List interface includes the removeIf method, which takes a Predicate as an argument, allowing for concise removal of elements based on a condition:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.removeIf(name -> name.length() > 5);
```

This results in the removal of names longer than 5 characters from the list.

Explore how functional interfaces are integrated into various parts of the Java Standard Library to streamline common programming tasks.
