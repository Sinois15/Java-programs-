/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycountdown;

public class Countdown extends Thread {
 int idx, sec;
 public Countdown(int i, int s) {
    idx = i;
    sec = s;
 }

 public void run() {
    for (int k=5;k>=0;k--) {
        System.out.println("Index " + idx + " Countdown " + k);
        try {
            Thread.sleep(sec*1000);
        }
        catch(InterruptedException e) {
        }
    }
  
 } 
}
