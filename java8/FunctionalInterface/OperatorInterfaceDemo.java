// Unary Operator and Binary Operator
// There are also two other functional interfaces which are named Unary Operator and Binary Operator. 
// They both extend the Function and Bi-Function, respectively. In simple words, Unary Operator extends Function, 
// and Binary Operator extends Bi-Function. 

// The prototype of the Unary Operator and Binary Operator is mentioned below : 

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class OperatorInterfaceDemo{


    public static void main(String[] args){

        UnaryOperator<Integer> increment=a-> ++a;
        BinaryOperator<Integer> sum=(a,b)-> a+b;

        System.out.println(increment.apply(10));
        System.out.println(sum.apply(10,10));


    }
}