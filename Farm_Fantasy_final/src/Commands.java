

import java.lang.Math;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class Commands{

    private Scanner sc = new Scanner(System.in);
    Graphics g  = new Graphics();
    Shop shop = new Shop();
    Utility u = new Utility();
    Game game;

    public void command(String command, Player player, PlayerManager manager){
        switch(command){
            case"bal":
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
                harvest(player);
                break;
            case"help":
                g.help();
                sc.nextLine();
                break;
            case"sell": 
                sell(player);
                break;
            case"sellall":
                sellAll(player);
                break;
            case"shop":
                g.shop();
                break;
            case "water":
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
            case "save":
                try{
                    u.addRecords(manager); 
                } catch (Exception e){

                }
                break;
            case"quit":
                String option;
                do{
                    System.out.print("Are you sure you want to quit [Y/N]: ");
                    option = sc.nextLine().toLowerCase();
                }
                while(!option.equals("y") && !option.equals("n") && !option.equals("yes") && !option.equals("no"));
                if(option.equals("y") || option.equals("yes")){
                    try{
                        u.addRecords(manager);
                    } catch (Exception e){

                    }
                    System.exit(0);
                }
                
                break;                
            default:
                System.out.println("Command does not exists.");
                break;
        }//end switch

    }//end 

    public void fertilizer(Player player){

    }

    public void sellAll(Player player){
        if(player.getInventory().getSize() != 0){
            for(int i = 0; i < player.getInventory().getSize(); i++){
                if(!player.getInventory().getItem(i).getName().toLowerCase().contains("seed")){
                    int shopId = 0;
                    for(int j = 0; j < shop.getInventory().getSize(); j++){
                        if(player.getInventory().getItem(i).getName().toLowerCase().equals(shop.getItem(shopId).getName().toLowerCase())){
                            shopId = shop.getItem(i).getId();
                        }
                    }                    
                    player.setBalance(player.getBalance() + (shop.getItem(shopId).getPrice() * player.getInventory().getItem(i).getQuantity()));
                    player.getInventory().getItem(i).setQuantity(player.getInventory().getItem(i).getQuantity() - player.getInventory().getItem(i).getQuantity());
                    for(int j = 0; j < player.getInventory().getSize(); j++){
                        if(player.getInventory().getQuantity(i) == 0){
                            player.getInventory().remove(i);
                        }
                    }
                }
            } 
            System.out.println("Successfully Sold Whole Inventory!");
        } else {
            System.out.println("Inventory is empty, couldn't sell anything.");
        }
    }

    public void sell(Player player){
        g.sellInv(player);
        boolean valid = false;
        String input;
        int quantity = 0, itemId = 0;
        do{
            System.out.print("ID: ");
            input = sc.nextLine();
            if(input.toLowerCase().equals("home") || input.toLowerCase().equals("cancel")){
                return;
            }
            try{
                itemId = Integer.parseInt(input);
                if(itemId >= 0 && itemId < player.getInventory().getSize()){
                    if(!player.getInventory().getItem(itemId).getName().toLowerCase().contains("seed")){
                        if(player.getInventory().getItem(itemId).getName().toLowerCase().contains("seed")){
                            System.out.println("You cannot sell seeds!");

                            valid = false;
                        } else {
                            valid = true;
                        }
                    }
                } else {
                    valid = false;
                }
            } catch (NumberFormatException nfe){
                System.out.println("Item does not exist.");
            }
        }
        while(!valid);
        valid = false;
        do{
            System.out.print("Quantity: ");
            input = sc.nextLine();
            if(input.toLowerCase().equals("home") || input.toLowerCase().equals("cancel")){
                return;
            }
            try{
                quantity = Integer.parseInt(input);
                if(quantity <= player.getInventory().getItem(itemId).getQuantity()){
                    valid = true;
                } else {
                    System.out.println("You don't have that many " + player.getInventory().getItem(itemId).getName() + "'s!");
                    valid = false;
                }
            } catch (NumberFormatException nfe){
                System.out.println("That is not a quantity.");
            } catch (IndexOutOfBoundsException e){
                System.out.println("Item does not exist.");
            }
        }
        while(!valid);
        int shopId = 0;
        for(int i = 0; i < shop.getInventory().getSize(); i++){
            if(player.getInventory().getItem(itemId).getName().toLowerCase().equals(shop.getItem(i).getName().toLowerCase())){
                shopId = shop.getItem(i).getId();
            }
        }
        player.setBalance(player.getBalance() + (shop.getItem(shopId).getPrice() * quantity));
        player.getInventory().getItem(itemId).setQuantity(player.getInventory().getItem(itemId).getQuantity() - quantity);
        for(int i = 0; i < player.getInventory().getSize(); i++){
            if(player.getInventory().getQuantity(itemId) == 0){
                player.getInventory().remove(i);
            }
        }
    }

    public void buy(Player player){
        double tempBal;
        int itemId = 0;
        boolean valid = false;
        boolean cont = true;
        String input;
        String choice;
        int quantity = 0;
        g.seedShop();
        //shows the shop
        do{
            do {
                System.out.print("ID: ");
                input = sc.nextLine();
                if(input.toLowerCase().equals("home") || input.toLowerCase().equals("cancel")){
                    return;
                }
                try{
                    itemId = Integer.parseInt(input);
                    if(itemId >= 0 && itemId < shop.getInventory().getSize()){
                        valid = true;
                        if(!shop.getItem(itemId).getName().toLowerCase().contains("seed")){
                            valid = false;
                            System.out.println("That item is not a seed.");
                        }
                    } else {
                        System.out.println("Invalid ID!");
                    }
                } catch (NumberFormatException nfe){
                    System.out.println("Invalid ID!");
                }
            }
            while(!valid);
            //extracts the integer value (parses it) from the varable 'input' 
            valid = false;
            do{
                System.out.print("Quantity: ");
                input = sc.nextLine();
                if(input.toLowerCase().equals("cancel") || input.toLowerCase().equals("home")){
                    return;
                }
                try{    
                    quantity = Integer.parseInt(input);
                    if(quantity > 0){
                        valid = true;
                    } else {
                        System.out.println("Quantity must be more than 0!");
                        valid = false;
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid quantity.");
                    valid = false;
                }
                tempBal = player.getBalance() - shop.getItem(itemId).getPrice() * quantity;
                if(tempBal < 0){
                    System.out.println("Insufficient Funds!");
                    valid = false;
                }
            }
            while(!valid);
            player.getInventory().add(new Item(shop.getItem(itemId), quantity));
            player.setBalance(player.getBalance() - shop.getItem(itemId).getPrice() * quantity);
            System.out.println("Do you want to buy other items? [Y/N]");
            choice=sc.nextLine();
            if (choice.equals("y")){
                cont=true;
            } else if (choice.equals("n")){
                cont=false;
            }
        }
        while(choice.equals("y"));
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
        //Asks user if they want to plant all the seeds in their inventory or until the plot is filled with seeds.
        do{
            System.out.println("Would you like to auto-plant?[Y/N]: ");
            input = sc.nextLine().toLowerCase();
            if(input.equals("home") || input.equals("cancel")){
                return;
            }
        }
        while(!input.equals("y") && !input.equals("n"));
        int shopId = 0;
        if(input.equals("y")){
            for(int i = 0; i < player.getPlotSize(); i++){
                for(int j = 0; j < player.getInventory().getSize(); j++){
                    if(player.getInventory().getItem(j).getName().toLowerCase().contains("seed") && player.getInventory().getItem(j).getQuantity() != 0){
                        if(!player.getPlots()[i].hasSeed()){
                            int newQuantity = player.getInventory().getItem(j).getQuantity() - 1;
                            player.getInventory().getItem(j).setQuantity(newQuantity);
                            for(int k = 0; k < shop.getInventory().getSize(); k++){
                                if(player.getInventory().getItem(j).getName().toLowerCase().equals(shop.getInventory().getItem(k).getName().toLowerCase())){
                                    shopId = k;
                                }
                            }
                            player.getPlots()[i].plantSeed(new Seed(player.getInventory().getItem(j), player.getDay(), shop.getItem(shopId).getDaysToGrow(), shop.getItem(shopId).getDaysToDie(), " . "));
                            player.addExp(3);
                        }
                    }
                }
            }
            try{
                for(int i = 0; i < player.getInventory().getSize(); i++){
                    if(player.getInventory().getItem(i).getQuantity() == 0){
                        player.getInventory().remove(i);
                        i = -1;
                    }
                }
            } catch (IndexOutOfBoundsException e){

            }
            return;
        }
        //Displays plantSeed graphics (avaliable seeds), if there's none then it'll display that they don't have any seeds.
        g.seedInv(player);
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
            player.getPlots()[plot].plantSeed(new Seed(player.getInventory().getItem(id), player.getDay(), shop.getItem(id).getDaysToGrow(), shop.getItem(id).getDaysToDie(), " . "));
            int newQuantity = player.getInventory().getItem(id).getQuantity() - 1;
            if(newQuantity == 0){
                player.getInventory().remove(id);
            } else {
                player.getInventory().getItem(id).setQuantity(newQuantity);
            }
            System.out.println("Successfully Planted Seed!");
            player.addExp(3);
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
        //Declaration of variables needed for nextDay method.
        int min = 5;
        int max = 20;
        int range = max - min + 1;
        int tempDay = player.getDay();
        int thirstCount = 0;
        int deathCount = 0;
        //Day increment.
        tempDay++;
        player.setDay(tempDay);        
        //Go through the array size of plot[].
        for(int i = 0; i < player.getPlots().length; i++){
            //Check if that plot has any seeds.
            if(player.getPlots()[i].hasSeed()){
                //Grows seed
                player.getPlots()[i].getSeed().growth(player);
                //Decrease thirst bar of seed.
                player.getPlots()[i].getSeed().setThirst(player.getPlots()[i].getSeed().getThirst() - ((Math.random() * range) + min));
                //Kills plants that have a thirst bar less than or equal to 0.
                if(player.getPlots()[i].getSeed().killThirst()){
                    player.getPlots()[i].killPlant();
                    deathCount++;
                } else { 
                    //Else used because if the plant is killed from the code above, we don't want to run the code below.
                    //Counts number of seeds.
                    if(player.getPlots()[i].getSeed().isThirsty()){
                        thirstCount++;
                    }
                    //Checks if the plant should die.
                    player.getPlots()[i].getSeed().updateSeed(player, i);
                    //Counts number of plants die.
                    if(!player.getPlots()[i].hasSeed()){
                        deathCount++;
                    }
                }
            }
        }
        //Shows how many plants have died.
        if(deathCount == 1){
            System.out.println("A plant has died!");
        } else if(deathCount > 1){
            System.out.println(deathCount + " plants have died!");
        }
        //Shows how many plants need to be watered.
        if(thirstCount == 1){
            System.out.println("A plant needs to be watered!");
        } else if(thirstCount > 1){
            System.out.println(thirstCount + " plants need to be watered!");
        }
    }

    public void harvest(Player player){
        int itemId = 0;
        //For loop to go through all the plots.
        for(int i = 0; i < player.getPlotSize(); i++){
            //Checks if the plot has a seed.
            if(player.getPlots()[i].hasSeed()){
                //Checks if the plant is mature.
                if(player.getPlots()[i].getSeed().isMature(player)){
                    //Item ID + 6 because the id used for the crops are 6 number higher than the seed of the crop.
                    for(int j = 0; j < shop.getInventory().getSize(); j++){
                        if(player.getPlots()[i].getSeed().getName().toLowerCase().equals(shop.getInventory().getItem(j).getName().toLowerCase())){
                            itemId = j + 6;
                        }
                    }
                    if (!player.getPlots()[i].getSeed().isMature(player)){
                        System.out.println("Crops are not ready for harvest yet");
                    }
                    player.getInventory().add(new Item(shop.getItem(itemId), 1));
                    //Remove seed/ plant from the plot.
                    player.getPlots()[i].killPlant();
                    player.addExp(itemId + 1);
                }
            }
        }
    }
}//end class


