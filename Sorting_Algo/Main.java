package Sorting_Algo;

import java.util.Arrays;
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
//		sc.close() ;

//		BUBBLE SORT
//		Bubble_Sort bs = new Bubble_Sort(arr) ;
//		bs.sort() ;
//		bs.print() ;

//		SELECTION SORT
//		Selection_Sort ss = new Selection_Sort(arr) ;
//		ss.sort() ;
//		ss.print() ;

//		SELECTION SORT
//		Insertion_Sort is = new Insertion_Sort(arr) ;
//		is.sort() ;
//		is.print() ;

//		BUCKET SORT
//		Bucket_Sort bs = new Bucket_Sort(arr) ;
//		bs.sort() ;
//		bs.print() ;

//		MERGE SORT
//		Merge_Sort ms = new Merge_Sort(arr) ;
//		ms.sort() ;
//		ms.print() ;

//		QUICK SORT
		Quick_Sort qs = new Quick_Sort(arr);
		qs.sort();
		qs.print();

		System.out.println(Arrays.toString(arr));

	}

}
