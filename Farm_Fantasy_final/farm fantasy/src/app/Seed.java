 package app;

import java.io.Serializable;

public class Seed implements Serializable{

    private String name;
    private String symbol;
    private int dayPlanted;
    private int daysToGrow;
    private int daysToDie;
    private double thirst;
    private int id;

    public Seed(Item item, int dayPlanted, int daysToGrow, int daysToDie, String symbol){
        this.name = item.getName();
        this.dayPlanted = dayPlanted;
        this.daysToGrow = daysToGrow;
        this.symbol = symbol;
        this.daysToDie = daysToDie;   
        this.thirst = 100.0;
        this.id = item.getId();
    }

    public int getId(){
        return id;
    }

    public boolean killThirst(){
        return thirst <= 0;
    }

    public boolean isThirsty(){
        return thirst <= 50;
    }

    public void setThirst(double thirst){
        if(thirst<=100){
            this.thirst = thirst;
        }
    }

    public double getThirst(){
        return thirst;
    }

    public void growth(Player player){
        double time = player.getDay() - dayPlanted;
        if(name.toLowerCase().equals("wheat seed")){
            switch(symbol){
                case " . ":
                    if (time >= 0.33 * daysToGrow){
                        this.symbol = " , ";
                    }
                    break;
                case " , ":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = " w ";
                    }
                    break;
                case " w ":
                    if(time >= daysToGrow){
                        this.symbol = " W ";
                    }
            }
        }
        if(name.toLowerCase().equals("corn seed")){
            switch(symbol){
                case " . ":
                    if(time >= 0.33 * daysToGrow){
                        this.symbol = " , ";
                    }
                    break;
                case " , ":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = " c ";
                    }
                    break;
                case " c ":
                    if(time >= daysToGrow){
                        this.symbol = " C ";
                    }
                    break;
            }            
        }
        if(name.toLowerCase().equals("potato seed")){
            switch(symbol){
                case " . ":
                    if(time >= 0.33 * daysToGrow){
                        this.symbol = " , ";
                    }
                    break;
                case " , ":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = " p ";
                    }
                    break;
                case " p ":
                    if(time >= daysToGrow){
                    this.symbol = " P ";
                    }
                    break;
            }            
        }
        if(name.toLowerCase().equals("pumpkin seed")){
            switch(symbol){
                case " . ":
                    if(time >= 0.33 * daysToGrow){
                        this.symbol = "|,|";
                    }
                    break;
                case "|,|":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = "|p|";
                    }
                    break;
                case "|p|":
                    if(time >= daysToGrow){
                        this.symbol = "|P|";
                    }
                    break;
            }            
        }
        if(name.toLowerCase().equals("melon seed")){
            switch(symbol){
                case " . ":
                    if(time >= 0.33 * daysToGrow){
                        this.symbol = " , ";
                    }
                    break;
                case " , ":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = " m ";
                    }
                    break;
                case " m ":
                    if(time >= daysToGrow){
                        this.symbol = " M ";
                    }
                    break;
            }            
        }
        if(name.toLowerCase().equals("lettuce seed")){
            switch(symbol){
                case " . ":
                    if(time >= 0.33 * daysToGrow){
                        this.symbol = " , ";
                    }
                    break;
                case " , ":
                    if(time >= 0.66 * daysToGrow){
                        this.symbol = " l ";
                    }
                    break;
                case " l ":
                    if(time >= daysToGrow){
                        this.symbol = " L ";
                    }
                    break;
            }            
        }

        
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getDayPlanted(){
        return dayPlanted;
    }

    public int getDaysToGrow(){
        return daysToGrow;
    }

    public int getDaysToDie(){
        return daysToDie;
    }

    public void updateSeed(Player player, int i) {
        //Kill plant
        if (player.getDay() - player.getPlots()[i].getSeed().getDayPlanted() >= player.getPlots()[i].getSeed().getDaysToDie()) {
            player.getPlots()[i].killPlant();
        }
    }

    public boolean isMature(Player player){
        return dayPlanted + daysToGrow - player.getDay() <= 0;
    }

    @Override
    public String toString(){
        return symbol;
    }

} //End class