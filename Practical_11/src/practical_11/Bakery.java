/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical_11;

/**
 *
 * @author User
 */
import java.text.DecimalFormat;
public class Bakery {
    DecimalFormat twoDp = new DecimalFormat("###.00");
    private String flavour;
    private String weight;
    private int quantity;
    private double price;
    private String[] flavours = {"Chocolate Moist", "Strawberry", "Blueberry", "Cheesy Cake", "American Chocolate"};
    
    
    
    public Bakery(){
        double pricePerKg=20.0;
        this.flavour="Chocolate Moist";
        this.weight="1";
        this.quantity=1;
        
    }
    public Bakery(String flavour, String weight, int quantity){
        this.flavour=flavour;
        this.weight=weight;
        this.quantity=quantity;
    }
    
    public Bakery(String flavour, String weight, int quantity, double pricePerKg){
        this.flavour=flavour;
        this.weight=weight;
        this.quantity=quantity;
        this.price=Double.parseDouble(weight)*pricePerKg;
        
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
       // double cPrice;
        if (weight.equals("1")){
            price=25.50;
        }
            else if (weight.equals("2")){
                    price=50.00;
                    }
            else if (weight.equals("3")){
                price=70.00;
        }
        return price;
    }
    public boolean available(String flavour){
        boolean available=true;
        for (int x=0;x<=4;x++){
            if (flavour.equals(flavours[x])){
                available=true;
            }else available= false;
            }
        return available;
        }
    public void displayFlavours(){
        System.out.println("Flavours");
        for(int x=0;x<=4;x++){
            System.out.println((x+1)+". "+flavours[x]);
        }
    }
    public void priceList(){
        System.out.println("Price");
        System.out.println("(1)kg = RM25.50");
        System.out.println("(2)kg = RM50.00");
        System.out.println("(3)kg = RM70.00");
        
    }
    @Override
    public String toString(){
        return "Flavour: "+flavour+"\nWeight: "+weight+"kg"+"\nQuantity:"+quantity+"\nPrice: "+twoDp.format(price);
    }
            
    
}
