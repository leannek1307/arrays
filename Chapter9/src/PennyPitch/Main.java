/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PennyPitch;

/**
 *
 * @author leannekim
 */
import java.util.*;

public class Main {
    private static String[][] board;
    
    /**
     * Adds items to board
     * pre: none
     * post: Items have been added to the board.
     * @param item
     * @param quantity 
     */
    public static void addItem(String item, int quantity){
        Random rand = new Random();
        int row, column;
        int posFilled = 0;
        
        while (posFilled < quantity){
            row = rand.nextInt(board.length);
            column = rand.nextInt(board[0].length);
            if("".equals(board[row][column])){          // if cell is empty
                board[row][column] = item;              // assign String item to cell
                posFilled += 1;                         // increment posFilled so that Strings won't overlap
            }
        }
    }
    
    /**
     * Places penny, counts penny, returns boolean value if penny = 3
     * pre: String item
     * post: State of pennyPlaced has been returned.
     * @param item
     * @return 
     */
    public static boolean isWinner(String item){
        int pennyPlaced = 0;
        for(int i = 0; i < board.length; i++){          // row
            for(int j = 0; j < board[0].length; j++){   // column
                if (board[i][j].endsWith(item + "@")){
                    pennyPlaced += 1;
                }
            }
        }
        
        if(pennyPlaced == 3){
            return true;
        } else {
            return false;
        }
    }
    

    public static void main(String[] args) {
        Random rand = new Random();
        
        /* create empty spaces */
        board = new String[5][5];
        for (int i = 0; i < board.length; i++) {            // row
            for (int j = 0; j < board[0].length; j++) {     // column
                    board[i][j] = "";
            }
        }
        
        /* assign String values to board */
        addItem("PUZZLE", 3);
        addItem("POSTER", 3);
        addItem("BALL", 3);
        addItem("GAME", 3);
        addItem("DOLL", 3);
        
        /* throw pennies */
        int row, column;
        
        for(int numPennies = 1; numPennies <= 10; numPennies++){
            row = rand.nextInt(board.length);
            column = rand.nextInt(board[0].length);
            board[row][column] += "@";
        }
        
        /* display board */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.format("%2s %-10s %2s", "[", board[i][j], "]");
            }System.out.println();
        }System.out.println();
        
        /* announce prize */
        boolean wonPrize = false;
        System.out.print("You have won: ");
        if(isWinner("PUZZLE")){
            wonPrize = true;
            System.out.println("PUZZLE");
        }
        if(isWinner("POSTER")){
            wonPrize = true;
            System.out.println("POSTER");
        }
        if(isWinner("BALL")){
            wonPrize = true;
            System.out.println("BALL");
        }
        if(isWinner("GAME")){
            wonPrize = true;
            System.out.println("GAME");
        }
        if(isWinner("DOLL")){
            wonPrize = true;
            System.out.println("DOLL");
        }
        if (!wonPrize){
            System.out.println("NONE");
        }
    }
}
