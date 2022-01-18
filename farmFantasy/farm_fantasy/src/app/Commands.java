package app;

import java.util.Scanner;

public class Commands{

    private Scanner sc = new Scanner(System.in);
    Graphics g  = new Graphics();
    Shop shop = new Shop();
    Game game;

    public void command(String command, Player player){
        switch(command){
            case"balance":
                System.out.println("Your balance is $" + player.getBalance());
                break;
            case"buy":
                buy(player);
                break;
            case"plot":
                g.displayPlots(player.getPlots());
                break;
            case"plant":
                plant(player);
                break;
            case"harvest":
                //harvest();
                break;
            case"help":
                //g.help();
                break;
            case"sell": 
                break;
            case"shop":
            g.shop();
                break;
            case "nextday":
                nextDay(player);
                break;
            case"tutorial":
                try{
                    game.tutorial(player);
                } catch (InterruptedException e) {
                    
                }
                break;
            case"inv":   
            case"inventory":
                g.displayInventory(player);
                break;    
            case"quit":
                String option;
                do{
                    System.out.print("Are you sure you want to quit [Y/N]: ");
                    option = sc.nextLine().toLowerCase();
                }
                while(!option.equals("y") && !option.equals("n") && !option.equals("yes") && !option.equals("no"));
                if(option.equals("y") || option.equals("yes")){
                    System.exit(0);
                }
                
                break;
            case"home":
                break;                
            default:
                System.out.println("Command does not exists.");
                break;
        }//end switch

    }//end command

    public void buy(Player player){
        g.shop();
        //shows the shop
        System.out.print("ID: ");
        String input = sc.nextLine();
        //takes in the ID of the seed
        int itemId = Integer.parseInt(input);
        //extracts the integer value (parses it) from the varable 'input' 
        if(input.toLowerCase().equals("home")){
            return;  
            //checks if the user inputs the command 'home'
        }
        else{
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            player.getInventory().addItem(new Item(shop.getItem(itemId), quantity));
            player.setBalance(player.getBalance() - shop.getItem(itemId).getPrice() * quantity);
        }
        
    }

    public void plant(Player player){
        //Declaration of variables needed for plant method.
        int id = 0;
        int plot = 0;
        String input;
        boolean empty = true;
        boolean validInput = false;
        //Checks if the player has any seeds in their inventory.
        for(int i = 0; i < player.getInventory().getSize(); i++){
            if(player.getInventory().getItem(i).getName().toLowerCase().contains("seed")){
                empty = false;
            }
        }
        //Displays plantSeed graphics (avaliable seeds), if there's none then it'll display that they don't have any seeds.
        g.plantSeed(player);
        //Enters this only if the player has seeds.
        if(!empty){
            //Plot input validation.
            do{
                System.out.print("Enter Plot: ");
                //Input using string to allow for any input from the user (without crashing).
                input = sc.nextLine();
                //Player can choose to return to main view using 'cancel' or 'home'.
                if(input.toLowerCase().equals("cancel") || input.toLowerCase().equals("home")){
                    return;
                }
                //If the string variable 'input' has only integers, it'll try to parse it and put it into int variable 'plot'.
                try{
                    plot = Integer.parseInt(input);
                    //Checks if plot fits the domain of plot array size.
                    if(plot < player.getPlotSize() && plot >= 0){
                        //Checks if the plot has seeds.
                        if(player.getPlots()[plot].hasSeed()){
                            System.out.println("Plot already has a seed!");
                        } else {
                            //If it doesn't have any seeds, it's a valid plot input.
                            validInput = true;
                        }                             
                    } else {
                        //If the plots domain isn't matched, that plot does not exist.                  
                        plot = 0;                        
                        System.out.println("That plot doesn't exist.");
                    }
                //Catches NumberFormatException when trying to parse integer from 'input' into 'plot'.                                
                } catch (NumberFormatException nfe){
                    //Not a valid input.
                    validInput = false;
                }
            }
            while(!validInput);
            //Reset validInput boolean to be reused in next validation.
            validInput = false;
            //Plant ID input validation.
            do{
                System.out.print("Enter ID of seed to plant: ");
                //Input using string to allow for any input from the user (without crashing).
                input = sc.nextLine();
                //Player can choose to return to main view using 'cancel' or 'home'.
                if(input.toLowerCase().equals("cancel") || input.toLowerCase().equals("home")){
                    return;
                }          
                //If the string variable 'input' has only integers, it'll try to parse it and put it into int variable 'id'.      
                try {
                    id = Integer.parseInt(input);
                    //If 'id' is within the domain of the Inventory size.
                    if(id < player.getInventory().getSize()){
                        //If the 'id' they inputted contains 'seed' it is a correct Item type to be planted.
                        if(player.getInventory().getItem(id).getName().toLowerCase().contains("seed")){
                            //It is a valid input.
                            validInput = true;
                        } else {
                             System.out.println("That item is not a seed.");
                            validInput = false;
                        }
                    //If 'id' is not within the domain of the Inventory size, that item does not exist.
                    } else {
                        System.out.println("That seed does not exist.");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("That is not a valid id, try again.");
                }
            }
            while(!validInput);
            //Gets plot from player with array number ['plot'], and runs the method: 'plantSeed'. Then it creates a new seed
            player.getPlots()[plot].plantSeed(new Seed(player.getInventory().getItem(id), player.getDay(), 1, 3, " . "));
            int newQuantity = player.getInventory().getItem(id).getQuantity() - 1;
            if(newQuantity == 0){
                player.getInventory().remove(id);
            } else {
                player.getInventory().getItem(id).setQuantity(newQuantity);
            }
            System.out.println("Successfully Planted Seed!");
            player.addExp(5);
        }
        if(empty){
            System.out.println("You have no seeds to plant! Go buy some.");
            buy(player);
        }
        try{
            Thread.sleep(2000);
        } catch (InterruptedException ie){
            
        }
    }

    public void nextDay(Player player){
        //Go through the array size of plot[]
        for(int i = 0; i < player.getPlots().length; i++){
            //Check if that plot has any seeds.
            if(player.getPlots()[i].hasSeed()){
                //
                Seed seed = player.getPlots()[i].getSeed();
                seed.growth(seed);
            }
        }
        int tempDay = player.getDay();
        tempDay++;
        player.setDay(tempDay);
        for(int i = 0; i < player.getPlotSize(); i++){
            if(player.getPlots()[i].getSeed() != null){
                player.getPlots()[i].getSeed().updateSeed(player, i);
            }
        }
    }

}//end class


