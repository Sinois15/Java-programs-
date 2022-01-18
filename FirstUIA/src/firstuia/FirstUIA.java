/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstuia;

/**
 *
 * @author User
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class FirstUIA implements ActionListener {
 JFrame f;
 JPanel p;
 JButton btnExit;

 public FirstUIA() {

 f = new JFrame();
 p = new JPanel();
 }
 public void init() {
 f.setTitle("My First Exercise");
 f.setSize(400,300);
 p.setLayout(null);
 JLabel labName = new JLabel("Minah oh Minah");
 labName.setBounds(150,75,150,50);
 p.add(labName);
 btnExit = new JButton("EXIT");
 btnExit.setBounds(25,200,325,50);
 btnExit.addActionListener(this);
 p.add(btnExit);
 f.add(p);
 f.setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
 if (e.getSource() == btnExit)
 System.exit(0);
 }
 public static void main(String args[]) {
 FirstUIA mfui = new FirstUIA();
 mfui.init();
 }
} 
