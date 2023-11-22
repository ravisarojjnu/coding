import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item{

    int key;
    String val;

    Item(int key,String val){
        this.key=key;
        this.val=val;

    }

}

public class ConvertList2HashMapDemo {

    public static void main(String[] args){
        List<Item> itemList=new ArrayList<>();
        itemList.add(new Item(0, "a"));
        itemList.add(new Item(1, "b"));
        itemList.add(new Item(2, "c"));
        itemList.add(new Item(3, "d"));
        itemList.add(new Item(4, "e"));

        // convert list to hashmap

        Map<Integer,String> itemMap=new HashMap<>();

        itemList.forEach(item->itemMap.put(item.key, item.val));
        
        itemMap.forEach((key,val)->System.out.println(key+" : "+val));


    }
    
}
