package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Tyler Hegewald
 *
 */
public class SudokuMaker {

	public Object[][] board;//complete board filled with numbers
	ArrayList<Integer> numbers;//numbers 1-9
	boolean status;//true if the board is correctly made
	
	/**
	 * Makes the board to fill with numbers
	 */
	public SudokuMaker() {
		board = new Object[9][9];
		numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		status = false;
		maker();
	}
	
	/**
	 * Puts the numbers on the board after shuffling
	 * @return Object[][] returns the board
	 */
	public Object[][] maker(){
		Collections.shuffle(numbers);
		int rotate = 3;
		for(int x = 0; x < 9; x++) {
			if(x == 3 || x == 6) {
				rotateNumbers(1);
			}
			copyNumbers(x);
			rotateNumbers(rotate);
			
		}
		
		return board;
	}
	
	/**
	 * Returns the status of the board
	 * @return boolean true if the board is correct
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * copies the numbers into the array board
	 * @param row
	 */
	private void copyNumbers(int row) {
		for(int x = 0; x < 9; x++) {
			board[row][x] = numbers.get(x);
		}
	}
	
	/**
	 * rotates the numbers in the row
	 */
	private void rotateNumbers(int rotate) {
		Collections.rotate(numbers, rotate);
	}
	
	/**
	 * No longer being used
	 * @return
	 *//*
	public String checkBoard() {
		
		String ret = "";
	
		Set<Integer> check = new HashSet<Integer>();
		int x = 0;
		for(int y = 0; y < 9; y++) {
			for(x = 0; x < 9; x++) {
				check.add((Integer) board[x][y]);

			}
			if(check.size() != 9 || checkBoxes() == false) {
					status = false;
					ret += Boolean.toString(status);
					ret += x;
					return ret;
				}
				check = new HashSet<Integer>();
		}
		status = true;
		ret += Boolean.toString(status);
		return ret;
	}
	*/
	
	/**
	 * Checks each column to make sure each number is unique
	 * @param board Object[][] contains numbers to check
	 * @return boolean true if unique
	 */
	public boolean checkColumn(Object[][] board) {
		Set<Integer> check = new HashSet<Integer>();
		int x = 0;
		for(int y = 0; y < 9; y++) {
			for(x = 0; x < 9; x++) {
				check.add((Integer) board[x][y]);

			}
			if(check.size() != 9) {
					status = false;
					return status;
				}
				check = new HashSet<Integer>();
		}
		status = true;
		return status;
	}
	
	/**
	 * Checks the row for unique numbers only necessary after player input
	 * @param board Object[][] board containing numbers
	 * @return boolean true if each row is unique
	 */
	public boolean checkRow(Object[][] board) {
		Set<Integer> check = new HashSet<Integer>();
		int x = 0;
		for(int y = 0; y < 9; y++) {
			for(x = 0; x < 9; x++) {
				check.add((Integer) board[y][x]);

			}
			if(check.size() != 9) {
					status = false;
					return status;
			}
			check = new HashSet<Integer>();
		}
		status = true;
		return status;
	}
	
	/**
	 * Prints out the board
	 * @param board Object[][] board to print
	 */
	public void printBoard(Object[][] board) {
		 
		for(int x = 0; x < 9; x++) {
			System.out.println(Arrays.toString(board[x]));
		}
	}
	
	/**
	 * Checks to see if array contains number
	 * @param array int[] array of numbers
	 * @param number int number to search for
	 * @return boolean true if array contains number
	 */
	private boolean contains(int[] array, int number) {
		
		for(int x = 0; x < 9; x++) {
			if(array[x] == number) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks for all unique numbers in the first box in board
	 * @param board Object[][] board to check
	 * @return boolean true if all numbers are unique
	 */
	public boolean checkBoxOne(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box one is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the second box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all unique numbers
	 */
	public boolean checkBoxTwo(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 0; y < 3; y++) {
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box two is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the third box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all unique numbers
	 */
	public boolean checkBoxThree(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 0; y < 3; y++) {
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box three is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the fourth box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all unique numbers
	 */
	public boolean checkBoxFour(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 3; y < 6; y++) {
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box four is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the fifth box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all unique numbers
	 */
	public boolean checkBoxFive(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 3; y < 6; y++) {
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box five is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 *  Checks the sixth box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all numbers are unique
	 */
	public boolean checkBoxSix(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 3; y < 6; y++) {
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box six is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the seventh box for all unique numbers
	 * @param board Object[][] board to check all numbers
	 * @return boolean true if all numbers are unique
	 */
	public boolean checkBoxSeven(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box seven is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks box eight for unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all numbers are unique
	 */
	public boolean checkBoxEight(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box eight is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Checks the ninth box for all unique numbers
	 * @param board Object[][] board to check
	 * @return boolean true if all unique numbers
	 */
	public boolean checkBoxNine(Object[][] board) {
		if(board == null) {
			return false;
		}
		boolean status = true;
		int[] box = new int[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 1; x < 10; x++) {
			if(contains(box, x) == false) {
				System.out.println("Box nine is missing number " + x);
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Calls all the checkBoxes methods
	 * @param board Object[][] board to check
	 * @return boolean true if each box is unique
	 */
	public boolean checkBoxes(Object[][] board) {
		boolean checkBox = true;
		checkBox = checkBoxOne(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxTwo(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxThree(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxFour(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxFive(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxSix(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxSeven(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxEight(board);
		if(checkBox == false) {
			return checkBox;
		}
		checkBox = checkBoxNine(board);
		return checkBox;
	}
}
