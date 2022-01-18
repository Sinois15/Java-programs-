/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytransport;

/**
 *
 * @author User
 */
public class Glyder extends Vehicle implements WheelSystem,FlightSystem{
     public Glyder(String t, int s) {
        super(t, s);
    }
    
    public void displayTotWheel() {
        System.out.println("Glyder has 3 wheels");
    }
    public void displayMaxAltitude() {
        System.out.println("Glyder altitude is 3000m");
    }
    
}
