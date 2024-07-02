package bhuvana;

import java.util.Scanner;

public class Tictac {
	public static void main(String[] args) {
		char[][]board=new char[3][3]; //create a 2-D array and initialize a value of 3 to create a board
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[row].length; col++) {
				board[row][col]=' '; //initialize the board value to null by looping 
			}
		}
		char player='X';
		boolean isgameOver=false;
		Scanner scan= new Scanner(System.in);
		while(!isgameOver) {
			printBoard(board); // as long as game is not over then print a board using the function printboard
			System.out.println("Player: "+player+" enter: ");
			int row=scan.nextInt();
			int col=scan.nextInt(); // take a input of the coordinate as a entry
			if(board[row][col]==' ') { // check whether the coordinate where we are entering is empty  
				board[row][col] = player; // place the element
		        isgameOver = haveWon(board, player); // check the condition using haveWon function
		        if (isgameOver) {
		          System.out.println("Player " + player + " has won: ");
		        } else {
		          // if (player == 'X') {
		          // player = 'O';
		          // } else {
		          // player = 'X';
		          // }
		          player = (player == 'X') ? 'O' : 'X';
		        }
				
			}
			else {
				System.out.println("Invalid move..");
			}
		}
		printBoard(board);
	}
private static boolean haveWon(char[][] board, char player) {
		
	// check the rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    // check for column
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    // diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
   
		return false;
	}
public static void printBoard(char[][]board) {
	  for (int row = 0; row < board.length; row++) {
	      for (int col = 0; col < board[row].length; col++) {
	        System.out.print(board[row][col] + " | ");
	      }
	      System.out.println();
	    }
	
}
}
