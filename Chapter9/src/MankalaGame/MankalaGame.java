/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MankalaGame;

/**
 *
 * @author leannekim
 */
/*
 * MankalaGame class
 */
 
 import java.util.Scanner;
 
 public class MankalaGame {
 	private int[][] board;
 	private int player;		//0 or 1
 	
 	/**
	 * constructor
	 * pre: none
	 * post: The Mankala board has been created.
	 */
	public MankalaGame() {
		
		board = new int[2][7];			//6 home pits and a home bin for two players
		initBoard();
		player = 0;						//start with player 0;
 	}


	/** 
	 * Stones are placed in the Mankala board.
	 * pre: none
	 * post: Stones have been placed in the Mankala board.
	 */
	private void initBoard() {
		/* place 3 stones in each pit */
		for (int player = 0; player < board.length; player++) {
			for (int pit = 0; pit < board[0].length - 1; pit++) {
				board[player][pit] = 3;
			}
			board[player][6] = 0;		//home pit should not contain any stones
		}
	}


	/** 
	 * Returns which player's turn it is
	 * pre: none
	 * post: The player whose turn is next is returned
	 */
	private int opponent() {
		
		if (player == 0) {
			return(1);
		} else {
			return(0);
		}
	}
	
	
	/** 
	 * The board is displayed with the current player's move
	 * letter displayed.
	 * pre: player is 0 or 1
	 * post: The board with move letters has been displayed.
	 */
	private void showBoard() {
		int bottomPlayer = 0;           //pits on "bottom" of board
		int topPlayer = 1;		//pits on "top" of board
		
		/* display move letter on top row if player 1 turn */
		if (player == 1) {
			System.out.format("%3s", "");
			for (int pitNum = 5; pitNum >= 0; pitNum--) {
				System.out.format("%3s", (char)((int)'A' + pitNum));
			}
			System.out.println();
		}
		
		/* display top player pits */
		System.out.format("%3s", "");
		for (int pit = board[0].length - 2; pit >= 0 ; pit--) {
			System.out.format("%3s", board[topPlayer][pit]);
		}
		System.out.println();
		
		/* display home bins */
		System.out.format("%3s %20s", board[1][6], board[0][6]);
		System.out.println();
		
		/* display bottom player pits */
		System.out.format("%3s", "");
		for (int pit = 0; pit < board[0].length - 1; pit++) {
			System.out.format("%3s", board[bottomPlayer][pit]);
		}
		System.out.println();

		/* display move letter on bottom row if player 0 turn */
		if (player == 0) {
			System.out.format("%3s", "");
			for (int pitNum = 0; pitNum < 6; pitNum++) {
				System.out.format("%3s", (char)((int)'A' + pitNum));
			}
			System.out.println();
		}

	}
	
	
	/** 
	 * Obtains a move from the player
	 * pre: The board has been displayed for the current player
	 * post: The player has entered a valid move.
	 */
	private int getMove() {
		Scanner input = new Scanner(System.in);
		String moveChoice;
		char moveLetter;
		int spot;
		
		do {
                    System.out.print("\nEnter your move: ");
                    moveChoice = input.nextLine();
                    moveChoice = moveChoice.toUpperCase();
                    moveLetter = moveChoice.charAt(0);
		} while (!(moveLetter >= 'A' && moveLetter <= 'F') || board[player][moveLetter - 'A'] <= 0);
		spot = moveLetter - 'A';
		return(spot);
	}
	

	/** 
	 * Sow the stones from pit around the board
	 * pre: none
	 * post: The stones from pit have been sewn around the board.
	 */
	private boolean sow(int pit) {
		int numStones;
		int sowSide;
		
		/* remove stones from pit */
		numStones = board[player][pit];
		board[player][pit] = 0;
		
		/* sow stones around board */
		sowSide = player;
		while (numStones > 0) {
			if (pit + 1 > 6) {
				sowSide = opponent();
				pit = 0;
			} else {
				pit += 1;
			}
			board[sowSide][pit] += 1;
			numStones -= 1;
		}
		
		/* determine if last stone landed in player's pit */
		if (sowSide == player && pit == 6) {
			return(true);
		} else {
			return(false);
		}
	}


	/** 
	 * Returns that total number of stones available
	 * to the player
	 * pre: player is 0 or 1
	 * post: The number of stones available to the player
	 * has been returned.
	 */
	private int totalStones(int player) {
		int total = 0;
		
		for (int pit = 0; pit < board[0].length - 1; pit++) {
			total += board[player][pit];
		}
		return(total);
	}

	
	/** 
	 * Plays a game of Mankala until a player cannot make a move
	 * pre: none
	 * post: A game of Mankala has been played between two players.
	 */
	public void play() {
		int pit;
		
		do {
			showBoard();
			pit = getMove();
			if (!sow(pit)) {	//next player's turn if stone doesn't land in home bin
				player = opponent();
			} else {
				System.out.println("You get another turn!");
			}
		} while (totalStones(player) > 0);
		
		showBoard();
		if (board[0][6] > board[1][6]) {
			System.out.println("Player 0 wins!");
		} else if (board[0][6] < board[1][6]) {
			System.out.println("Player 1 wins!");
		} else {
			System.out.println("It's a tie!");
		}
	}	
 }
