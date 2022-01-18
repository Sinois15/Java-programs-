/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycountdownr;

/**
 *
 * @author User
 */
public class MyCountdownR {


    public static void main(String args[]) {
        CountdownR cd1 = new CountdownR(1,2);
        CountdownR cd2 = new CountdownR(2,1);
        cd1.start();
        cd2.start();
        cd1.join();
        cd2.join();
  
        System.out.println("END");
    }
}