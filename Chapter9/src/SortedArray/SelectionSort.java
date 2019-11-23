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
import java.util.Arrays;

public class SelectionSort {
    public int[] originalArray;
    public int[] sortedArray;

    /**
     * constructor
     * pre: none
     * post: SelectionSort object has been created
     * @param array 
     */
    public SelectionSort(int[] array){
        this.originalArray = array;
        this.sortedArray = array;
    }

    
    /**
     * Displays originalArray and sortedArray
     * pre: none
     * post: originalArray and sortedArray has been printed.
     */
    public void displayOriginal(){
        System.out.println("Original Array: " + Arrays.toString(originalArray));

    }
    
    /**
     * Display
     */
    public void displaySorted(){
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
    
    /**
     * Populates a new array with the elements of the original array in order from low to high
     * pre: none
     * post: originalArray has been sorted. sortedArray has been created.
     */
    public void sort() {
        Arrays.sort(originalArray);
        for(int i = 0; i < originalArray.length; i++){      // assign sorted elements of originalArray to sortedArray
            sortedArray[i] = originalArray[i];
        }
    }

    
    /**
     * Returns the index of the element containing the lowest value
     * pre: none
     * post: Index of the element containing the lowest value has been returned.
     * @return 
     */
    public void findLowest(){
        int[] lowest = {101};
        for(int i = 0; i < originalArray.length; i++){
            if(originalArray[i] < lowest[0]){
                lowest[0] = originalArray[i];
            }   
        }
        System.out.println(Arrays.toString(lowest));
    }
}

