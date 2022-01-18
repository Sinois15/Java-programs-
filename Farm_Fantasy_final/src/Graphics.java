

import java.util.Scanner;

public class Graphics{

    private Game game;
    Scanner sc = new Scanner(System.in);
    
    
    

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

    public void help(){
        System.out.println("+=========================================+");
        System.out.println("|                  Help                   |");
        System.out.println("+===================+=====================+");
        System.out.println("|  Bal / Balance    |    Get Balance      |");
        System.out.println("|  Inv / Inventory  |    View Inventory   |");
        System.out.println("|       Buy         |    Buy Seeds        |");
        System.out.println("|       Sell        |    Sell Crops       |");
        System.out.println("|       Shop        |    View Shop        |");
        System.out.println("|       Plant       |    Plant Seed       |");
        System.out.println("|       Water       |    Water all plants |");
        System.out.println("|      Nextday      |    Skip to next day |");
        System.out.println("|      Harvest      |    Harvest plants   |");
        System.out.println("|       Save        |    Save Progress    |");
        System.out.println("|       Plot        |    View Plot        |");
        System.out.println("|       Help        |    View Help Menu   |");
        System.out.println("|       Quit        |    Exit Game        |");
        System.out.println("+===================+=====================+");
    }

    public void loginRegister(){
        System.out.println("+===============+================+");
        System.out.println("|     Login     |    Register    |");
        System.out.println("+===============+================+");
        System.out.println();
    }

    public void statusBar(Player player){
        int a,b;
        a=0;

        System.out.print("Lv:" + player.getLvl());
        System.out.format("%s%.2f\n","      Coins: $", player.getBalance());
        System.out.println("+====================+");
        System.out.print("{");
        for(b=1;b<=(player.getExp()/(0.05*player.getExpPerLvl()*player.getLvl()));b++){
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
    //Make this a shop for selling only
    public void shop(){
       System.out.println("+=================================================+");
       System.out.println("|                      SHOP                       |");   
       System.out.println("+======+============+==============+==============+"); 
       System.out.println("|  ID  |    SEED    |      BUY     |     SELL     |");
       System.out.println("+======+============+==============+==============+");   
       System.out.println("|  0   |   Wheat    |     $1.00    |     $2.00    |");   
       System.out.println("|  1   |   Corn     |     $1.20    |     $2.40    |");
       System.out.println("|  2   |   Potato   |     $1.60    |     $2.00    |");
       System.out.println("|  3   |   Lettuce  |     $1.95    |     $3.00    |");
       System.out.println("|  4   |   Melon    |     $2.00    |     $3.50    |");
       System.out.println("|  5   |   Pumpkin  |     $2.10    |     $3.95    |");    
       System.out.println("+======+============+==============+==============+"); 

    }
    //Make this show available seeds for buying only
    public void seedShop(){
        System.out.println("+================================================+");
        System.out.println("|                   SEED SHOP                    |");   
        System.out.println("+=======+=====================+==================+");   
        System.out.println("|   ID  |         SEED        |       PRICE      |");  
        System.out.println("+=======+=====================+==================+");   
        System.out.println("|   0   |     Wheat Seed      |       $1.00      |");   
        System.out.println("|   1   |     Corn Seed       |       $1.20      |");
        System.out.println("|   2   |     Potato Seed     |       $1.60      |");
        System.out.println("|   3   |     Lettuce Seed    |       $1.95      |");
        System.out.println("|   4   |     Melon Seed      |       $2.00      |");
        System.out.println("|   5   |     Pumpkin Seed    |       $2.10      |");
        System.out.println("+=======+=====================+==================+");   

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

    public void sellInv(Player player){
        String format = "%-7s%-8d%-4s%-13s%-7s%-9d%s\n";
        boolean empty = true;
        System.out.println("+===============================================+");
        System.out.println("|               AVAILABLE ITEMS                 |");   
        System.out.println("+==============+================+===============+");
        System.out.println("|      ID      |    ITEM NAME   |   QUANTITY    |");
        System.out.println("+==============+================+===============+");
        for(int i =  0; i < player.getInventory().getSize(); i++){
            //Checks if the name of the item name does not contain 'seed'.
            if(!player.getInventory().getItem(i).getName().toLowerCase().contains("seed")){
                System.out.format(format, "|", i, "|", player.getInventory().getItem(i), "|", player.getInventory().getItem(i).getQuantity(), "|" );
                //Inventory contains at least 1 seed so it is not empty.
                empty = false;
            }
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

    public void seedInv(Player player){
        String format = "%-7s%-8d%-4s%-13s%-7s%-9d%s\n";
        boolean empty = true;
        System.out.println("+===============================================+");
        System.out.println("|               AVAILABLE SEEDS                 |");   
        System.out.println("+==============+================+===============+");
        System.out.println("|      ID      |      SEED      |   QUANTITY    |");
        System.out.println("+==============+================+===============+");
        //For loop to check all items.
        for(int i = 0; i < player.getInventory().getSize(); i++){
            //Checks if the name of the item name contains 'seed'.
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