package recursion;

public class TwoDArrayTest2 {

	public static void main(String[] args) {
		int toUse[][] = new int[10][10];
		toUse[2][1] = 5;

		// initialize from 1 to 99
		int count = 0;
		for (int row = 0; row < toUse.length; row++) {
			for (int col = 0; col < toUse[0].length; col++) {
				toUse[row][col] = count;
				count++;
			}
			System.out.println();
		}

		display(toUse);

		// print first diagonal

		for (int row = 0; row < toUse.length; row++) {
			for (int col = 0; col < toUse[0].length; col++) {
				if (row == col) {
					System.out.print(toUse[row][col] + " ");
				}
			}
		}

		System.out.println();
		// print second diagonal

		for (int row = toUse[0].length; row >= 0; row--) {
			for (int col = 0; col < toUse.length; col++) {
				if(row == col) {
					System.out.print(toUse[row][col] + " ");
				}
			}
		}

		// a.length; gives rows
		// a[0].length; gives columns

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
