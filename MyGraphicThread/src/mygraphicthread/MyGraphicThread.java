/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphicthread;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class MyGraphicThread implements ActionListener {

 JFrame f;
 JPanel mainP, subP;
 JLabel labX, labY, labZ, labW;
 JButton btnStart, btnExit;
 MyDisplay mdx, mdy, mdz, mdw;

 public MyGraphicThread() {
 f = new JFrame();
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 mainP = new JPanel();
 subP = new JPanel();
 }

 public void init() {
 f.setTitle("My Graphic Thread");
 f.setSize(400, 300);
 mainP.setLayout(null);
 subP.setLayout(null);

 labW = new JLabel("W");
 labW.setBounds(25, 0, 25, 25);
 subP.add(labW);
 labX = new JLabel("X");
 labX.setBounds(25, 25, 25, 25);
 subP.add(labX);
 labY = new JLabel("Y");
 labY.setBounds(25, 50, 25, 25);
 subP.add(labY);
 labZ = new JLabel("Z");
 labZ.setBounds(25, 75, 25, 25);
 subP.add(labZ);

 subP.setBounds(25, 25, 350, 100);
 subP.setBackground(Color.YELLOW);
 mainP.add(subP);

 btnStart = new JButton("START");
 btnStart.setBounds(200, 200, 90, 25);
 btnStart.addActionListener(this);
 mainP.add(btnStart);

 btnExit = new JButton("EXIT");
 btnExit.setBounds(300, 200, 90, 25);
 btnExit.addActionListener(this);
 mainP.add(btnExit); 

 f.add(mainP);
 f.setVisible(true);
 }

 public void actionPerformed(ActionEvent e) {
 if (e.getSource() == btnStart) {
 mdx = new MyDisplay(labX, 4, 25);
 mdy = new MyDisplay(labY, 3, 50);
 mdz = new MyDisplay(labZ, 2, 75);
 mdw = new MyDisplay(labW, 1, 0);
 mdx.start();
 mdy.start();
 mdz.start();
 mdw.start();
 }
 if (e.getSource() == btnExit)
 System.exit(0);
 }

 public static void main(String args[]) {
 MyGraphicThread mgt = new MyGraphicThread();
 mgt.init();
 }
}