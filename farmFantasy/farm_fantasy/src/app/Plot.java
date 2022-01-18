package app;

public class Plot{

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

    public Seed harvest(){
        Seed harvestedPlant = null;
        if(seed.isMature()){
            harvestedPlant = seed;
            seed = null;
        }
        return harvestedPlant;
    }

}//End class