package app;

import java.util.Scanner;

public class Graphics{

    Game game;
    int gridSize;
    Scanner sc = new Scanner(System.in);
    String[][] field = new String[9][9];
    boolean error;
    

    public void displayPlots(Plot[] plots){
        int plotNum = 0;
        for(int i = 0; i < game.plotSize; i++){
            for(int j = 0; j < game.plotSize; j++){
                System.out.print("+-----");
            }
            System.out.println("+");
            for(int k = 0; k < game.plotSize; k++){
                if(plotNum < 10 && plots[plotNum].hasSeed()){
                    System.out.print("| " + plots[plotNum].getSeed() + " ");
                    plotNum++;
                } else if(plotNum < 10){
                    System.out.print("|  " + plotNum + "  ");
                    plotNum++;
                } else if(plotNum >= 10 && plots[plotNum].hasSeed()){
                    System.out.print("| " + plots[plotNum].getSeed() + " ");
                    plotNum++;
                } else {
                    System.out.print("| " + plotNum + "  ");
                    plotNum++;                    
                }
            }
            System.out.println("|");
        }
        for(int j = 0; j < game.plotSize; j++){
            System.out.print("+-----");
        }
        System.out.println("+");
        System.out.println();
    }

    public void statusBar(Player player){
        int a,b;
        a=0;

        System.out.print("Lv:" + player.getLvl());
        System.out.format("%s%.2f\n","      Coins: $", player.getBalance());
        System.out.println("+====================+");
        System.out.print("{");
        for(b=1;b<=(player.getExp()/(0.05*player.getExpPerLvl()));b++){
            System.out.print("|");
            a++;
        }
        for(b=1;b<=20-a;b++){
            System.out.print(" ");
        }
        System.out.println("}");
        System.out.println("+====================+");
        System.out.println("EXP: "+ player.getExp());
    }

    public void tutorialHeader(){
        System.out.println("+========================+");
        System.out.println("|        TUTORIAL        |");
        System.out.println("+========================+");
        System.out.println("");
    }

    public void mainMenu(){
        System.out.println("+=================+");
        System.out.println("|  Play  |  Quit  |");
        System.out.println("+=================+");
        System.out.println();
        System.out.println("Type 'Play' or 'Quit'.");
    }

    public void shop(){
       System.out.println("+=================================================+");
       System.out.println("|                       SHOP                      |");   
       System.out.println("+=================================================+"); 
       System.out.println("|       SEED        |      BUY     |     SELL     |");
       System.out.println("+===================+==============+==============+");   
       System.out.println("|    W = Wheat      |     $1.00    |     $2.00    |");   
       System.out.println("|    C = Corn       |     $1.20    |     $2.40    |");
       System.out.println("|    P = Potato     |     $1.60    |     $2.00    |");
       System.out.println("|    L = Lettuce    |     $1.95    |     $3.00    |");
       System.out.println("|    K = Pumpkin    |     $2.00    |     $3.50    |");
       System.out.println("|    M = Melon      |     $2.10    |     $3.95    |");    
       System.out.println("+===================+==============+==============+"); 

    }

    public void seedShop(){
        System.out.println("+================================================+");
        System.out.println("|                   SEED SHOP                    |");   
        System.out.println("+================================================+");        
    }

    public void displayInventory(Player player){
        boolean empty = true;
        String format = "%-7s%-16s%-12s%-13d%s\n";
        System.out.println();
        System.out.println("Your balance is $" + player.getBalance());
        System.out.println("");
        System.out.println("+===============================================+");
        System.out.println("|                   INVENTORY                   |");
        System.out.println("+===============================================+");
        System.out.println("|         ITEM         |         AMOUNT         |");
        System.out.println("+======================+========================+");
        for(int i = 0; i < player.getInventory().getSize(); i++){
            System.out.format(format, "|", player.getInventory().getItem(i), "|", player.getInventory().getQuantity(i), "|");
            empty = false;
        }
        if(empty){
            System.out.println("|                NO ITEMS FOUND!                |");
        }        
        System.out.println("+======================+========================+");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){
            
        }
    }

    public void plantSeed(Player player){
        String format = "%-7s%-8d%-4s%-13s%-7s%-9d%s\n";
        boolean empty = true;
        System.out.println("+======================+========================+");
        System.out.println("|               AVAILABLE SEEDS                 |");   
        System.out.println("+======================+========================+");
        System.out.println("|      ID      |      SEED      |   QUANTITY    |");
        System.out.println("+======================+========================+");
        //For loop to check all items.
        for(int i = 0; i < player.getInventory().getSize(); i++){
            //Checks if the name of the item contains 'seed'.
            if(player.getInventory().getItem(i).getName().toLowerCase().contains("seed")){
                System.out.format(format, "|", i, "|", player.getInventory().getItem(i), "|", player.getInventory().getItem(i).getQuantity(), "|" );
                //Inventory contains at least 1 seed so it is not empty.
                empty = false;
            }
        }
        //If there are no seeds.
        if(empty){
            System.out.println("|                NO SEEDS FOUND!                |");
        }
        System.out.println("+======================+========================+");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){
            
        }
    }      
} //End of class