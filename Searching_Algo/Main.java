package Searching_Algo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("How many numbers you want to add in the array: ");
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 1; i <= n; i++) {
			System.out.print(i + ") ");
			arr[i - 1] = sc.nextInt();
			System.out.println();
		}

		System.out.println("which value you want to find: ");
		int value = sc.nextInt();

//		LINEAR SEARCH
		System.out.println("linear searching....");
		Linear_Search ls = new Linear_Search(arr);
		ls.search(value);

//		BINARY SEARCH
		System.out.println("binary searching....");
		Binary_Search bs = new Binary_Search(arr);
		bs.search(value);
	}

}
