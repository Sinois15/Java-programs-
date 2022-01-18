package app;

import java.util.Scanner;

public class Tutorial{

    private Graphics g = new Graphics();
    private Commands c = new Commands();
    private Scanner sc = new Scanner(System.in);

    public void balanceExperience(Player player, PlayerManager manager) throws InterruptedException{
        
        g.tutorialHeader();
        System.out.println("Welcome " + player.getName() + " to Farm Fantasy!");
        Thread.sleep(2200);

        System.out.println("In this tutorial, you will learn how to play this game!");
        System.out.println("");
        Thread.sleep(2200);
        System.out.println("This is your total balance: $" + player.getBalance());
        Thread.sleep(2200);
        System.out.println("You can use this currency to buy seeds!");
        System.out.println("");
        Thread.sleep(2200);
        System.out.println("This is your experience bar: ");
        g.statusBar(player);
        System.out.println("");
        Thread.sleep(2200);
        System.out.println("This shows your total experience level, which currently is " + player.getLvl());
        System.out.println("");
        shopBuy(player, manager);


        
    }

    public void shopBuy(Player player, PlayerManager manager) throws InterruptedException{

        System.out.println("Now, lets buy some seeds! First, we must open the shop.");
        Thread.sleep(2200);
        System.out.println("To open the shop, type 'shop' into the command line. ");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("shop")){
            System.out.println("That's not how you spell 'shop'! It's okay, we'll help you with that.");
        }
        g.shop();
        System.out.println("");
        Thread.sleep(2200);
        System.out.println("This is your shop. Here, you can see the buying and selling price of all available seeds.");
        Thread.sleep(2200);
        System.out.println("");
        System.out.println("Now, lets buy some seeds.");
        Thread.sleep(2200);
        System.out.println("To buy seeds, type 'buy' into the command line.");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("buy")){
            System.out.println("That's not how you spell 'buy'! It's okay, we'll help you with that.");
        }
        c.buy(player);
        System.out.println("");
        plotPlant(player, manager);
        
    }

    public void plotPlant(Player player, PlayerManager manager) throws InterruptedException{

        System.out.println("Now, lets plant some seeds! But first, you need a place to plant them!");
        Thread.sleep(2200);
        g.displayPlots(player.getPlots());
        System.out.println("");
        System.out.println("This is your plot. This is where you will plant, grow and harvest your crops!");
        Thread.sleep(2200);
        System.out.println("");
        System.out.println("Now, lets plant the seed(s) you've bought!");
        System.out.println("");
        System.out.println("To plant your seeds, type 'plant' into the command line: ");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("plant")){
            System.out.println("That's not how you spell 'plant'! It's okay, we'll help you with that.");
        }
        c.plant(player);
        System.out.println("");
        waterNextDay(player, manager);
    }

    public void waterNextDay(Player player, PlayerManager manager) throws InterruptedException{
        System.out.println("Now that you have planted your seeds(s), we must water them for them to grow.");
        Thread.sleep(2200);
        System.out.println("To water all seeds/plants on the plot, type 'water' into the command line ");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("water")){
            System.out.println("That's not how you spell 'water'! It's okay, we'll help you with that.");
        }
        System.out.println("Watering all plants.");
        for(int i = 0; i < player.getPlotSize(); i++){
            if(player.getPlots()[i].hasSeed()){
                //Reset plant thirst back to 100
                player.getPlots()[i].getSeed().setThirst(100.0);
            }
        }
        try{
            Thread.sleep(1000);
        } 
        catch (InterruptedException ie){

        }
        Thread.sleep(2200);
        System.out.println("Now that you have watered your plant, it has to grow.");
        Thread.sleep(3000);
        System.out.println("Each plant has a random amount of days required for it to be fully grown.");
        Thread.sleep(3000);
        System.out.println("To make the plant grow faster, we can skip days. ");
        System.out.println("");
        Thread.sleep(3000);
        System.out.println("IMPORTANT NOTE: ");
        System.out.println("Each plant also has a predefined amount of days it can be alive without being watered before it dies");
        System.out.println("So, we advise you to not spam the nextday command, in order to keep your plants alive and healthy.");
        Thread.sleep(3000);
        System.out.println("To skip a day. type 'nextday' into the command line");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("nextday")){
            System.out.println("That's not how you spell 'nextday'! It's okay, we'll help you with that.");
        }
        c.nextDay(player);
        Thread.sleep(2200);
        System.out.println("Now that we've watered our seeds, they can grow into plants.");
        System.out.println("We also advise you to water your plants every two days or so. ");
        Thread.sleep(3000);
        System.out.println("Now, for the sake of the tutorial, lets grow all the seeds in your plot.");
        for(int i = 0; i < player.getPlotSize(); i++){
            if(player.getPlots()[i].hasSeed()){
                player.getPlots()[i].getSeed().setDaysToGrow(0);
                player.getPlots()[i].getSeed().setDaysToDie(100);
                player.setDay(10);
                for(int j = 0; j < 4; j++){
                    player.getPlots()[i].getSeed().growth(player);
                }
            }
        }
        g.displayPlots(player.getPlots());
        System.out.println("");
        harvestInvSell(player);
        
    }

    public void harvestInvSell(Player player) throws InterruptedException {

        System.out.println("Now that all the seeds have become fully gorwn crops, its time for the harvest!");
        Thread.sleep(2200);
        System.out.println("To harvest the crops, type 'harvest' into the command line");
        System.out.print("Enter command: ");
        sc.nextLine();
        c.harvest(player);
        Thread.sleep(2200);
        System.out.println("Now that we have harvested all the crops, we can see the quantity in your inventory.");
        Thread.sleep(2200);
        System.out.println("To open inventory, type 'inventory' or 'inv' into the command line");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("inventory")){
            System.out.println("That's not how you spell 'inventory'! It's okay, we'll help you with that.");
        }
        g.displayInventory(player);
        Thread.sleep(2200);
        System.out.println("Now that we have crops, we can sell them for a profit!");
        Thread.sleep(2200);
        System.out.println("To sell crops, type 'sell' into the command line ");
        System.out.print("Enter command: ");
        if(!sc.nextLine().toLowerCase().equals("sell")){
            System.out.println("That's not how you spell 'sell'! It's okay, we'll help you with that.");
        }
        c.sell(player);
        Thread.sleep(2200);
        System.out.println("If you experience any issues or are stuck, type 'help' into the command line.");
        System.out.println("PRO TIP: If you are stuck inside a command and cannot escape, type 'cancel' or 'home' into the next input.");
        sc.nextLine();
    }

}