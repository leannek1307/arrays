/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountConsonants;

/**
 *
 * @author leannekim
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        int numCons = 0;
        
        /* prompts user for string */
        System.out.print("Enter text: ");
        str= input.nextLine();
        str = str.replaceAll(" ", "");
        
        /* converts str to an char array */
        char[] string = str.toCharArray();
        
        /* checks if the elements of the char array is a consonant.
           If it is a consonant, numCons is incremented by 1.
        */
        for(int i = 0; i < string.length; i++){
            if  (string[i] == 'a'||
                string[i] == 'e'||
                string[i] == 'i'||
                string[i] == 'o'||
                string[i] == 'u'){
                numCons++;
            } 
        }
        
        /* prints number of consonants */
        System.out.println("The number of consonants in java programming is " + numCons);
    }
}

