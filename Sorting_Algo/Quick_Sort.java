package Sorting_Algo;

import java.util.Arrays;

//	Quick Sort use divide & Conquer algorithm

public class Quick_Sort {

	int arr[];

	public Quick_Sort(int arr[]) {
		this.arr = arr;
	}

	public void sort() {
		this.quick(0, this.arr.length - 1);
	}

	public int partition(int first_index, int last_index) {
		int temp = this.arr[last_index];
		int pivot = first_index;
		for (int i = first_index; i < last_index; i++) {
			if (this.arr[i] <= temp) {
				int temp_num = this.arr[pivot];
				this.arr[pivot] = this.arr[i];
				this.arr[i] = temp_num;
				pivot++;
			}
		}
		this.arr[last_index] = this.arr[pivot];
		this.arr[pivot] = temp;
		return pivot;
	}

	public void quick(int f, int l) {
		if (f < l) {
			int pivot = this.partition(f, l);

			quick(f, pivot - 1);
			quick(pivot + 1, l);
		}
	}

	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}

}
