/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_fantasy_final;

public class Item{

    String name;
    double price;
    int quantity;
    int daysToGrow;
    int daysToDie;
    int id;

    public Item(String name, double price, int id){
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Item(String name, double price, int id, int daysToGrow, int daysToDie){
        this(name, price, id);
        this.daysToDie = daysToDie;
        this.daysToGrow = daysToGrow;
    }

    public Item(String name, double price, int id, int quantity){
        this(name, price, id);
        this.quantity = quantity;
    }

    public Item(Item item, int quantity){
        name = item.getName();
        price = item.getPrice();
        this.quantity = quantity;
    }

    public int getId(){
        return id;
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

    public void daysToGrow(int days){

    }

    @Override
    public String toString(){
        return name;
    }

} //End class
