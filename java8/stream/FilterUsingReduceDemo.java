// we need to perform operations where a stream reduces to a single resultant value, for example, maximum, minimum, 
// sum, product, etc. Reducing is the repeated process of combining all elements. reduce operation applies a binary operator 
// to each element in the stream where the first argument to the operator is the return value of the previous application and 
// the second argument is the current stream element. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterUsingReduceDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
        List<Integer> evenNumbers=numbers.stream().reduce(new ArrayList<Integer>(), (a, b) -> {
            if (b % 2 == 0)
                a.add(b);
            return a;
        }, (a, b) -> {
            a.addAll(b);
            return a;
        });
        evenNumbers.forEach(System.out::println);

    }

}
