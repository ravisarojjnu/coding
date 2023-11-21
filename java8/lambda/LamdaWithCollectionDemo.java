import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class ArrayListDemo{

    static void starunDemo(){
         
        List<Integer> numbers= new ArrayList<>();
        numbers.add(3);
        numbers.add(8);
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
        Collections.sort(numbers,(x,y)->(x>y)?-1:x<y?1:0);
        //printing the sorted numbers
        numbers.forEach(x->System.out.print(x+" "));
        System.out.println();

    }
}

class TreeSetDemo{

    static void starunDemo(){
         
        Set<Integer> numbers= new TreeSet<>((x,y)->(x>y?-1:x<y?1:0));
        numbers.add(3);
        numbers.add(8);
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
    
        //printing the sorted numbers
        numbers.forEach(x->System.out.print(x+" "));
        System.out.println();

    }
}



public class LamdaWithCollectionDemo {

    public static void main(String[] args){
        ArrayListDemo.starunDemo();
        TreeSetDemo.starunDemo();

    }
}
