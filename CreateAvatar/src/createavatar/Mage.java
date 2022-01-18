/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;

public class Mage extends RpgClass {
   
    public Mage(){
        super("Mage", 70, 40, 40, 70, 150);
    }
    
    //method inherited from superclass
    @Override
    public final void writeDescrip(){
        super.setDescrip("Mage\n\n"
                + "Master of the magic arts, "
                + "\nwhile all your other stats"
                + "\nare inferior, make up for it by"
                + "\nchanneling your mana "
                + "\nto summon barriers"
                + "\nand devastating attacks.");
    }
  
}
