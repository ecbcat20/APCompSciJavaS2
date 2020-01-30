package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vote {

	public static void toDisplay(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "  ");
			}
			System.out.println();
		}
	}

	public static int[][] read() throws FileNotFoundException {
		// creating File instance to reference text file in Java
		File text = new File("G:/CS/vote.txt");
		int[][] ballots = new int[2000][4];

		// Creating Scanner instance to read File in Java
		Scanner scnr = new Scanner(text);

		// Reading each line of file using Scanner class
		// int lineNumber = 1;

		for (int i = 0; i < 2000; i++) {
			// use scanner to read each number and initialize the 2-D array
			for (int j = 0; j < 4; j++) {
				ballots[i][j] = scnr.nextInt();
			}
		}

		scnr.close();
		return ballots;
	}

	public static void main(String[] args) throws FileNotFoundException {
		int[][] ballots2 = read();
		int count = 2000;
		int cand1, cand2, cand3, cand4;
		cand1 = 0;
		cand2 = 0;
		cand3 = 0;
		cand4 = 0;

		// need to check for valid ballots

		while (count >= 0) {
			for (int row = 0; row < ballots2.length; row++) {
				for (int col = 0; col < ballots2[0].length; col++) {

					if (col == 0 && ballots2[row][col] == 1) {
						cand1++;
						count--;
					} else if (col == 0 && ballots2[row][col] == 0) {
						count--;
						continue;
					}

					if (col == 1 && ballots2[row][col] == 1) {
						cand2++;
						count--;
					} else if (col == 1 && ballots2[row][col] == 0) {
						count++;
						continue;
					}

					if (col == 2 && ballots2[row][col] == 1) {
						cand3++;
						count--;
					} else if (col == 2 && ballots2[row][col] == 0) {
						count--;
						continue;
					}

					if (col == 3 && ballots2[row][col] == 1) {
						count--;
						cand4++;
					} else if (col == 3 && ballots2[row][col] == 0) {
						count--;
						continue;
					}

				}
			}
		}

		System.out.println(cand1 + "  " + cand2 + "  " + cand3 + "  " + cand4 + "  ");

	}

}
