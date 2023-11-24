// Filter API takes a Predicate. The predicate is a Functional Interface. It takes an argument of any type and returns Boolean. 
// The element will be considered for the next API in the pipeline if the function returns true. 
// Otherwise, the element is filtered out.

// Filter by Object Properties.
// Filter by Index.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class StreamFilterDemo {

    static void filterByObjectProperties(){
        class Item{
            String name;
            int price;
            Item(String name,int price){
                this.name=name;
                this.price=price;
            }
        }

        List<Item> items=new ArrayList<>();
        items.add(new Item("A",12));
        items.add(new Item("B",332));
        items.add(new Item("C",92));
        items.add(new Item("D",22));

        items.stream().filter(a->a.price>100).forEach(x->System.out.println(x.name+" "+x.price));

    }


    static void filterByIndex(){

        class Item{
            String name;
            int price;
            Item(String name,int price){
                this.name=name;
                this.price=price;
            }
        }

        List<Item> items=new ArrayList<>();
        items.add(new Item("A",12));
        items.add(new Item("B",332));
        items.add(new Item("C",92));
        items.add(new Item("D",22));
        AtomicInteger i=new AtomicInteger(0);

        items.stream().filter(a->i.getAndIncrement()%2==0).forEach(x->System.out.println(i.get() +" "+x.name+" "+x.price));

        IntStream.rangeClosed(0,items.size()-1).filter(a->a%2==0).mapToObj(items::get).forEach(x->System.out.println(i.get() +" "+x.name+" "+x.price));

    }


    public static void main(String[] args){
        filterByObjectProperties();
        filterByIndex();
        
    }

    
    
}
