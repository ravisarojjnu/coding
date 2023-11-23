// A function is a type of functional interface in Java that receives only a single argument and 
// returns a value after the required processing. There are many versions of Function interfaces 
// because a primitive type can’t imply a general type argument, so we need these versions of function interfaces. 
// Many different versions of the function interfaces are instrumental and are commonly used in primitive types 
// like double, int, long. The different sequences of these primitive types are also used in the argument.

// These versions are:

// Bi-Function
// The Bi-Function is substantially related to a Function. Besides, it takes two arguments, whereas Function accepts one argument. 

// @FunctionalInterface
// public interface BiFunction<T, U, R> 
// {
 
//    R apply(T t, U u);
//     .......
 
// }

import java.util.function.Function;


public class FunctionInterfaceDemo{


    public static void main(String[] args){

        Function<Integer,Integer> square=a->a*a;
        System.out.println(square.apply(5));


        

    }
}