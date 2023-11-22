import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterDemo {

    public static void main(String[] args) {

        //filter even num example
        List<Integer> numbers=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer>evenNumbers=numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        evenNumbers.forEach(n->System.out.print(n+" "));
        System.out.println();


        //remove null example
        List<String> strings=new ArrayList<>(Arrays.asList("1",null,null,"4",null,null,"7",null,"9"));
        List<String>nonNullStrings=strings.stream().filter(Objects::nonNull).collect(Collectors.toList());
        nonNullStrings.forEach(n->System.out.print(n+" "));

    }

}
