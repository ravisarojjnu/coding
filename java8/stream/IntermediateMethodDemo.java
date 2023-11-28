// the Intermediate methods of the Stream API. All these methods are in java.util.stream.Stream. 
// Intermediate operators do not execute until a terminal operation is invoked, i.e. they are not executed until a result 
// of processing is actually needed.
// filter(predicate) Method 
// sorted() Method 
// distinct() Method 
// map() Method

import java.util.List;

public class IntermediateMethodDemo {

    static void filterDemo() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // filter number that are divisible by 3
        System.out.println("Numbers divisble by 3: ");
        numbers.stream().filter(x -> x % 3 == 0).forEach(System.out::println);

    }

    static void sortedDemo() {
        List<Integer> numbers = List.of(9, 2, 3, 6, 5, 8, 7, 6, 1);

        // filter number that are divisible by 3
        System.out.println("sorted number: ");
        numbers.stream().sorted().forEach(System.out::println);

    }

    static void distinctDemo() {
        List<Integer> numbers = List.of(5, 5, 3, 6, 5, 3, 7, 3, 3);

        // filter number that are divisible by 3
        System.out.println("Distinct numbers: ");
        numbers.stream().distinct().forEach(System.out::println);

    }

    static void mapDemo() {
        List<Integer> numbers = List.of(5, 5, 3, 6, 5, 3, 7, 3, 3);

        // filter number that are divisible by 3
        System.out.println("Multiply numbers by 2: ");
        numbers.stream().map(x->x*2).forEach(System.out::println);

    }

    public static void main(String[] args) {

        filterDemo();
        sortedDemo();
        distinctDemo();
        mapDemo();

    }

}
