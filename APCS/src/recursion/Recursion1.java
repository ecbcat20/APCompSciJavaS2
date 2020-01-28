package recursion;

public class Recursion1 {

	public static void main(String[] args) {
		int toUse[][] = new int[5][3];
		toUse[2][1] = 5;

		// initialize from 1 to 15
		int count = 0;
		for (int row = 0; row < toUse.length; row++) {
			for (int col = 0; col < toUse[0].length; col++) {
				toUse[row][col] = count;
				count++;
			}
			System.out.println();
		}

		// only output the second row
		for (int col = 0; col < toUse[1].length; col++) {
			System.out.print(toUse[1][col] + " ");
		}

		// output third column
		for (int row = 0; row < toUse.length; row++) {
			System.out.println(toUse[row][2]);

		}

		// a.length; gives rows
		// a[0].length; gives columns

		display(toUse);
	}

	public static void display(int[][] a) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				System.out.print(a[row][col] + "  ");
			}
			System.out.println();
		}
	}

}
