/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;

public class Marksman extends RpgClass {
    
    public Marksman(){
        super("Marksman", 80, 120, 60, 100, 70);
    }
    
    //method inherited from superclass
    @Override
    public final void writeDescrip(){
        super.setDescrip("Marksman\n\nMove swiftly within the shadows"
                + "\nand eliminate "
                + "your enemies in one shot"
                + "\nwith your superior atk."
                + "\nBut be wary of surprise attacks, "
                + "\nyour defense is rather"
                + "\n*cough* useless *cough*.");
    }
     
}
