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
public class Aircraft extends Vehicle implements Engine, WheelSystem, FlightSystem, Registration {
    public Aircraft(String t, int s) {
        super(t, s);
    }
    public void startEngine() {
        System.out.println("Aircraft engine starts - viuuuuu.");
    }
    public void displayTotWheel() {
        System.out.println("Aircraft has 3 wheels");
    }
    public void displayMaxAltitude() {
        System.out.println("Aircraft altitude is 15000m");
    }
    public void displayReg(){
        System.out.println("Aircraft has registration number 2000001");
    }
}
