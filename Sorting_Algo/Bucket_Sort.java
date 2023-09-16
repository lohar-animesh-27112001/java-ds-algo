package Sorting_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//	When bucket sort: When input uniformly distributed in range
//	TC: O(nlogn)
//	SC: O(n)

public class Bucket_Sort {

//	Number of buckets = square of (number of elements in array)
//	How to choose which number(num) we want to put in which bucket:
//	num*(number of buckets) / MaxValue of array

	int[] arr;

	public Bucket_Sort(int[] arr) {
		this.arr = arr;
	}

	public int[] sort() {
		int numberOfBuckets = Math.round((int) Math.sqrt(this.arr.length)); // (int) because round can't convert long to
																			// integer
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < this.arr.length; i++) {
			if (this.arr[i] > maxValue) {
				maxValue = this.arr[i];
			}
		}
		ArrayList<Integer>[] bucketList = new ArrayList[numberOfBuckets];
		for (int i = 0; i < numberOfBuckets; i++) {
			bucketList[i] = new ArrayList<Integer>();
		}
		for (int value : this.arr) {
			int bucketNumber = (int) Math.ceil((float) (value * numberOfBuckets) / (float) maxValue);
			bucketList[bucketNumber - 1].add(value);
		}
		for (ArrayList<Integer> bucket : bucketList) {
			Collections.sort(bucket); // Time Complexity : O(nlogn)
		}
		int index = 0;
		for (ArrayList<Integer> bucket : bucketList) {
			for (int value : bucket) {
				this.arr[index] = value;
				index++;
			}
		}
		return this.arr;
	}

	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}

}
