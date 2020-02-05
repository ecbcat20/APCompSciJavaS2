package twoDarray;

import java.io.File;
import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		int[][] gameBoard = new int[20][20];

		gameBoard = read();
		displayBoard(gameBoard);
		System.out.println();
		for (int x = 0; x < 5; x++) {
			gameBoard = lifeOrDeath(gameBoard);
		}
		displayBoard(gameBoard);
		displayStatistics(gameBoard);
	}

	public static int[][] read() {
		int[][] board = new int[20][20];
		// creating File instance to reference text file in Java
		try {
			File text = new File("G:/CS/the game of life/life100.txt");

			// Creating Scanner instance to read File in Java
			Scanner scnr = new Scanner(text);

			// Reading each line of file using Scanner class
			// int lineNumber = 1;
			for (int i = 0; i < 100; i++) {
				int row = scnr.nextInt();
				int col = scnr.nextInt();
				board[row - 1][col - 1] = 1;
			}

			scnr.close();
		} catch (Exception e) {

		}
		return board;
	}

	public static int[][] lifeOrDeath(int[][] b) {
		int[][] n = b;// new board
		int ncell = 0;// number of neighboring cells
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[0].length; col++) {// loop to check all spots
				for (int i = -1; i <= 1; i++) {
					for (int c = -1; c <= 1; c++) {// loop through surrounding spots to check for neighbors
						if (((row + i) != -1) && ((row + i) != 20) && ((col + c) != -1) && ((col + c) != 20)) {// check
							// to
							// see
							// if spot is
							// valid or not
							if ((b[row + i][col + c] == 1) && ((i != 0) || (c != 0)) && (b[row][col + 1] != 0)) {// determines
								// checks for neighboring cells and then wraps if they exist // if
								// there
								// is
								// a
								// cell
								// in
								// the neighboring location
								ncell++; // increase number of neighboring cells
							}
						}
					}
				}
				if (b[row][col] == 1 && ncell != 2 && ncell != 3)// checks if location contains a cell and whether it
					// dies
					n[row][col] = 0;
				else if (b[row][col] == 0 && ncell >= 3)// checks if new cell born
					n[row][col] = 1;
				ncell = 0;
			}
		}
		return n;
	}

	public static void displayBoard(int[][] a) {
		int count = 0;
		do {
			for (int x = 0; x < a.length; x++) {
				for (int y = 0; y < a[0].length; y++)
					System.out.print(a[x][y] + " ");
				System.out.println();
			}
			count++;
		} while (count <= 10);
	}

	public static void displayStatistics(int[][] a) {
		int population = 0;
		int cellsR10 = 0;
		int cellsC10 = 0;
		for (int[] arr : a)
			for (int item : arr)
				population += item;
		for (int item : a[9])
			cellsR10 += item;
		for (int x = 0; x < 20; x++)
			cellsC10 += a[x][9];
		System.out.println("Population: " + population);
		System.out.println("Cells in row 10: " + cellsR10);
		System.out.println("Cells in column 10: " + cellsC10);
	}
}
