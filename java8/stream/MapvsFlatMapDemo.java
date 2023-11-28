// In Java, the Stream interface has a map() and flatmap() methods and both have intermediate stream operation 
// and return another stream as method output. Both of the functions map() and flatMap are used for transformation and 
// mapping operations. map() function produces one output for one input value, whereas flatMap() function produces 
// an arbitrary no of values as output (ie zero or more than zero) for each input value


import java.util.ArrayList;
import java.util.List;

public class MapvsFlatMapDemo {

    static void mapDemo(){
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(List.of(1,2));
        lists.add(List.of(3,4));
        lists.add(List.of(5,6));
        lists.add(List.of(7,8,9));
        lists.stream().map(x->x.stream().toArray()).forEach(System.out::println);
    }

    static void flatMapDemo(){
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(List.of(1,2));
        lists.add(List.of(3,4));
        lists.add(List.of(5,6));
        lists.add(List.of(7,8,9));
        lists.stream().flatMap(x->x.stream()).forEach(System.out::println);
    }


    public static void main(String[] args){

        mapDemo();
        flatMapDemo();

    }
    
}
