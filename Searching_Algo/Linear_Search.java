package Searching_Algo;

public class Linear_Search {

	int arr[];

	public Linear_Search(int arr[]) {
		this.arr = arr;
	}

	public int search(int value) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.println("Count : " + count);
				System.out.println("The element is present at index: " + i);
				return i;
			}
			count++;
		}
		System.out.println("Count : " + count);
		System.out.println("The element is not present in the array");
		return -1;
	}

	public Linear_Search() {
	}

	public int search(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				System.out.println("The element is present at index: " + i);
				return i;
			}
		}
		System.out.println("The element is not present in the array");
		return -1;
	}

}
