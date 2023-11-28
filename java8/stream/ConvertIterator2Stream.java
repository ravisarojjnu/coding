import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import java.util.stream.Stream;

public class ConvertIterator2Stream {

    public static void main(String[] args) {

        Iterator<Integer> numItr = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).iterator();
        Spliterator<Integer> split=Spliterators.spliteratorUnknownSize(numItr,0);
        Stream<Integer> stream=StreamSupport.stream(split, false);
        stream.forEach(System.out::println);
    }

}
