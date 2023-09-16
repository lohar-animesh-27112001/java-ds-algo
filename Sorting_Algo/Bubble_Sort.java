package Sorting_Algo;

import java.util.Arrays;

public class Bubble_Sort {

	public int[] arr;

	public Bubble_Sort(int[] arr) {
		this.arr = arr;
	}

	public int[] sort() {
		for (int i = 0; i < this.arr.length; i++) {
			Boolean bool = false;
			for (int j = 1; j < this.arr.length - i; j++) {
				if (this.arr[j] < this.arr[j - 1]) {
					int temp = this.arr[j];
					this.arr[j] = this.arr[j - 1];
					this.arr[j - 1] = temp;
					bool = true;
				}
			}
			if (bool = false) {
				break;
			}
		}

		return arr;

	}

	public void print() {
		System.out.println("Sorted array is : " + Arrays.toString(this.arr));
	}

}
