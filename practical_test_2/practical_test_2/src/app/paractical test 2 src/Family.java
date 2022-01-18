package app;

public class Family{
    
    private double income;
    private int size;
    public Family(double income, int size){
        this.income=income;
        this.size=size;

    }
    public boolean isPoor(double housingCost, double foodCost){
        boolean valid;
        if ((housingCost + foodCost) * size > (income/2)){
            valid = true;
        }else 
            valid = false;
        return valid;
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
        return "Income: $" + income + "\nSize: " + size ;
    }
}