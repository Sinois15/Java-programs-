/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;


public class BubbleSort {

     public static void main(String[] args) {

        int arr1[] = {  6, 32, 7, 2, 99, 31, 53  };
        int temp; 
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i+1; j < (arr1.length); j++) {
                if (arr1[j] < arr1[i]) {
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
            System.out.print("Iteration number "+(i+1)+": ");
            for (int l = 0; l< arr1.length; l++) {
                    System.out.print(arr1[l] + " ");
            }
            System.out.println("");

        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

}

