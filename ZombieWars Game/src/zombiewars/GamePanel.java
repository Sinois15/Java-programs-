/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewars;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

   private Timer aTimer;
   private int gameStatus = 0;   // 0 = waiting for start game
                                 // 1 = game running
                                 // 2 = game over
   private Cedric cedric;
   private Zombie zom1, zom2, zom3, zom4;
   private int score = 0;

   public GamePanel() {
      aTimer = new Timer(50, this); // 50 ms 0.05 sec or 20x per second
      reset();   
      addKeyListener(this);
   }
   
   public void reset() {
      cedric = new Cedric(300, 500, 5);
      zom1 = new Zombie(100, 100, 5);
      zom2 = new Zombie(200, 100, 5);
      zom3 = new Zombie(300, 100, 5);
      zom4 = new Zombie(400, 100, 5);
      
      score = 0;
   }

   public void startTimer() {
      if (gameStatus == 0) {
         aTimer.start();
         gameStatus = 1;
      }
   }

   public void paint(Graphics g) {

      if (gameStatus == 1) {
         score++;
         if (cedric.collideBorder()) {
            gameStatus = 2;
         }      
         if (cedric.collideZombie(zom1)){
             gameStatus = 2;
         }
         if (cedric.collideZombie(zom2)){
             gameStatus = 2;
         }
         if (cedric.collideZombie(zom3)){
             gameStatus = 2;
         }
         if (cedric.collideZombie(zom4)){
             gameStatus = 2;
         }
         if (gameStatus != 2) {
            zom1.hunting(cedric);
            zom2.hunting(cedric);
            zom3.hunting(cedric);
            zom4.hunting(cedric);
            cedric.updatePosition();
            zom1.updatePosition();
            zom2.updatePosition();
            zom3.updatePosition();
            zom4.updatePosition();
            zom1.handleBorderCollision();
            zom2.handleBorderCollision();
            zom3.handleBorderCollision();
            zom4.handleBorderCollision();
            
         }
      }
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 600, 600);
      g.setColor(Color.BLUE);
      g.fillRect(0, 600, 600, 30);
      cedric.drawCedric(g);
      zom1.drawZombie(g);
      zom2.drawZombie(g);
      zom3.drawZombie(g);
      zom4.drawZombie(g);
      if (gameStatus == 0) {
         g.setColor(Color.WHITE);
         g.drawString("PRESS START TO BEGIN..", 250, 300);
      }
      if (gameStatus == 2) {
         g.setColor(Color.WHITE);
         g.drawString("G A M E O V E R", 250, 300);
      }
      g.setColor(Color.WHITE);
      g.drawString("S C O R E : " + score, 10, 620);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == aTimer) {
         repaint(0, 0, 600, 630);
         requestFocus();
      }
   }

   public void moveLeft() {
      cedric.moveLeft();
   }

   public void moveRight() {
      cedric.moveRight();
   }

   public void moveUp() {
      cedric.moveUp();
   }

   public void moveDown() {
      cedric.moveDown();
   }
   
   public int getStatus(){
       return gameStatus;
   }
   
   public void setStatus(int status){
       this.gameStatus = status;
   }
   
   public void pause(){
       gameStatus = 3;
   }
   public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
       switch (keyCode) {
           case 37:
               cedric.moveLeft();
               break;
           case 39:
               cedric.moveRight();
               break;
           case 38:
               cedric.moveUp();
               break;
           case 40:
               cedric.moveDown();
               break;
           case 32:
               if (gameStatus == 1){
                   pause();
               }  
               if (gameStatus == 3){
                   gameStatus = 1; 
               }
               break;
           case 13:
               startTimer();
               break;
           default:        
               break;
       }
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
} 
