/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop;

/**Important note:
static attribute – shared variable; belongs to the class
static method – can use the method without instantiation (object); belongs the class
final attribute – a constant; cannot change its value
final method – prevent subclass method overriding
final class – prevent sub classing of the base class (super class); cannot extend
abstract method – to force subclass to implement the method
abstract class – to indicate an incomplete class (cannot be instantiated)

 */
public class ComputerShop {
 Notebook nb1, nb2;

 public void runProgram() {
 nb1 = new Notebook("Dell 3300", 2.2);
 nb2 = new Notebook("Acer 1810", 1.5);

 nb1.showDetail();
 nb2.showDetail();
 System.out.println("QTY1 : " + nb1.getQty());
 System.out.println("QTY2 : " + nb2.getQty());
 nb1.showComputerType();
 }

 public static void main(String args[]) {
 ComputerShop css = new ComputerShop();
 css.runProgram();
 }
}
