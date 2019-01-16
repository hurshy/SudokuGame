package game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Tyler Hegewald
 *
 */

public class SudokuMain {
	
	static Scanner kb;//Scanner for player input kb for keyboard
	static Object[][] board;//This is the board with all numbers filled in and gets set equal to the board from SudokuMaker and SudokuBoardClearer
	static Object[][] clearedBoard;//This is the board with numbers taken out from SudokuBoardClearer
	static Object[][] playerBoard;//This is the board players will see and input onto made here
	static SudokuBoardClearer clearer;//This calls the class SudokuBoardClearer
	static SudokuMaker maker;//This calls the class SudokuMaker
	
	/**
	 * This is the main method of the game of sudoku
	 * It will make the boards from SudokuMaker and SudokuBoardClearer and make a new board for player input
	 * @param args
	 */
	public static void main(String args[]) throws InputMismatchException {
		
		boolean playAgain = true;
		while(playAgain) {//Makes it so the player can keep playing with new boards
			maker = new SudokuMaker();
			clearer = new SudokuBoardClearer();
			kb = new Scanner(System.in);
			board = clearer.board;
			clearedBoard = clearer.clearedBoard;
			playerBoard = clearedBoard;
			
			boolean t = true;
			boolean b = false;
			while(t) {
				try {
					while(contains('-', playerBoard)){//Checks for "empty" spaces
						maker.printBoard(playerBoard);
						System.out.println("What number should go into the first '-' space? I recommend solving it on paper first before entering the numbers in ");
						if(kb.next() == "exit") {
							b = true;
							break;
						}
						playerBoard[getYValue()][getXValue()] = kb.nextInt();
						kb.nextLine();
					}
					t = checkBoard();//Breaks the while loop
				
					if(checkBoard() == false) {//Restarts the playerBoard if the board is incorrect
						playerBoard = clearedBoard;
					}
				}catch(InputMismatchException | ClassCastException e) {
					System.out.println("Sorry please enter a number");
					kb.nextLine();
				}
				if(b == true) {
					break;
				}
			}
			if(b == false) {
				maker.printBoard(playerBoard);
				
				System.out.println("Congrats you completed the board!");
				//Checks to see if the player wants to play again
				System.out.println("Do you want to play again? (y/n)");
				char input = kb.next().charAt(0);
				if(input == 'y') {
					playAgain = true;
				}
				else {
					playAgain = false;
				}
			}
			
			kb.close();
			System.exit(0);
		}
	}
	
	/**
	 * Checks the board entered as param for a specific character c
	 * @param c character to search for
	 * @param playerBoard board to search in
	 * @return boolean true if contains false if doesn't
	 */
	private static boolean contains(char c, Object[][] playerBoard) {
		
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				if(playerBoard[y][x].equals(c)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Gets the x value of the first "empty" space '-'
	 * @return int of x value
	 */
	private static int getXValue() {
		
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				if(playerBoard[y][x].equals('-')) {
					return x;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Gets the y value for the first "empty" space '-'
	 * @return int of y value
	 */
	private static int getYValue() {
			
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				if(playerBoard[y][x].equals('-')) {
					return y;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Checks each small box, each row, and each column to see if every number is different
	 * The reason this method is in this class is because it checks things that wouldn't need to be 
	 * checked because of player input and will only be used in this class
	 * @return boolean true if correct
	 */
	private static boolean checkBoard() {
		boolean checkBox = true;
		boolean checkColumn = true;
		boolean checkRow = true;
		checkBox = maker.checkBoxOne(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxTwo(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxThree(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxFour(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxFive(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxSix(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxSeven(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxEight(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		checkBox = maker.checkBoxNine(playerBoard);
		checkColumn = maker.checkColumn(playerBoard);
		checkRow = maker.checkRow(playerBoard);
		if(checkBox == false || checkColumn == false || checkRow == false) {
			return false;
		}
		return true;
	}
}


