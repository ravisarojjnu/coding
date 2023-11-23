// The Supplier functional interface is also a type of functional interface that does not take any input or argument and 
// yet returns a single output. This type of functional interface is generally used in the lazy generation of values. 
// Supplier functional interfaces are also used for defining the logic for the generation of any sequence. 
// For example – The logic behind the Fibonacci Series can be generated with the help of the Stream. 
// generate method, which is implemented by the Supplier functional Interface. 

// The different extensions of the Supplier functional interface hold many other suppliers functions like BooleanSupplier, 
// DoubleSupplier, LongSupplier, and IntSupplier. The return type of all these further specializations is their corresponding 
// primitives only. 

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierInterfaceDemo {
    public static void main(String[] args)
    {
        Supplier<Stream<Long>> fibonacciSeq=()->Stream.iterate(new Long[]{0l,1l},pair->new Long[]{pair[1],pair[0]+pair[1]}).map(pair->pair[0]);
    
     fibonacciSeq.get().limit(5).forEach(System.out::println);
    
    }

}
