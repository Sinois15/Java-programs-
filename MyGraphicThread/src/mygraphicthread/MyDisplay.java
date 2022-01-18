/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphicthread;

import javax.swing.*;
public class MyDisplay implements Runnable {
 private JLabel lab;
 private int track;
 private int speed;
 private Thread myt;
 public MyDisplay(JLabel lx, int s, int t) {
    lab = lx;
    speed = s;
    track = t;
    myt = new Thread(this);
 }
 
 public void start(){
     myt.start();
 }
 
 public void run() {
    int x=25;
    int d=5;
    do {
        try {
            x = x + d;
            if (x >= 300){
                d = - 5;
            }
            if (x <= 25){
                d =  5;
            }
            Thread.sleep(speed*100);
            lab.setBounds(x,track,25,25);
            
        }
        catch (InterruptedException e) {
        }
    } while (x >= 25);
 }
} 