
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;

public class Inventory implements Serializable{

    private List<Item> items = new ArrayList<>();

    public Inventory(){

    }

    public void add(Item item){
        for(Item currentItem: items){
            if(currentItem.getName().equals(item.getName())){
                currentItem.increaseQuantity(item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void remove(int id){
        items.remove(id);
    }

    public Item getItem(int id){
        return items.get(id);
    }

    public int getSize(){
        return items.size();
    }

    public int getQuantity(int id){
        return items.get(id).getQuantity();
    }

} //End class