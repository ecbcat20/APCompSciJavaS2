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
		} catch (Exception e) {

		}
		return board;
	}

	public static int[][] lifeOrDeath(int[][] b) {
		int[][] n = b;// new board
		int ncell = 0;// number of neighboring cells
		for (int x = 0; x < b.length; x++) {
			for (int y = 0; y < b[0].length; y++) {// loop to check all spots
				for (int i = -1; i <= 1; i++) {
					for (int z = -1; z <= 1; z++) {// loop through surrounding spots to check for neighbors
						if (((x + i) != -1) && ((x + i) != 20) && ((y + z) != -1) && ((y + z) != 20)) {// check to see
																										// if spot is
																										// valid or not
							if ((b[x + i][y + z] == 1) && ((i != 0) || (z != 0))) {// determines if there is a cell in
																					// the neighboring location
								ncell++;// increase number of neighboring cells
							}
						}
					}
				}
				if (b[x][y] == 1 && ncell != 2 && ncell != 3)// checks if location contains a cell and whether it dies
					n[x][y] = 0;
				else if (b[x][y] == 0 && ncell >= 3)// checks if new cell born
					n[x][y] = 1;
				ncell = 0;
			}
		}
		return n;
	}

	public static void displayBoard(int[][] a) {
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++)
				System.out.print(a[x][y] + " ");
			System.out.println();
		}
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
