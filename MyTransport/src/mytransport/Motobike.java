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
public class Motobike extends Vehicle implements Engine, WheelSystem,  Registration {
    public Motobike(String t, int s) {
        super(t, s);
    }
    @Override
    public void startEngine() {
        System.out.println("Motobike engine starts - vroom...vroom...");
    }
    @Override
    public void displayTotWheel() {
        System.out.println("Motobike has 2 wheels");
    }
    @Override
    public void displayReg(){
        System.out.println("Motobike has registration number 1000001");
    }
}
