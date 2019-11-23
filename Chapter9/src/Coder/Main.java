/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coder;

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
        String str;
        System.out.print("Enter text: ");
        str = input.nextLine();
        
        char[] chars = str.toCharArray();
        int[] integer = new int[chars.length];
        
//        convert characters of the array to ascii numbers 
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == 'Y'){
                chars[i] = 'A';
            } else if (chars[i] == 'y'){
                chars[i] = 'a';
            } else if(chars[i] == 'Z'){
                chars[i] = 'B';
            } else if(chars[i] == 'z'){
                chars[i] = 'b';
            }
            char character = chars[i]; 
            int ascii = (int) character; 
            ascii += 2;
            integer[i] = ascii;
        }
        
        
//        convert ascii numbers back to characters
        for(int i = 0; i < chars.length; i++){
            chars[i] = (char) integer[i];
            if(chars[i] == '"'){
                chars[i] = ' ';
            }
        }
        
//        print encoded message
        System.out.println("Encoded message: " + chars);
    }   
}

