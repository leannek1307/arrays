/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortedArray;

/**
 *
 * @author leannekim
 */
import java.util.*;

/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] myNums;
        SelectionSort sortedArray;
        int numValues;
        
//        prompt user for the number of values to populate array with
        System.out.print("Enter number of values to populate array with: "); 
        numValues = input.nextInt();
       
        myNums = new int[numValues];
        
//        populate array with random integers between 0 and 100
        for(int i = 0; i < myNums.length; i++){
            myNums[i] = (int)(Math.random() * 101);
        }

//        display contents of original array 
        System.out.println(Arrays.toString(myNums));
        
        sortedArray = new SelectionSort(myNums);
        
        System.out.print("\nLowest value of original array: ");
        sortedArray.findLowest();
        
        System.out.println();
        
        sortedArray.displayOriginal();
        
        sortedArray.sort();
        
        sortedArray.displaySorted();
        
        
        
    }
}

