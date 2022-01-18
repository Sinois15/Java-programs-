

import java.io.Serializable;

public class Player implements Serializable{

    private String name;
    private String password;
    private double balance;
    private int day;
    private int lvl;
    private int expPerLvl;
    private int exp;
    private Plot[] plots;
    private int plotSize;
    private Inventory inventory;
    private int plotsOwned = 0;

    public Player(String name, String password, int plotSize, double balance, int exp, int lvl){
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.expPerLvl = 100;
        this.lvl = lvl;
        this.inventory = new Inventory();
        this.plotSize = plotSize;
        this.plots = new Plot[plotSize*plotSize];
        //Creating x amount of plot objects.
        for(int i = 0; i < plots.length; i++){
            plots[i] = new Plot();
        }
    }
    //Currently not in use.
    public Player(String name, String password, int plotSize, double balance, int exp, int lvl, int day, Plot[] plots){
        this(name, password, plotSize, balance, exp, lvl);
        this.plots = plots;
        this.day = day;

        for(Plot plot: plots){
            if(plot != null){
                plotsOwned++;
            }
        }
    }

    public int getPlotLength(){
        return plotSize;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void addExp(int amount){
        exp += amount;
    }    

    public int getPlotSize(){
        return plots.length;
    }

    public int getExpPerLvl(){
        return expPerLvl;
    }

    public int getLvl(){
        return lvl;
    }

    public void levelUp(){
        boolean done = false;
        while(!done){
            if(exp > expPerLvl * lvl){
                this.exp -= expPerLvl * lvl;
                this.lvl++;
            }
            if(exp < expPerLvl * lvl){
                done = true;
            }
        }
    }

    public void setLvl(int lvl){
        this.lvl = lvl;
    }

    public int getExp(){
        return exp;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public Plot[] getPlots(){
        return plots;
    }

    @Override
    public String toString(){
        return "Username: " + name + "\nBalance: " + balance;
    }

}//End class