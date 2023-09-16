package Sorting_Algo;

import java.util.Arrays;

public class Merge_Sort {

	int arr[];

	public Merge_Sort(int arr[]) {
		this.arr = arr;
	}

	public void sort() {
		this.divide(0, arr.length - 1);
	}

	public void divide(int start, int last) {
		if (start < last) {
			int middle = (start + last) / 2;

			divide(start, middle);
			divide(middle + 1, last);

			this.merge(start, middle, last);
		}
	}

	public void merge(int start, int middle, int last) {
		int n1 = middle - start + 1;
		int n2 = last - middle;
		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = this.arr[start + i];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = this.arr[middle + 1 + i];
		}

		int i = 0, j = 0, k = start;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				this.arr[k] = left[i];
				k++;
				i++;
			} else {
				this.arr[k] = right[j];
				k++;
				j++;
			}
		}
		while (i < n1) {
			this.arr[k] = left[i];
			k++;
			i++;
		}
		while (j < n2) {
			this.arr[k] = right[j];
			k++;
			j++;
		}
	}

	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}
}
