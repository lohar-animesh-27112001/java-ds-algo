package udemy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_LinkedList {

	public BST_Node root;
	public int height;

	public BST_LinkedList() {
		this.root = null;
	}

	public BST_Node insert(int value) {
		BST_Node newNode = new BST_Node();
		newNode.value = value;
		if (this.root == null) {
			this.root = newNode;
			return newNode;
		}
		BST_Node tempNode = this.root;
		BST_Node rootNode = new BST_Node();
		while (tempNode != null) {
			rootNode = tempNode;
			if (tempNode.value == value) {
				System.out.println("This value already" + " inserted !!");
				return tempNode;
			} else if (tempNode.value < value) {
				tempNode = tempNode.rightChild;
			} else {
				tempNode = tempNode.leftChild;
			}
		}
		if (rootNode.value < value) {
			rootNode.rightChild = newNode;
		} else {
			rootNode.leftChild = newNode;
		}

		return newNode;
	}

	public void deleteBST() {
		System.out.println(".....deleting binary tree");
		this.root = null;
		System.out.println("deleted successfully.....");
	}

	public void traverse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("In which order you want to traverse," + "\n for inorder in," + "\n for preorder pre,"
				+ "\n for postorder post," + "\n for levelorder level" + ",\n for exit write exit ");
		String temp = sc.next();

		if (temp.contains("in")) {
			System.out.println("Inorder traversal is going.....");
			this.inorder(this.root);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("pre")) {
			System.out.println("Preorder traversal is going.....");
			this.preorder(this.root);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("post")) {
			System.out.println("Postorder traversal is going.....");
			this.postorder(this.root);
			System.out.println();
			System.out.println();
			traverse();
		} else if (temp.contains("level")) {
			System.out.println("Levelorder traversal is going.....");
			this.levelorder(root);
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

	public void preorder(BST_Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}

	public void inorder(BST_Node root) {
		if (root != null) {
			inorder(root.leftChild);
			System.out.print(root.value + " ");
			inorder(root.rightChild);
		}
	}

	public void postorder(BST_Node root) {
		if (root != null) {
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.print(root.value + " ");
		}
	}

	public void levelorder(BST_Node root) {
		Queue<BST_Node> queue = new LinkedList<BST_Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BST_Node currentNode = queue.remove();
			System.out.println(currentNode.value);
			if (currentNode.leftChild != null) {
				queue.add(currentNode.leftChild);
			}
			if (currentNode.rightChild != null) {
				queue.add(currentNode.rightChild);
			}
		}
	}

	public int search(int value) {
		BST_Node rootNode = this.root;
		System.out.println(".....searching for the node");
		while (rootNode != null) {
			if (rootNode.value == value) {
				System.out.println("Node has been found");
				return value;
			}
			if (rootNode.value < value) {
				rootNode = rootNode.rightChild;
			} else {
				rootNode = rootNode.leftChild;
			}
		}
		System.out.println("Node has not found");
		return -1;
	}

	public void delete(int value) {
		System.out.println(".....deleting the node");
		this.delete(value, this.root);
		System.out.println("deleted successfully.....");
	}

	public BST_Node delete(int value, BST_Node root) {
		if (root == null) {
			return root;
		}
		if (root.value > value) {
			root.leftChild = delete(value, root.leftChild);
			return root;
		} else if (root.value < value) {
			root.rightChild = delete(value, root.rightChild);
			return root;
		}
		if (root.leftChild == null) {
			BST_Node temp = root.rightChild;
			return temp;
		} else if (root.rightChild == null) {
			BST_Node temp = root.leftChild;
			return temp;
		} else {
			BST_Node succRootNode = root;
			BST_Node successor = root.rightChild;
			while (successor.leftChild != null) {
				succRootNode = successor;
				successor = successor.leftChild;
			}
			root.value = successor.value;
			if (succRootNode != root) {
				succRootNode.leftChild = successor.leftChild;
			} else {
				succRootNode.rightChild = successor.rightChild;
			}
			return root;
		}
	}

}