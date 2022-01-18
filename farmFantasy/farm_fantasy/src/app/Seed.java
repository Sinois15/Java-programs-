package app;

public class Seed{

    String name;
    String symbol;
    int dayPlanted;
    int daysToGrow;
    int daysToDie;

    public Seed(Item item, int dayPlanted, int daysToGrow, int daysToDie, String symbol){
        this.name = item.getName();
        this.dayPlanted = dayPlanted;
        this.daysToGrow = daysToGrow;
        this.symbol = symbol;
        this.daysToDie = daysToDie;        
    }

    public void growth(Seed seed){
        if(seed.getName().toLowerCase().equals("wheat seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = " w ";
                    break;
                case " w ":
                    this.symbol = " W ";
                    break;
                case " W ":
                    this.symbol = " 🌾 ";
            }
        }
        if(seed.getName().toLowerCase().equals("corn seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = " c ";
                    break;
                case " c ":
                    this.symbol = " C  ";
                    break;
                case " C ":
                    this.symbol = " 🌽 ";
            }            
        }
        if(seed.getName().toLowerCase().equals("potato seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = " p ";
                    break;
                case " p ":
                    this.symbol = " P ";
                    break;
                case " P ":
                    this.symbol = " 🥔 ";
            }            
        }
        if(seed.getName().toLowerCase().equals("pumpkin seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = "|p|";
                    break;
                case "|p|":
                    this.symbol = "|P|";
                    break;
                case "|P|":
                    this.symbol = " 🎃 ";
            }            
        }
        if(seed.getName().toLowerCase().equals("melon seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = " m ";
                    break;
                case " m ":
                    this.symbol = " M ";
                    break;
                case " M ":
                    this.symbol = " 🍈 ";
            }            
        }
        if(seed.getName().toLowerCase().equals( "lettuce seed")){
            switch(seed.getSymbol()){
                case " . ":
                    this.symbol = " l ";
                    break;
                case " l ":
                    this.symbol = " L ";
                    break;
                case " L ":
                    this.symbol = " 🥗 ";
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

    public void updateSeed(Player player, int i){
        //Kill plant
        //if((player.getDay() - dayPlanted) >= player.getInventory().getItem()
        System.out.println(player.getDay() + "  " + player.getPlots()[i].getSeed().getDayPlanted() + "  " + player.getPlots()[i].getSeed().getDaysToDie());
        if (player.getDay() - player.getPlots()[i].getSeed().getDayPlanted() >= player.getPlots()[i].getSeed().getDaysToDie()){
            player.getPlots()[i].killPlant();
        }
        /*for(int i = 0; i < player.getPlotSize(); i++){
            if(player.getPlots()[i].getSeed() != null){
                for(int j = 0; j < player.getInventory().getSize(); j++){
                    if(player.getInventory().getItem(j).getName().equals(player.getPlots()[i].getSeed().getName())){
                        if(player.getDay() - player.getPlots()[i].getSeed().getDayPlanted() >= player.getInventory().getItem(j).getDaysToDie()){
                            player.getPlots()[i].killPlant();
                            System.out.println("A plant died.");                                
                        }
                    }
                }   
            }
        }*/
    }

    public boolean isMature(){
        return dayPlanted >= daysToGrow;
    }

    @Override
    public String toString(){
        return symbol;
    }

} //End class