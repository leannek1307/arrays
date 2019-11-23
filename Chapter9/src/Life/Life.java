/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Life;

/**
 *
 * @author leannekim
 */
public class Life {

    int columns, rows;
    int[][] board;

    public Life() {
        // Initialize rows, columns and set-up arrays
        columns = 20;
        rows = 20;
        board = new int[columns][rows];
        //next = new int[columns][rows];
        // Call function to fill array with random values 0 or 1
        init();
    }

    public void init() {
        for (int i =1;i < columns-1;i++) {
          for (int j =1;j < rows-1;j++) {
            board[i][j] = 0;
          }
        }
    }

    // user input coordinates of live cells
    public void coordinate(int x, int y){
        board[x][y] = 1;
    }
    
    // Creating new generation
    public void generate() {
            // array for next generation
            int[][] nextGen = new int[columns][rows];

            // Loop through every spot in the array and check spots neighbors
            for (int x = 1; x < columns-1; x++) {
                for (int y = 1; y < rows-1; y++) {

                  // Add up all the states in a 3x3 surrounding grid
                    int neighbors = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            neighbors += board[x+i][y+j];
                        }
                    }

                  // Subtract the current cell's state (already added it in the loop above)
                  neighbors -= board[x][y];

                  
                  if ((board[x][y] == 1) && (neighbors <  2)){         // Loneliness
                        nextGen[x][y] = 0;      
                  } else if ((board[x][y] == 1) && (neighbors >  3)){  // Overpopulation
                        nextGen[x][y] = 0;
                  } else if ((board[x][y] == 0) && (neighbors == 3)) { // Reproduction
                        nextGen[x][y] = 1;
                  } else { 
                        nextGen[x][y] = board[x][y];  // Static
                  }
                }
            }
            
            board = nextGen;
    }

    // "X" indicates living cells, "O" indicates dead cells.
    public void display() {
        for ( int i = 0; i < columns;i++) {
            for ( int j = 0; j < rows;j++) {
                if ((board[i][j] == 1)){
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
               
            }
            System.out.println();
        }
    }
    
    
}
