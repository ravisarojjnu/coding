# Lambda Expressions in Java 8

Lambda expressions are a new feature introduced in Java 8 that allow you to write anonymous functions in a concise and elegant way. A lambda expression is a function that can be passed as an argument to another function, or stored in a variable, or returned from a function. Lambda expressions are also known as closures or functional interfaces.

A lambda expression has the following syntax:

```code
(parameters) -> expression
```

or

```code
(parameters) -> { statements; }
```

The parameters are the input arguments of the function, and the expression or statements are the body of the function. The type of the parameters can be inferred by the compiler, or explicitly specified. The return type of the lambda expression is also inferred by the compiler, or determined by the context where the lambda expression is used.

For example, suppose we have a list of strings, and we want to sort them by their length. We can use a lambda expression to define a custom comparator function that compares two strings by their length, and pass it to the Collections.sort() method:

```java

List<String> words = Arrays.asList("hello", "world", "java", "lambda");
Collections.sort(words, (s1, s2) -> s1.length() - s2.length());

```

The lambda expression (s1, s2) -> s1.length() - s2.length() takes two strings as parameters, and returns the difference of their lengths as an integer. This is equivalent to writing an anonymous class that implements the Comparator interface:

```java
Collections.sort(words, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});

```

As you can see, the lambda expression is much more concise and readable than the anonymous class.

Lambda expressions can be used with any functional interface, which is an interface that has only one abstract method. Java 8 provides many built-in functional interfaces in the java.util.function package, such as Predicate, Function, Consumer, Supplier, etc. You can also create your own functional interfaces by using the @FunctionalInterface annotation.

For example, suppose we have a functional interface called Calculator that defines a single abstract method called calculate that takes two integers as parameters and returns an integer:

```java
@FunctionalInterface
public interface Calculator {
    int calculate(int x, int y);
}

```

We can use a lambda expression to create an instance of this interface and assign it to a variable:

Calculator adder = (x, y) -> x + y;

Then we can use this variable to invoke the calculate method:

int result = adder.calculate(10, 20); // result = 30

We can also pass this variable as an argument to another method that expects a Calculator instance:

```java
public static void printResult(Calculator calculator, int x, int y) {
    System.out.println(calculator.calculate(x, y));
}

printResult(adder, 10, 20); // prints 30
```

Lambda expressions are very useful for writing concise and expressive code that can be easily parallelized using streams and other features of Java 8. They also enable functional programming in Java, which is a paradigm that focuses on pure functions and immutable data structures.