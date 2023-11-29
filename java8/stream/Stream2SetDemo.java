import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2SetDemo {

    public static void main(String[] args){



        Stream<Integer> numbers=Stream.of(1,2,3,4,5,6,6,6);

        Set<Integer>uniqueNumbers=numbers.collect(Collectors.toSet());
        uniqueNumbers.forEach(System.out::println);

    }
    
}
