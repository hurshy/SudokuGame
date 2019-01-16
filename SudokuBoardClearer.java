package game;

import java.util.Random;

/**
 * 
 * @author Tyler Hegewald
 *
 */
public class SudokuBoardClearer {

	public Object[][] board;//Sudoku board with all the numbers on it from SudokuMaker
	public Object[][] clearedBoard;//Sudoku board with numbers gone made here
	private int[] removedNumbers;//The removed numbers
	private int n; //amount of removed numbers
	SudokuMaker sudoku;//Calls SudokuMaker
	
	/**
	 * Makes a new board to put the cleared numbers onto
	 */
	public SudokuBoardClearer() {
		sudoku = new SudokuMaker();
		this.board = sudoku.board;
		clearedBoard = new Object[9][9];
		removedNumbers = new int[81];
		n = 0;
		clearer();
	}
	
	/**
	 * This method randomly gets a number which the amount of numbers the class will remove from each box
	 */
	public void clearer() {
		if(sudoku.getStatus() == false) {
			while(sudoku.getStatus() == false) {
				sudoku.maker();
				sudoku.checkBoxes(board);
				sudoku.checkColumn(board);
			}
			this.board = sudoku.board;
		}
		Random rand = new Random();
		int n = rand.nextInt(4) + 4;
		clearNumbersBoxOne(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxTwo(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxThree(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxFour(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxFive(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxSix(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxSeven(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxEight(n);
		n = rand.nextInt(4) + 4;
		clearNumbersBoxNine(n);
	}
	
	/**
	 * Stores the removed numbers into an array and keeps track of how many numbers are removed
	 * @param number the number from the board that was removed
	 */
	private void removedNumbersAdd(int number) {
		removedNumbers[n] = number;
		n++;
	}
	
	/**
	 * This clears number amount of numbers from the board and will randomly pick a number in the small box to remove
	 * @param number amount of numbers to remove
	 * @return boolean true if it was able to remove the numbers
	 */
	public boolean clearNumbersBoxOne(int number) {
		if(board == null) {//if board is null then it can't remove numbers
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];//an array of numbers from box one
		int z = 0;
		for(int y = 0; y < 3; y++) {//adds the numbers to box
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly removes a number and sets it equal to '-' if a place it already '-' it will find a new place to remove from
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the removed number to an array
			box[n] = '-';
		}
		
		int a = 0;
		for(int y = 0; y < 3; y++) {//adds the numbers and '-' into the clearedBoard
			for(int x = 0; x < 3; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Clears the amount number of numbers from box number 2 and replaces each removed number with '-'
	 * @param number amount of numbers to remove
	 * @return boolean true if able to remove numbers
	 */
	public boolean clearNumbersBoxTwo(int number) {
		if(board == null) {//can't remove numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];//array of object to put the numbers from box two into
		int z = 0;
		for(int y = 0; y < 3; y++) {//puts the numbers into box
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly takes a number out of the array and replaces it with '-' 
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {//if the spot is already equal to '-' then it will find a new spot
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the removed number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 0; y < 3; y++) {//puts the numbers and '-' into the clearedBoard
			for(int x = 3; x < 6; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes amount number of numbers from box number three and replaces each number with '-'
	 * @param number amount of numbers to remove
	 * @return boolean true if it could remove the numbers
	 */
	public boolean clearNumbersBoxThree(int number) {
		if(board == null) {//can't remove numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];//array to add the numbers from box three to
		int z = 0;
		for(int y = 0; y < 3; y++) {//adds the numbers to the array
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly finds a number to remove 
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {//always makes sure its removing a number
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the removed number to an array
			box[n] = '-';//removes the number and replaces it with '-'
		}
		
		int a = 0;
		for(int y = 0; y < 3; y++) {//adds the numbers and '-' to clearedBoard
			for(int x = 6; x < 9; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes number amount of numbers from box four and replaces them with '-'
	 * @param number int amount of numbers to remove
	 * @return boolean true if it was able to remove the numbers
	 */
	public boolean clearNumbersBoxFour(int number) {
		if(board == null) {//can't replaces numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];//an array to add numbers from box four to
		int z = 0;
		for(int y = 3; y < 6; y++) {//adds the numbers to the array box
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly replaces a number
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the number to an array
			box[n] = '-';//removes the number and replaces it with '-'
		}
		
		int a = 0;
		for(int y = 3; y < 6; y++) {//adds the numbers and '-' into the clearedBoard array
			for(int x = 0; x < 3; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Replaces number amount of numbers with '-'
	 * @param number int amount of numbers to remove
	 * @return boolean true if able to remove numbers
	 */
	public boolean clearNumbersBoxFive(int number) {
		if(board == null) {//can't remove numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];//an array to add numbers from box five to
		int z = 0;
		for(int y = 3; y < 6; y++) {//adds the numbers to box
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly replaces a number
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 3; y < 6; y++) {//puts the numbers and '-' into clearedBoard
			for(int x = 3; x < 6; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes number amount of numbers from box six
	 * @param number int amount of numbers to remove
	 * @return boolean true if removed numbers
	 */
	public boolean clearNumbersBoxSix(int number) {
		if(board == null) {//can't remove numbers if board is false
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];
		int z = 0;
		for(int y = 3; y < 6; y++) {//adds the numbers to box
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly removes the numbers
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the removed number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 3; y < 6; y++) {//adds the numbers and '-' into clearedBoard
			for(int x = 6; x < 9; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes number amount of numbers from box seven
	 * @param number int amount of numbers to remove
	 * @return boolean true if removed numbers
	 */
	public boolean clearNumbersBoxSeven(int number) {
		if(board == null) {//can't remove numbers if board is false
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers to the array box
			for(int x = 0; x < 3; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly removes numbers
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers and '-' into clearedBoard
			for(int x = 0; x < 3; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes number amount of numbers from box eight
	 * @param number int amount of numbers to remove
	 * @return boolean true if removed the numbers
	 */
	public boolean clearNumbersBoxEight(int number) {
		if(board == null) {//can't remove numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers to box
			for(int x = 3; x < 6; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly removes each number
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers and '-' to clearedBoard
			for(int x = 3; x < 6; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
	
	/**
	 * Removes number amount of numbers from box nine
	 * @param number int amount of numbers to remove
	 * @return boolean true if removed the numbers
	 */
	public boolean clearNumbersBoxNine(int number) {
		if(board == null) {//can't remove numbers if board is null
			return false;
		}
		boolean status = true;
		Object[] box = new Object[9];
		int z = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers to box
			for(int x = 6; x < 9; x++) {
				box[z] = (int) board[y][x];
				z++;
			}
		}
		for(int x = 0; x < number; x++) {//randomly removes the numbers
			Random rand = new Random();
			int n = rand.nextInt(9);
			if(box[n].equals('-')) {
				while(box[n].equals('-')) {
					n = rand.nextInt(9);
				}
			}
			removedNumbersAdd((int) box[n]);//adds the number to an array
			box[n] = '-';//replaces the number
		}
		
		int a = 0;
		for(int y = 6; y < 9; y++) {//adds the numbers and '-' to clearedBoard
			for(int x = 6; x < 9; x++) {
				clearedBoard[y][x] = box[a];
				a++;
			}
		}
		return status;
	}
}
