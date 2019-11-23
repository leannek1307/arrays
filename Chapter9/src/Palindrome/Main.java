/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palindrome;

import java.util.*;

/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        
        System.out.print("Enter a string: ");
        str = input.nextLine();
        str = str.replaceAll(" ", "");
        boolean PALINDROME = false;
        
        /* converts str to char array */
        char[] chars = str.toCharArray();
        
        /* checks if the string is palindrome */
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == chars[chars.length - (i+1)]){
                PALINDROME = true;
            } else{
                PALINDROME = false;         /* you HAVE to write an else statement because the loop
                                            will go on forever*/
            }
        }
        
        /* prints output */
        if (PALINDROME){
            System.out.println("palindrome");
        }else{
            System.out.println("not a palindrome");
        }
    }
}

