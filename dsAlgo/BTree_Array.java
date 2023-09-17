package dsAlgo;

import java.util.ArrayList;
import java.util.Scanner;

public class BTree_Array {

	public ArrayList<String> arr;
	public int lastUsedIndex;

	public BTree_Array() {
		arr = new ArrayList<>();
		lastUsedIndex = 0;
		arr.add(null);
		System.out.println("Blank binary tree of array " + "is created !!!");
	}

	public void deleteBT() {
		try {
			this.arr = null;
			System.out.println("The tree has been deleted !!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int addValue(int value) {
		System.out.println(value + " pushed at index " + lastUsedIndex);
		lastUsedIndex++;
		this.arr.add(lastUsedIndex, Integer.toString(value));
		return value;
	}

	public String addValue(String value) {
		System.out.println(value + " pushed at index " + lastUsedIndex);
		lastUsedIndex++;
		this.arr.add(lastUsedIndex, value);
		return value;
	}

	public void leveorderPrint() {
		System.out.println(this.arr);
	}

	public void traverse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("In which order you want to traverse," + "\n for inorder in," + "\n for preorder pre,"
				+ "\n for postorder post" + ",\n for exit write exit ");
		String temp = sc.next();

		if (temp.contains("in")) {
			System.out.println("Inorder traversal is going.....");
			this.inorder(1);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("pre")) {
			System.out.println("Preorder traversal is going.....");
			this.preorder(1);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("post")) {
			System.out.println("Postorder traversal is going.....");
			this.postorder(1);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("exit")) {
			System.out.println();
			System.out.println("....Exit successfully");
		} else {
			System.out.println("Invalid");
			System.out.println();
			traverse();
		}
	}

	public void preorder(int root) {
		if (root <= lastUsedIndex) {
			System.out.print(this.arr.get(root) + " ");
			preorder(2 * root);
			preorder((2 * root) + 1);
		}
	}

	public void inorder(int root) {
		if (root <= lastUsedIndex) {
			inorder(2 * root);
			System.out.print(this.arr.get(root) + " ");
			inorder((2 * root) + 1);
		}
	}

	public void postorder(int root) {
		if (root <= lastUsedIndex) {
			postorder(2 * root);
			postorder((2 * root) + 1);
			System.out.print(this.arr.get(root) + " ");
		}
	}

	public int bfs(int value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (Integer.toString(value) == this.arr.get(i)) {
				System.out.println("index is: " + i);
				return i;
			}
		}
		System.out.println("This element is not present in the tree");
		return -1;
	}

	public int bfs(String value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (value == this.arr.get(i)) {
				System.out.println("index is: " + i);
				return i;
			}
		}
		System.out.println("This element is not present in the tree");
		return -1;
	}

}
