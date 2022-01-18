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
public class Bicycle extends Vehicle implements WheelSystem{
    public Bicycle(String t, int s){
        super(t, s);
    }
    public void displayTotWheel() {
        System.out.println("Bicycle has 2 wheels");
    }
}
