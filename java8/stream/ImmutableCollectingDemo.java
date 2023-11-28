import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableCollectingDemo {

    public static void main(String[] args){
    var immutableList=Stream.of(1,2,3,4,5,6).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    immutableList.stream().forEach(System.out::println);
    
    }
    
}
