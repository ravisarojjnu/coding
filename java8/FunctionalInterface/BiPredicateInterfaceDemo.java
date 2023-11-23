// Bi-Predicate – Bi-Predicate is also an extension of the Predicate functional interface, which, instead of one, 
// takes two arguments, does some processing, and returns the boolean value.

import java.util.function.BiPredicate;

public class BiPredicateInterfaceDemo {

    public static void main(String[] args){

        BiPredicate<Boolean,Boolean> and=(a,b)->a&&b;
        BiPredicate<Integer,Integer> greater=(a,b)->a>b;

        System.out.println(and.test(true, false));
        System.out.println(greater.test(5, 2));
    }

    
    
}
