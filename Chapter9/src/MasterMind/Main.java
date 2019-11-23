/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> userGuess = new ArrayList<Integer>();
        int numPegs;    
        int numColours;
        int pegsCorrect = 0;
        int coloursCorrect = 0;
        
        /* prompts user for number of pegs, colours */
        System.out.print("Enter the number of pegs to use (1-10): ");
        numPegs = input.nextInt();
        System.out.print("Enter the number of colours to use (1-9): ");
        numColours = input.nextInt();
        
        
        int[] pegs = new int[numPegs];
        int[] colours = new int [numColours];
        
        /* prompts user for colour for pegs */
        for (int i = 0; i < pegs.length; i++){         
            System.out.print("Colour for peg " + (i+1) + ": ");
            int user = input.nextInt();
            if (user <= pegs.length){
                userGuess.add(user);
            } else{
                System.out.println("Invalid input");
            }
        }
        
        /* assigns random numbers to colours array */
        for (int i = 0; i < pegs.length; i++){              // assigns random numbers to colours array
            pegs[i] = (int) ((Math.random()* numColours) + 1);
        }
        
        /* correct pegs */
        for (int i = 0; i < pegs.length; i++){
            if (userGuess.get(i) == pegs[i]){
                pegsCorrect += 1;
            }
        }
        
        /* correcct colours */
        for(int i = 0; i < pegs.length; i++){
            for (int j = 0; j < colours.length; j++){
                if (userGuess.get(i) == pegs[j]){
                    colours[i] = 1;
                    coloursCorrect += 1;
                }
            }
        }        
        
        System.out.println("You have " + pegsCorrect + " peg(s) correct and " + coloursCorrect + " colour(s) correct.");
        
    }
}

