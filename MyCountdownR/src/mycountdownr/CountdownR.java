/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycountdownr;

    public class CountdownR implements Runnable {
        int idx, sec;
        Thread myt;
     public CountdownR(int i, int s) {
        idx = i;
        sec = s;
        myt = new Thread(this);
     }

     public void start() {
        myt.start();
     }
     public void join(){
         try{
             myt.join();
         }catch(Exception e){
         }
     }
     public void run() {
        for (int k=5;k>=0;k--) {
            System.out.println("IndexR " + idx + " Countdown " + k);
            try {
                Thread.sleep(sec*1000);
            }
            catch(InterruptedException e) {
            }
        }
     }
}