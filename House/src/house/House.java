/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house;

/**
 *
 * @author User
 */
public class House {
    private String type;
    private char zone;
    private double price;
    private int numberOfRooms;
    private boolean freehold;
    
    public House(){}
    
    public House(String type, char zone, int numberOfRooms, double price, boolean freehold){
        this.type=type;
        this.zone=zone;
        this.price=price;
        this.numberOfRooms=numberOfRooms;
        this.freehold=freehold;
    }
      public House(String type, int numberOfRooms, double price){
        this.type=type;
        this.price=price;
        this.numberOfRooms=numberOfRooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getZone() {
        return zone;
    }

    public void setZone(char zone) {
        this.zone = zone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isFreehold() {
        return freehold;
    }

    public void setFreehold(boolean freehold) {
        this.freehold = freehold;
    }

      @Override
      public String toString(){
          return "zone: "+zone+"\ntype: "+type+"\nprice: $"+price+"\nnumberOfRooms: "+numberOfRooms+"\nfreehold: "+freehold;
      }
}

