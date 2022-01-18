/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_fantasy_final;

import java.lang.Thread;
import java.util.Scanner;
import java.lang.InterruptedException;
import java.util.InputMismatchException;

public class Game {

    public static String username;
    public static double balance = 100.0;
    public static int plotSize;

    Graphics g = new Graphics();
    Commands c = new Commands();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //To remove the use of static for every method.
        new Game().run();
        
    }

    public void run(){
        //Infinite loop until 'Play' or 'Quit' has been chosen. 
        boolean x = true;
        while(x){
            //input play or quit
            g.mainMenu();
            String option = sc.nextLine().toLowerCase();
            switch(option){
                //play will go to tutorial
                case "play":
                    //Create player object.
                    Player player = createPlayer();
                    /*try{
                        //Try to run tutorial with player object.
                        tutorial(player);
                    } catch (InterruptedException ie){
                        System.out.println("Tutorial was interrupted.");
                    }*/
                    //Run main game with player object.
                    //g.createPlots();
                    player.setDay(1);
                    game(player);
                    break;
                //quit will exit the program
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        
    }

    public void game(Player player){
        //Creates an infinite loop of the main game (will not exit unless the 'quit' command has been called.).
        boolean infiniteLoop = true;
        while(infiniteLoop){
            player.levelUp();
            //Create new thread "IdleCheck".
            System.out.println("Day: " + player.getDay());
            System.out.println();
            g.statusBar(player);
            g.displayPlots(player.getPlots());
            //todo: Call graphics.
            System.out.print("Enter Command: ");
            c.command(sc.nextLine(), player);
            System.out.println();
        }
        
    }

    public Player createPlayer(){
        //Prompt user to key in username
        do{
            System.out.print("Please enter username: ");
            username = sc.nextLine();
            //validation for username. no spacing and cannot be blank
            if(username.equals("")){
                System.out.println("Invalid Username: Username cannot be blank.");
            } else if(username.contains(" ")){
                System.out.println("Invalid Username: Username cannot have spaces.");
            }
        }
        while(username.contains(" ") || username.equals(""));
        boolean error;
        do{
            try{
                System.out.print("Enter desired plot size: ");
                plotSize = Integer.parseInt(sc.nextLine());
                error=false;
                if(plotSize < 0){
                    System.out.println("Plot size cannot be negative.");
                } else if(plotSize > 9) {
                    System.out.println("Plot size cannot be greater than 9.");
                }
            }catch(InputMismatchException e){
                System.out.println("Plot size should be a positive number which is less than 9.");
                error=true;
            }
        }
        while(plotSize < 0 || plotSize > 9 || error);
        return new Player(username, balance, plotSize, 0, 1);
    }
    
    public void tutorial(Player player) throws InterruptedException{
        //to show the player a tutorial, describing working of the different commands
     
        g.tutorialHeader();
        System.out.println("Welcome " + player.getName() + " to Farm Fantasy!!!");
        Thread.sleep(3000);
        //to give some delay between text prompts

        System.out.println();
        System.out.println("In this tutorial we will be showing you how to play this game");
        Thread.sleep(3000);
        System.out.println();
        g.displayPlots(player.getPlots());
        //to generate and show a plot
        System.out.println();
        System.out.println("This is your plot. You can plant seeds here, and harvest the fully grown crops. But first, we need you to buy some seeds!");
        System.out.println();
        System.out.println("This is your balance: " + player.getBalance());
        Thread.sleep(1000);
        System.out.println("Now, lets buy some seeds! First, we need to open the shop");
        Thread.sleep(2000);
        System.out.println("To open the shop, type 'shop' into the command line");
        Thread.sleep(1000);
        System.out.println("Enter command: ");
        c.command(sc.nextLine() , player);
        //to show the shop

        System.out.println();
        Thread.sleep(2000);
        System.out.println("This is the shop, here you can see the cost of buying a seed, and also the selling price of the fully grown crop.");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To buy a seed, type 'buy' into the command line: ");
        Thread.sleep(1000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player);
        //to call the buy method so the user can buy a seed
        System.out.println();
        Thread.sleep(3000);
        System.out.println("");
        System.out.println("Now that you have bought a seed, lets plant it! ");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To plant the seed, type 'plant' into the command line: ");
        Thread.sleep(1000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player);
        //to call the plant method so the user can plant the seed
        Thread.sleep(3000);
        System.out.println();
        System.out.println("Your seed has now been planted");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("Every 2 minutes you spend in real life, one day passes in the game");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("Each seed you plant has a certain amount of days that need to pass before it is fully grown.");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("Lets speed up the growth of your seed here!");
        c.nextDay(player);
        c.nextDay(player);
        c.nextDay(player);
        g.displayPlots(player.getPlots());
        Thread.sleep(3000);
        System.out.println("Now that your seed is fully grown, it has a certain amount of days that can pass before it dies.");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("So, you need to harvest the fully grown crop before that happens to make a return on your investment!");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To harvest the seed, type 'harvest' into the command line");
        System.out.println();
        Thread.sleep(3000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player);
        //to call the harvest method so the user can harvest the crop
        System.out.println("Now that you have harvested your crops, you can sell them in the shop!");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To sell your crops, type 'sell' into the command line ");
        Thread.sleep(1000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player);



    }

}//End of class
