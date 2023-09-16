package udemy;

import java.util.*;

public class Array_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList firstArr = new ArrayList();
		ArrayList<String> name = new ArrayList<String>(Arrays.asList("Animesh", "lohar"));
		System.out.println(firstArr.size());
		System.out.println(name);
		System.out.println(name.size());

		// Insertion in ArrayList
		firstArr.add(30);
		firstArr.add("Animesh");
		firstArr.add(20);
		firstArr.add('A');
		System.out.println(firstArr);
		firstArr.add(2, 700);
		System.out.println(firstArr);
		System.out.println(firstArr.get(2));

		ArrayList<String> strList = new ArrayList<String>(Arrays.asList("A", "N", "I", "M", "E", "S", "H"));
		for (String letter : strList) {
			System.out.print(letter);
		}
		System.out.println();

		// Searching element in ArrayList
		System.out.println(firstArr.indexOf(20)); // O(n)

		// Remove element in ArrayList
		firstArr.remove(30); // O(n)

	}

}
