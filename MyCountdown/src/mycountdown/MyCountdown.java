/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycountdown;

/**
 *
 * @author User
 */
public class MyCountdown {


 public static void main(String args[]) {
    Countdown cd1 = new Countdown(1,2);
    Countdown cd2 = new Countdown(2,1);
    cd1.start();// start is used to run the code as a thread
    cd2.start();
    //cd2.run();// run the program in sequence
    try{
        cd1.join();
        cd2.join();
    }catch(Exception e){
    }
    System.out.println("END");
 }
}