package Sorting_Algo;

import java.util.Arrays;

public class Insertion_Sort {

	public int[] arr;

	public Insertion_Sort(int[] arr) {
		this.arr = arr;
	}

	public int[] sort() {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i], j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}

		return arr;
	}

	public void print() {
		System.out.println("Sorted array is : " + Arrays.toString(this.arr));
	}

}
