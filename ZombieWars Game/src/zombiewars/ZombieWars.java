/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewars;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class ZombieWars extends JFrame implements ActionListener {

   private final int SWIDTH = 900;
   private final int SHEIGHT = 700;
   private JButton btnStart, btnExit;
   private JButton btnLeft, btnRight, btnUp, btnDown, btnPause;
   private GamePanel gameP = new GamePanel();

   public ZombieWars() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Zombie Wars v1.0");
      setSize(SWIDTH, SHEIGHT);
      setLayout(null);
   }

   public void init() {
      gameP.setBounds(25, 25, 600, 630);
      add(gameP);
      btnLeft = new JButton("LEFT");
      btnLeft.setBounds(650, 400, 100, 25);
      btnLeft.addActionListener(this);
      add(btnLeft);
      btnRight = new JButton("RIGHT");
      btnRight.setBounds(750, 400, 100, 25);
      btnRight.addActionListener(this);
      add(btnRight);
      btnUp = new JButton("UP");
      btnUp.setBounds(700, 375, 100, 25);
      btnUp.addActionListener(this);
      add(btnUp);
      btnDown = new JButton("DOWN");
      btnDown.setBounds(700, 425, 100, 25);
      btnDown.addActionListener(this);
      add(btnDown);
      btnStart = new JButton("START");
      btnStart.setBounds(650, 500, 100, 25);
      btnStart.addActionListener(this);
      add(btnStart);
      btnExit = new JButton("EXIT");
      btnExit.setBounds(650, 625, 100, 25);
      btnExit.addActionListener(this);
      add(btnExit);
      btnPause = new JButton("PAUSE");
      btnPause.setBounds(750, 500, 100, 25);
      btnPause.addActionListener(this);
      add(btnPause);
      setVisible(true);     
      File soundFile =  new File("src/cedric.wav").getAbsoluteFile();
      try {
         AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
         Clip myClip = AudioSystem.getClip();
         myClip.open(ais);
         myClip.start();
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
   

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnExit) {
         System.exit(0);
      } 
      else if (e.getSource() == btnStart) {
        if (gameP.getStatus() == 0){
            gameP.startTimer();
            btnStart.setText("Restart");
        }
        if (gameP.getStatus() == 2){
            gameP.setStatus(0);
            gameP.reset();
            btnStart.setText("Start");
        }
        
      }     
      else if (e.getSource() == btnLeft) {
         gameP.moveLeft();
      } 
      else if (e.getSource() == btnUp) {
         gameP.moveUp();
      } 
      else if (e.getSource() == btnRight) {
         gameP.moveRight();
      } 
      else if (e.getSource() == btnDown) {
         gameP.moveDown();
      }
      else if (e.getSource() == btnDown) {
         gameP.moveDown();
      }
      else if (e.getSource() == btnPause){
            if(gameP.getStatus() == 1){
                gameP.setStatus(3);
                btnPause.setText("RESUME");
            }
            else if(gameP.getStatus() == 3){
                gameP.setStatus(1);
                btnPause.setText("PAUSE");
            }
        }
      
   }

   public static void main(String args[]) {
      ZombieWars zw = new ZombieWars();
      zw.init();
   }
}
