
/*
 The consumer interface of the functional interface is the one that accepts only one argument or a gentrified argument. 
 The consumer interface has no return value. It returns nothing. 
 There are also functional variants of the Consumer — DoubleConsumer, IntConsumer, and LongConsumer. 
 These variants accept primitive values as arguments. 

Other than these variants, there is also one more variant of the Consumer interface known as Bi-Consumer. 

Bi-Consumer – Bi-Consumer is the most exciting variant of the Consumer interface. 
The consumer interface takes only one argument, but on the other side, the Bi-Consumer interface takes two arguments. 
Both, Consumer and Bi-Consumer have no return value. It also returns nothing just like the Consumer interface. 
It is used in iterating through the entries of the map. 
 
 */

import java.util.function.Consumer;

public class ConsumerInterfaceDemo {

    public static void main(String[] args) {

        Consumer<Integer> consumer = value -> System.out.print(value);
        consumer.accept(100);

    }

}
