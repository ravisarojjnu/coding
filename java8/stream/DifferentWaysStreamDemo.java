import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentWaysStreamDemo {

    static void usingCollectionDemo() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        numbers.stream().forEach(System.out::println);

    }

    static void byValue() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 8, 9);
        numbers.forEach(System.out::println);
    }

    static void usingArray() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        IntStream nums = Arrays.stream(numbers);
        nums.forEach(System.out::println);

    }

    static void emptyStream() {

        Stream<String> stream = Stream.empty();
        stream.forEach(System.out::println);

    }

    static void usingStreamBuilder() {

        Stream.Builder<Integer> stream = Stream.builder();
        stream.add(1);
        stream.add(2);
        stream.add(3);
        stream.add(4);
        Stream<Integer> numbers = stream.build();
        numbers.forEach(System.out::println);

    }

    static void usingStreamIterator() {
        Stream.iterate(2, n -> n * 2).limit(10).forEach(System.out::println);
    }

    static void usingStreamGenerator() {

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    static void usingRegexPattern(){

        String[] strings={"ABC","DEF","223","232323"};

        Stream<String> stream= Arrays.stream(strings);
        
        Pattern p=Pattern.compile("2*");

        stream.filter(p.asPredicate()).forEach(System.out::println);

    }

    public static void main(String[] args){
        usingArray();
        usingCollectionDemo();
        usingRegexPattern();
        usingStreamBuilder();
        usingStreamGenerator();
        usingStreamIterator();
        byValue();
        emptyStream();
    }



}
