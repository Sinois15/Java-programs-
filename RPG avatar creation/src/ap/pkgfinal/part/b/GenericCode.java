/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.pkgfinal.part.b;

/**
 *
 * @author User
 */
public class GenericCode {
    
    public <T> void displayWhatever(T whatever){
        System.out.println("=============");
        System.out.println("whatever u wanted to output is "+whatever);
        System.out.println("=============");
        
    }
    
    public void process(){
         int num = 15;
         double balance = 0.0;
         String pain ="sunavab.....!!!!";
         displayWhatever(num);
         displayWhatever(balance);
         displayWhatever(pain);
    }
    
    public static void main(String[] args){
        GenericCode gc = new GenericCode();
        gc.process();
    }
}
