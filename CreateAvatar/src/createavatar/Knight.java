/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;

/**
 *
 * @author User
 */
public final class Knight extends RpgClass{
   
    public Knight(){
        super("Knight", 100, 90, 110, 80, 10);
    }
    
    //method inherited from superclass
    @Override
    public final void writeDescrip(){
        super.setDescrip("Knight"
                + "\n\nThis class boasts rather balanced stats"
                + "\nexcept for its disappointing MP."
                + "\nCharge into the battlefield and act"
                + "\nas a decoy for your party mates"
                + "\nas they decimate your enemies.");
    }
    
}
