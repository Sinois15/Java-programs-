/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_fantasy_final;



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

}//End class