// Using Arrays.stream() :

// Syntax :

// public static <T> Stream<T> getStream(T[] arr)
// {
//   return Arrays.stream(arr);
// }

// where, T represents generic type.

import java.util.Arrays;

public class Array2StreamDemo {



    public static void main(String[] args){

        String[] strings={"abc","wxyz"};
        Arrays.stream(strings).map(x->x.length()).forEach(System.out::println);


    }
    
}
