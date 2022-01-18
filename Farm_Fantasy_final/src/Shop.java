

public class Shop{
    
    Inventory inv = new Inventory();
    Seed seed;

    public Shop(){
        inv.add(new Item("Wheat Seed", 1.00, 0, 4, 7)); //Item ID 0
        inv.add(new Item("Potato Seed", 1.20, 2, 6, 9)); //Item ID 1
        inv.add(new Item("Lettuce seed", 1.60, 3, 8, 10));//Item ID 2
        inv.add(new Item("Corn Seed", 1.95, 1, 10, 13)); //Item ID 3
        inv.add(new Item("Melon seed", 2.00, 4, 12, 15));//Item ID 4
        inv.add(new Item("Pumpkin seed", 2.10, 5, 15, 17));//Item ID 5
        inv.add(new Item("Wheat", 2.00, 6)); //Item ID 6
        inv.add(new Item("Potato", 3.00, 7)); //Item ID 7
        inv.add(new Item("Lettuce", 4.00, 8)); //Item ID 8
        inv.add(new Item("Corn", 5.00, 9)); //Item ID 9
        inv.add(new Item("Melon", 6.00, 10)); //Item ID 10
        inv.add(new Item("Pumpkin", 7.00, 11)); //Item ID 11
    }

    public Item getItem(int id){
        if(id < inv.getSize()){
            return inv.getItem(id);
        }
        return null;
    }

    public Inventory getInventory(){
        return inv;
    }

} //End class