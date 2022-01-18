package app;

import java.util.Scanner;

public class Tutorial{

    Graphics g = new Graphics();
    Commands c = new Commands();
    Player player;
    Scanner sc = new Scanner(System.in);

    public void balanceExperience(Player player, PlayerManager manager) throws InterruptedException{
        
        g.tutorialHeader();
        System.out.println("Welcome " + player.getName() + " to Farm Fantasy!");
        sc.nextLine();

        System.out.println("In this tutorial, you will learn how to play this game!");
        System.out.println("");
        sc.nextLine();
        System.out.println("This is your total balance: $" + player.getBalance());
        sc.nextLine();
        System.out.println("You can use this currency to buy seeds!");
        System.out.println("");
        sc.nextLine();
        System.out.print("This is your experience bar: ");
        g.statusBar(player);
        System.out.println("");
        sc.nextLine();
        System.out.println("This shows your total experience level, which currently is " + player.getLvl());
        System.out.println("");
        shopBuy(player, manager);


        
    }

    public void shopBuy(Player player, PlayerManager manager) throws InterruptedException{

        System.out.println("Now, lets buy some seeds! First, we must open the shop.");
        sc.nextLine();
        System.out.println("To open the shop, type 'shop' into the command line. ");
        System.out.print("Enter command: ");
        sc.nextLine();
        g.shop();
        System.out.println("");
        sc.nextLine();
        System.out.println("This is your shop. Here, you can see the buying and selling price of all available seeds.");
        sc.nextLine();
        System.out.println("");
        System.out.println("Now, lets buy some seeds.");
        sc.nextLine();
        System.out.println("To buy seeds, type 'buy' into the command line.");
        System.out.print("Enter command: ");
        sc.nextLine();
        c.buy(player);
        System.out.println("");
        plotPlant(player, manager);
        
    }

    public void plotPlant(Player player, PlayerManager manager) throws InterruptedException{

        System.out.println("Now, lets plant some seeds! But first, you need a place to plant them!");
        sc.nextLine();
        g.displayPlots(player.getPlots());
        System.out.println("");
        System.out.println("This is your plot. This is where you will plant, grow and harvest your crops!");
        sc.nextLine();
        System.out.println("");
        System.out.println("Now, lets plant the seed(s) you've bought!");
        System.out.println("");
        System.out.println("To plant your seeds, type 'plant' into the command line: ");
        System.out.print("Enter command: ");
        sc.nextLine();
        c.plant(player);
        System.out.println("");
        
        
    }

    public void waterNextday() throws InterruptedException{
        System.out.println("Now that you have planted your sees(s), we must water them for them to grow.");
        sc.nextLine();
        System.out.println("To water all seeds/plants on the plot, type 'water' into the command line ");
        System.out.print("Enter command: ");
        sc.nextLine();
        System.out.println("Watering all plants.");
        for(int i = 0; i < player.getPlotSize(); i++){
            if(player.getPlots()[i].hasSeed()){
                //Reset plant thirst back to 100
                player.getPlots()[i].getSeed().setThirst(100.0);
            }
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){

        }
        sc.nextLine();
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
        System.out.println("Enter command: ");
        sc.nextLine();
        c.nextDay(player);
        sc.nextLine();
        System.out.println("Now that we've watered our seeds, they can grow into plants.");
        System.out.println("We also advise you to water your plants every two days or so. ");
        Thread.sleep(3000);
        System.out.println("Now, for the sake of the tutorial, lets grow all the seeds in your plot.");

        
    }

    public void harvestSell() throws InterruptedException {

    }

}