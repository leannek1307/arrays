/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Life;

import java.util.*;
/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Life gameOfLife = new Life();
        int numLiveCells;
        
        System.out.print("Enter the number of live cells: ");
        numLiveCells = input.nextInt();
        
        for (int i = 0; i < numLiveCells; i++){
            int x, y;
            System.out.print("\nEnter x coordinate: ");
            x = input.nextInt();
            System.out.print("Enter y coordinate: ");
            y = input.nextInt();
            
            gameOfLife.coordinate(x,y);
        }
        

        /* First day, only 3 coordinates assign are alive */
        gameOfLife.display();
        
        /* Check neighbor */
        gameOfLife.generate();
        
        /* Display next day */
        System.out.println();
        gameOfLife.display();
        
    }
}

