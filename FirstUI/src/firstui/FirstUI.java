/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class FirstUI implements ActionListener {
 JFrame f;
 JPanel p;
 JButton btnExit;
 JLabel labName;
 JTextField txtName;

 public FirstUI() {

 f = new JFrame();
 p = new JPanel();
 }
 public void init() {
 f.setTitle("My First GUI");
 f.setSize(400,300);
 p.setLayout(null);
 labName = new JLabel("Mat b Mamat");
 labName.setBounds(25,25,100,50);
 p.add(labName);
 txtName = new JTextField();
 txtName.setBounds(25,75,100,50);
 p.add(txtName);
 btnExit = new JButton("EXIT");
 btnExit.setBounds(300,200,90,50);
 btnExit.addActionListener(this);
 p.add(btnExit);
 f.add(p);
 f.setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
 if (e.getSource() == btnExit)
    labName.setText(txtName.getText());
 }
 public static void main(String args[]) {
 FirstUI mfui = new FirstUI();
 mfui.init();
 }
} 
