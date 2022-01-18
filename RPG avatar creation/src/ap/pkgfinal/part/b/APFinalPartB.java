/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.pkgfinal.part.b;

abstract class Weapon{
    
    abstract void action();
}

public class Blade extends Weapon{
    
    public void action(){
        System.out.println("slash");
    }
}
