/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytransport;

public class MyTransport {
    public static void main(String args[]) {
    JetSki js = new JetSki("water", 40);
    Bicycle b = new Bicycle("land", 20);
    Motobike mb = new Motobike("land", 200);
    Aircraft a = new Aircraft("air", 1000);
    Glyder g = new Glyder("air", 100);

    js.startEngine();
    b.displayTotWheel();
    mb.startEngine();
    mb.displayTotWheel();
    mb.displayReg();
    a.startEngine();
    a.displayTotWheel();
    a.displayMaxAltitude();
    a.displayReg();
    g.displayTotWheel();
    g.displayMaxAltitude();
    
    }
}

