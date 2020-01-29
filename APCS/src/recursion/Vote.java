package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vote {

	public static void read() throws FileNotFoundException {
		int[][] toUse = new int[2000][4];
		// creating File instance to reference text file in Java
		File text = new File("G:/CS/vote.txt");

		// Creating Scanner instance to read File in Java
		Scanner scnr = new Scanner(text);

		// Reading each line of file using Scanner class
		int count = 0;
		while (count <= 2000) {
			for (int row = 0; row < toUse.length; row++) {
				for (int col = 0; col < toUse[0].length; col++) {
					int i = scnr.nextInt();
					toUse[row][col] = i;
					count++;
				}
			}
		}
		
		scnr.close();
		toDisplay(toUse);
	}

	public static void toDisplay(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		read();
		
	}

}
