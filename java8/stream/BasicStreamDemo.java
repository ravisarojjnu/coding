// Introduced in Java 8, the Stream API is used to process collections of objects. A stream is a sequence of objects that 
// supports various methods which can be pipelined to produce the desired result.
// Note: 

// If we want to represent a group of objects as a single entity then we should go for collection.
// But if we want to process objects from the collection then we should go for streams.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamDemo {

    public static void main(String[] args){

        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumners=numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        evenNumners.forEach(System.out::println);

        
    }
    
}
