/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytransport;

/**
 *
 * @author User
 */
public class JetSki extends Vehicle implements Engine{
    public JetSki(String t, int s) {
        super(t, s);
    }
    public void startEngine() {
        System.out.println("JetSki engine starts - vroosh...vroosh...");
    }
}
