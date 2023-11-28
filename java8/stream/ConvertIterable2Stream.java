import java.lang.Iterable;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Stream;

public class ConvertIterable2Stream{

    public static void main(String[] args){

    Iterable<Integer> list=List.of(1,2,3,4,5,6,7,8,9);
    

    Stream<Integer> numbers=StreamSupport.stream(list.spliterator(), false);
    numbers.forEach(System.out::println);


    }


}