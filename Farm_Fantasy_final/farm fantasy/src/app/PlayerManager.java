package app;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class PlayerManager implements Serializable {
    
    private List<Player> players = new ArrayList<>();

    public PlayerManager(){

    }

    //Checking for Player duplicates before adding new Player/
    public boolean add(Player player){
        for(Player currentPlayer : players){
            if(currentPlayer.getName().equals(player.getName())){
                return false;
            }
        }
        return players.add(player);
    }

    public Player getPlayer(String name){
        for(Player player : players){
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    public Player getPassword(String password){
        for(Player player : players){
            if(player.getPassword().equals(password)){
                return player;
            }
        }
        return null;
    }
}