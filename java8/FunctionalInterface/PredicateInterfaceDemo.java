/*
 * In scientific logic, a function that accepts an argument and, in return, generates a boolean value as an answer is known as a predicate.
 * Similarly, in the Java programming language, a predicate functional interface of Java is a type of function that accepts a single value 
 * or argument and does some sort of processing on it, and returns a boolean (True/ False) answer. 
 * 
 * The implementation of the Predicate functional interface also encapsulates the logic of filtering 
 * (a process that is used to filter stream components on the base of a provided predicate) in Java.

Just like the Consumer functional interface, Predicate functional interface also has some extensions. 
These are IntPredicate, DoublePredicate, and LongPredicate. 
These types of predicate functional interfaces accept only primitive data types or values as arguments.  

Bi-Predicate – Bi-Predicate is also an extension of the Predicate functional interface, 
which, instead of one, takes two arguments, does some processing, and returns the boolean value.
 * 
 */

import java.util.function.Predicate;

public class PredicateInterfaceDemo {

    public static void main(String[] args){
        Predicate<Boolean> not=val->!val;

        System.out.print(not.test(false));


    }
    
}
