
// Bi-Function
// The Bi-Function is substantially related to a Function. Besides, it takes two arguments, whereas Function accepts one argument. 

// @FunctionalInterface
// public interface BiFunction<T, U, R> 
// {
 
//    R apply(T t, U u);
//     .......
 
// }

import java.util.function.BiFunction;

public class BiFunctionInterfaceDemo {

    public static void main(String[] args){
        BiFunction<Integer,Integer,Integer> sum=(a,b)->a+b;

        System.out.print(sum.apply(1, 33));

    }
    
}
