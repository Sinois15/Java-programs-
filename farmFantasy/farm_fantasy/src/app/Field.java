package app; 

import java.util.Scanner;
public class Field{
    int x,y,z,posX,posY,size;
    Scanner sc = new Scanner(System.in);
    String[][] field = new String[9][9];
    public  void createField(){
        System.out.print("Please enter the size of the field you want to use: ");
        size=sc.nextInt();
        sc.nextLine();
        for (x=0;x<size;x++){
            for (y=0;y<size;y++){
                field[x][y]=" 0 ";
            }
        }
    }
    public void displayField(){
        System.out.print("   ");
        for (x=0;x<size;x++){
            System.out.print((x+1)+"   ");
        }
        System.out.println();
        System.out.print(" +");
        for (x=0;x<size;x++){
            System.out.print("---+");
        }
        System.out.println("");
        for (x=0;x<size;x++){
            System.out.print((x+1));
            System.out.print("|");
            for (y=0;y<size;y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
            System.out.print(" +");
            for (z=0;z<size;z++){
                System.out.print("---+");
            }
            System.out.println();
    }
}
    public void setPosition(int x, int y){
         posX=x;
         posY=y;
    }
    
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    
}