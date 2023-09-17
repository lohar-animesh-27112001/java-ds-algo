import java.util.*;

public class Array_2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] firstTwoD = new int[2][2];

		firstTwoD[0][0] = 4;
		firstTwoD[0][1] = 6;
		firstTwoD[1][0] = 2;
		firstTwoD[1][1] = 10;

		System.out.println(Arrays.deepToString(firstTwoD));

		String[][] secondTwoD = new String[2][2];

		secondTwoD[0][0] = "a";
		secondTwoD[0][1] = "c";
		secondTwoD[1][0] = "d";
		secondTwoD[1][1] = "b";

		System.out.println(Arrays.deepToString(secondTwoD));

		// Push in 2D array
		twoDArray thirdArr = new twoDArray(3, 2);
		thirdArr.push(12);
		thirdArr.push(15);
		thirdArr.push(2);
		thirdArr.insert(1, 1, 1000);
		thirdArr.push(100);
		thirdArr.push(21);
		thirdArr.insert(2, 1, 213);
		thirdArr.printAll();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.pop();
		thirdArr.print();
	}

}

class twoDArray {
	int[][] arr;
	int row_index = 0;
	int column_index = 0;

	public twoDArray(int row, int column) {
		arr = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	public void push(int value) {
		if (row_index == arr.length && column_index == arr[0].length) {
			System.out.println("Array is out of bound !!");
		} else {
			int count = 0;
			while (arr[row_index][column_index] > Integer.MIN_VALUE && count <= 10) {
				if (column_index + 1 == arr[0].length) {
					row_index++;
				}
				column_index = (column_index + 1) % arr[0].length;
			}
			arr[row_index][column_index] = value;
			if (column_index + 1 == arr[0].length) {
				row_index++;
			}
			column_index = (column_index + 1) % arr[0].length;
		}
	}

	public void insert(int row, int column, int value) {
		try {
			if (arr[row][column] > Integer.MIN_VALUE) {
				Scanner sc = new Scanner(System.in);
				System.out.println(
						"This index is already occupied , if you want to change value write Y , if you dont want to change write N : ");
				String take_permission = sc.nextLine();
				System.out.println();
				if (take_permission.contains("Yes") || take_permission.contains("yes")) {
					arr[row][column] = value;
					System.out.println("Value has successfully changed");
				}

			} else {
				arr[row][column] = value;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index is out of bound !!");
		}
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == Integer.MIN_VALUE) {
					System.out.print("NULL,");
				} else {
					System.out.print(arr[i][j] + ",");
				}
			}
			System.out.print("],");
		}
		System.out.print("]");
		System.out.println();
	}

	public void printAll() {
		System.out.println(Arrays.deepToString(arr));
	}

	public void pop() {
		if (row_index == 0 && column_index == 0) {
			System.out.println("Cant pop array is empty");
		} else {
			if (column_index - 1 == -1) {
				row_index--;
				column_index = arr[0].length - 1;
			} else {
				column_index = (column_index - 1) % arr[0].length;
			}
			arr[row_index][column_index] = Integer.MIN_VALUE;
		}
	}
}
