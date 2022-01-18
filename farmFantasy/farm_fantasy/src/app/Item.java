package app;

public class Item{

    String name;
    double price;
    int quantity;
    int daysToGrow;
    int daysToDie;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price, int daysToGrow, int daysToDie){
        this(name, price);
        this.daysToDie = daysToDie;
        this.daysToGrow = daysToGrow;
    }

    public Item(String name, double price, int quantity){
        this(name, price);
        this.quantity = quantity;
    }

    public Item(Item item, int quantity){
        name = item.getName();
        price = item.getPrice();
        this.quantity = quantity;
    }

    public int getDaysToDie(){
        return daysToDie;
    }

    public int getDaysToGrow(){
        return daysToGrow;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount){
        quantity += amount;
    }

    /*public void daysToGrow(int days){

    }*/

    @Override
    public String toString(){
        return name;
    }

} //End class