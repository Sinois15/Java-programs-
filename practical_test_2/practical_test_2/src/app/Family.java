package app;

public class Family{
    
    private double income;
    private int size;
    public Family(double income, int size){
        this.income=income;
        this.size=size;

    }
    
    public boolean isPoor(double housingCost, double foodCost){
        boolean poor;
        if ((housingCost + foodCost) * size > (income/2)){
            poor = true;
            System.out.println("Poor.");
        }else 
            poor = false;
        return poor;
    }
   
            
    
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString(){
        return "Income: $" + income + "\nSize: " + size + "\nStatus: " ;
    }
}