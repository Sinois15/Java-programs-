/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstuib;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class FirstUIB implements ActionListener {
 JFrame f;
 JPanel p;
 JButton btnExit;
 JButton btnOut;

 public FirstUIB() {

 f = new JFrame();
 p = new JPanel();
 }
 public void init() {
 f.setTitle("My Second Exercise");
 f.setSize(800,300);
 p.setLayout(null);
 JLabel labName = new JLabel("Minah oh Minah");
 labName.setBounds(345,75,150,50);
 p.add(labName);
 btnExit = new JButton("EXIT");
 btnExit.setBounds(25,200,725,50);
 btnExit.addActionListener(this);
 btnOut = new JButton("OUT");
 btnOut.setBounds(340,25,100,50);
 btnOut.addActionListener(this);
 p.add(btnExit);
 p.add(btnOut);
 f.add(p);
 f.setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
 if ((e.getSource() == btnExit) || e.getSource() == btnOut)
 System.exit(0);
 }
 public static void main(String args[]) {
 FirstUIB mfui = new FirstUIB();
 mfui.init();
 }
} 
