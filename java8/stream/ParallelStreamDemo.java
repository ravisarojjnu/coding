// Parallel stream leverage multi-core processors, which increases its performance. 
// Using parallel streams, our code gets divide into multiple streams which can be executed parallelly on separate cores of 
// the system and the final result is shown as the combination of all the individual core’s outcomes. 

import java.util.List;

public class ParallelStreamDemo {

    public static void main(String[] args){
        List<Integer> numbers=List.of(1,2,3,4,5,6,7,8,9);
        numbers.stream().forEach(x->System.out.print(x+" "));
        System.out.println();

        numbers.parallelStream().forEach(x->System.out.print(x+" "));
    }
    
}
