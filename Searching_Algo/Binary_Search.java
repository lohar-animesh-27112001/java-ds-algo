package Searching_Algo;

public class Binary_Search {

	int arr[];

	public Binary_Search(int arr[]) {
		this.arr = arr;
	}

	public int search(int value) {
		int mid = arr.length / 2;
		int max = arr.length - 1;
		int min = 0;
		if (arr[0] == value) {
			System.out.println("The element is present at index: " + 0);
			return 0;
		} else if (arr[arr.length - 1] == value) {
			System.out.println("The element is present at index: " + (arr.length - 1));
			return arr.length - 1;
		}
		int temp = 0;
		int count = 0;
		while (mid < max && mid > min) {
			if (arr[mid] == value) {
				System.out.println("Count : " + count);
				System.out.println("The element is present at index: " + mid);
				return mid;
			} else if (arr[min] == value) {
				System.out.println("The element is present at index: " + min);
				System.out.println("Count : " + count);
				return min;
			} else if (arr[max] == value) {
				System.out.println("The element is present at index: " + max);
				System.out.println("Count : " + count);
				return max;
			} else if (arr[mid] > value) {
				temp = mid;
				mid = (min + mid) / 2;
				max = temp;
			} else if (arr[mid] < value) {
				temp = mid;
				mid = (max + mid) / 2;
				min = temp;
			}
			count++;
		}
		System.out.println("Count : " + count);
		System.out.println("The element is not present in the array");
		return -1;
	}

	public Binary_Search() {
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
