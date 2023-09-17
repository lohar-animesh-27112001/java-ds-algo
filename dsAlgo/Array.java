import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray;
		intArray = new int[3];
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
		}
		System.out.println();
		System.out.println(Arrays.toString(intArray));
		String[] sArray = { "a", "b", "c" };
		System.out.println(Arrays.toString(sArray));

		// Insertion in Array
		SingleDMArray sda = new SingleDMArray(10);
		sda.push(201);
		sda.push(4);
		sda.push(120);
		sda.push(-90);
		sda.push(50);
		sda.push(60);
		sda.insert(6, 70);
		sda.push(100);
		sda.print();
		sda.printAll();

		// Accessing an array element
		System.out.println("The first element of the array is: " + sda.arr[0]);

		// Searching value in the array
		sda.search(60);

		// Deleting value in array
		sda.delete(-1);
		sda.delete(2);
		sda.delete_value(100);
		sda.printAll();

		// Reverse
		SingleDMArray my_Arr = new SingleDMArray(5);
		my_Arr.push(1);
		my_Arr.push(2);
		my_Arr.push(3);
		my_Arr.push(4);
		my_Arr.push(5);
		my_Arr.print();
		my_Arr.reverse();
	}

}

class SingleDMArray {
	int[] arr;
	int index = 0;
	int sizeOfArr = 0;

	public SingleDMArray(int sizeOfArr) {
		this.sizeOfArr = sizeOfArr;
		arr = new int[sizeOfArr];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}

	public void push(int value) {
		int count = 0;
		while (arr[index % arr.length] > Integer.MIN_VALUE && count <= sizeOfArr) {
			index++;
			count++;
		}
		if (index == arr.length || count == 10) {
			System.out.println("Array is out of bound !!");
		} else {
			arr[index] = value;
			index++;
		}
	}

	public void insert(int ind, int value) {
		try {
			if (arr[ind] > Integer.MIN_VALUE) {
				System.out.println("This index is already occupied");
			} else {
				arr[ind] = value;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index is out of bound !!");
		}
	}

	public void print() {
		for (int i = 0; i < index; i++) {
			System.out.println(i + ") " + arr[i]);
		}
	}

	public void printAll() {
		System.out.println(Arrays.toString(arr));
	}

	public void search(int value) {
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.println("The value " + value + " is in the index of : " + i);
				check = true;
			}
		}
		if (check == false) {
			System.out.println("The value is not belong to the array !!");
		}
	}

	public void pop() {
		if (index == 0) {
			System.out.println("Array is empty");
		} else {
			while (arr[index] > Integer.MIN_VALUE) {
				index = index + 1;
			}
			System.out.println(arr[this.index - 1] + " is pop out !! ");
			arr[index - 1] = Integer.MIN_VALUE;
			index--;
		}
	}

	public void delete(int ind) {
		if (ind < 0 || ind >= arr.length) {
			System.out.println("Invalid index");
		} else if (arr[ind] == Integer.MIN_VALUE) {
			System.out.println("This index is not storing value now");
		} else {
			arr[ind] = Integer.MIN_VALUE;
			System.out.println("index " + ind + " value deleted successfully");
		}

	}

	public void swap(int ind_1, int ind_2) {
		int tempValue = arr[ind_1 % (sizeOfArr - 1)];
		arr[ind_1 % (sizeOfArr - 1)] = arr[ind_2 % (sizeOfArr - 1)];
		arr[ind_2 % (sizeOfArr - 1)] = tempValue;
	}

	public void delete_value(int value) {
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				arr[i] = Integer.MIN_VALUE;
				System.out.println(value + " value deleted successfully");
				check = true;
			}
		}
		if (check == false) {
			System.out.println("The value is not belong to the array !!");
		}
	}

	public void reverse() {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
