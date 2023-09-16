package Sorting_Algo;

import java.util.Arrays;

public class Selection_Sort {

	public int[] arr;

	public Selection_Sort(int[] arr) {
		this.arr = arr;
	}

	public int[] sort() {
		for (int i = 0; i < this.arr.length; i++) {
			int min_index = i;
			for (int j = i + 1; j < this.arr.length; j++) {
				if (this.arr[j] < this.arr[j - 1]) {
					min_index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}

		return arr;

	}

	public void print() {
		System.out.println("Sorted array is : " + Arrays.toString(this.arr));
	}
}
