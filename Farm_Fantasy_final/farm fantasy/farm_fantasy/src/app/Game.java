/*
 * Group Members: James, Anshul, Cedric, Rajuwien, Hamzah, Iman
*/

package app;

import java.io.File;
import java.lang.Thread;
import java.util.Scanner;
import java.lang.InterruptedException;
import java.util.InputMismatchException;

public class Game {

    private static double balance = 100.0;
    public static int plotSize;

    private PlayerManager manager = new PlayerManager();
    private Graphics g = new Graphics();
    private Commands c = new Commands();
    private Tutorial t = new Tutorial();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //To remove the use of static for every method.
        new Game().run();
        
    }

    public void run(){
        String option;
        File f = new File("userdata.txt");
        Utility u = new Utility();
        try{
            manager = u.readFile();            
        } catch (Exception e){

        }
        //Infinite loop until 'Play' or 'Quit' has been chosen. 
        boolean x = true;
        while(x){
            //input play or quit
            g.mainMenu();
            option = sc.nextLine().toLowerCase();
            switch(option){
                //play will go to tutorial
                case "play":
                    while(x){
                        //Prompt user to login or register.
                        g.loginRegister();
                        option = sc.nextLine().toLowerCase();
                        switch(option){
                            case "login":
                                game(login());
                                break;
                            case "register":
                                Player player = createPlayer();
                                manager.add(player);
                                player.setDay(1);
                                player.setBalance(1000);
                                try{
                                    //Try to run tutorial with player object.
                                    t.balanceExperience(player, manager);
                                } catch (InterruptedException ie){
                                    System.out.println("Tutorial was interrupted.");
                                }
                                player.setDay(1);
                                player.setBalance(100);
                                game(player);
                                break;
                                default:
                                        System.out.println("Invalid Choice!");
                                        System.out.println();
                        }
                    }
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

    public Player login(){
        String username = "";
        String password = "";
        Player player;
        while(username.trim().isEmpty() || manager.getPlayer(username) == null){
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            validateUsername(username);
            if(username.trim().isEmpty() || manager.getPlayer(username) == null){
                System.out.println("User doesn't exist.");
            }
        }
        player = manager.getPlayer(username);
        password = null;
        while(password == null){
            System.out.print("Enter Password: ");
            password = sc.nextLine();
            validateUsername(password);
            if(!player.getPassword().equals(password)){
                password = null;
                System.out.println("Incorrect Password.");
            }
        }
        plotSize = player.getPlotLength();
        return player;
    }

    public boolean validateUsername(String username){
        if(username.trim().isEmpty()){
            System.out.println("Invalid Username: Username cannot be empty.");
            return false;
        } else if (username.contains(" ")){
            System.out.println("Invalid Username: Username cannot have spacing.");
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password){
        if(password.trim().isEmpty()){
            System.out.println("Invalid Password: Password cannot be empty.");
            return false;
        } else if (password.contains(" ")){
            System.out.println("Invalid Password: Password cannot have spacing.");
            return false;
        }
        return true;
    }

    public void game(Player player){
        //Creates an infinite loop of the main game (will not exit unless the 'quit' command has been called.)
        boolean infiniteLoop = true;
        while(infiniteLoop){
            player.levelUp();
            System.out.println("Day: " + player.getDay());
            System.out.println();
            g.statusBar(player);
            g.displayPlots(player.getPlots());
            //todo: Call graphics.
            System.out.print("Enter Command: ");
            c.command(sc.nextLine(), player, manager);
            System.out.println();
        }
        
    }

    public Player createPlayer(){
        String username, password;
        boolean error = true;
        //Prompt user to key in username
        do{
            System.out.print("Create Username: ");
            username = sc.nextLine();
            //validation for username. no spacing and cannot be blank.
            if(username.equals("")){
                System.out.println("Invalid Username: Username cannot be empty.");
                error = true;
            } else if(username.contains(" ")){
                System.out.println("Invalid Username: Username cannot have spacing.");
                error = true;
            } else if (manager.getPlayer(username) != null){
                System.out.println("Invalid Username: Username already exists.");
                error = true;
            } else {
                boolean satisfied = false;
                while(!satisfied){
                    System.out.println("Are you happy with " + username + "? [Y/N]");
                    error = false;
                    String option = sc.nextLine().toLowerCase();
                    if(option.equals("y")){
                        satisfied = true;
                    } else if (option.equals("n")){
                        satisfied = true;
                        username = "";
                    } else {
                        satisfied = false;
                    }
                }
            }
        }
        while(username.contains(" ") || username.equals("") || error);
        error = true;
        //Prompt user to key in password
        do{
            System.out.print("Create Password: ");
            password = sc.nextLine();
            //validation for password. no spacing and cannot be blank.
            if(password.equals("")){
                System.out.println("Invalid Password: Password cannot be empty.");
                error = true;
            } else if(password.contains(" ")){
                System.out.println("Invalid Password: Password cannot have spacing.");
                error = true;
            } else {
                System.out.print("Re-type Password: ");
                if(sc.nextLine().equals(password)){
                    error = false;
                }
            }
        }
        while(password.contains(" ") || password.equals("") || error);
        error = true;
        plotSize = 0;
        do{
            try{
                System.out.print("Enter desired plot size: ");
                plotSize = Integer.parseInt(sc.nextLine());
                error=false;
                if(plotSize==0){
                    System.out.println("Plot size cannot be zero.");
                }else if (plotSize < 0){
                    System.out.println("Plot size cannot be negative.");
                } else if(plotSize > 9) {
                    System.out.println("Plot size cannot be greater than 9.");
                }
            }catch(InputMismatchException e){
                System.out.println("Plot size should be a positive number which is less than 9.");
                error=true;
            }catch(NumberFormatException nfe){
                System.out.println("That is not a valid plot size.");
                error = true;
            }
        }
        while(plotSize < 0 || plotSize > 9 || error);
        return new Player(username, password, plotSize, balance, 0, 1);
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
        c.command(sc.nextLine() , player, manager);
        //to show the shop

        System.out.println();
        Thread.sleep(2000);
        System.out.println("This is the shop, here you can see the cost of buying a seed, and also the selling price of the fully grown crop.");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To buy a seed, type 'buy' into the command line: ");
        Thread.sleep(1000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player, manager);
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
        c.command(sc.nextLine(), player, manager);
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
        c.command(sc.nextLine(), player, manager);
        //to call the harvest method so the user can harvest the crop
        System.out.println("Now that you have harvested your crops, you can sell them in the shop!");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("To sell your crops, type 'sell' into the command line ");
        Thread.sleep(1000);
        System.out.print("Enter command: ");
        c.command(sc.nextLine(), player, manager);



    }

}//End of class
