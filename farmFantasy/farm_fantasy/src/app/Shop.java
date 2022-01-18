package app;

public class Shop{
    
    Inventory inv = new Inventory();
    Seed seed;

    public Shop(){
        inv.addItem(new Item("Wheat Seed", 0.10, 1, 7)); //Item ID 0
        inv.addItem(new Item("Potato Seed", 0.15, 5, 10)); //Item ID 1
        inv.addItem(new Item("Corn Seed", 0.25, 10, 13)); //Item ID 2
        inv.addItem(new Item("Pumpkin seed", 0.30, 12, 17));//item ID 3
    }

    public Item getItem(int id){
        if(id < inv.getSize()){
            return inv.getItem(id);
        }
        return null;
    }

} //End class