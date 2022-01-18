package app;

import java.io.Serializable;

public class Plot implements Serializable{

    Seed seed;

    public Plot(){

    }

    public boolean plantSeed(Seed seed){
        if(seed != null){
            this.seed = seed;
            return true;
        }
        return false;
    }

    public boolean hasSeed(){
        return seed != null;
    }

    public Seed getSeed(){
        return seed;
    }

    public void killPlant(){
        this.seed = null;
    }

}//End class