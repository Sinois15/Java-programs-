public class MyGenerics{
    public void display(int k){
        System.out.println("**********");
        System.out.println("value is "+k);
        System.out.println("**********");
        
    }
    
    public void display(double k){
        System.out.println("**********");
        System.out.println("value is "+k);
        System.out.println("**********");
        
    }
    
    public void display(String k){
        System.out.println("**********");
        System.out.println("value is "+k);
        System.out.println("**********");
        
    }
    
    public <T> void displayAll(T k){
        System.out.println("**********");
        System.out.println("value is "+k);
        System.out.println("**********");
        
    }
   
    public void process(){
         int a = 45;
         double b = 4.5;
         String c ="Yay";
         displayAll(a);
         displayAll(b);
         displayAll(c);
    }
    
    public static void main(String[] args){
        MyGenerics mg = new MyGenerics();
        mg.process();
    }
}