package udemy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AVL_LinkedList {

	public AVL_Node root;

	public AVL_LinkedList() {
		// TODO Auto-generated constructor stub
		root = null;
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

	public void preorder(AVL_Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}

	public void inorder(AVL_Node root) {
		if (root != null) {
			inorder(root.leftChild);
			System.out.print(root.value + " ");
			inorder(root.rightChild);
		}
	}

	public void postorder(AVL_Node root) {
		if (root != null) {
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.print(root.value + " ");
		}
	}

	public void levelorder(AVL_Node root) {
		Queue<AVL_Node> queue = new LinkedList<AVL_Node>();
		queue.add(root);
		while (queue.isEmpty()) {
			AVL_Node tempNode = queue.remove();
			System.out.println(tempNode.value);
			if (tempNode.leftChild != null) {
				queue.add(tempNode.leftChild);
			}
			if (tempNode.rightChild != null) {
				queue.add(tempNode.rightChild);
			}
		}
	}

	public int getHeight(AVL_Node node) {
		if (node == null) {
			return 0;
		}
		int lc = getHeight(node.leftChild), hc = getHeight(node.rightChild);
		if (lc > hc) {
			node.height = 1 + lc;
		} else {
			node.height = 1 + hc;
		}
		return node.height;
	}

	public int getBalanced(AVL_Node node) {
		if (node == null) {
			return 0;
		}
		int lc = this.getHeight(node.leftChild), hc = this.getHeight(node.rightChild);
		return lc - hc;
	}

	public AVL_Node leftRotate(AVL_Node node) {
		AVL_Node nodeRight = node.rightChild;
		AVL_Node nodeRightLeft = nodeRight.leftChild;

		nodeRight.leftChild = node;
		node.rightChild = nodeRightLeft;

		return nodeRight;
	}

	public AVL_Node rightRotate(AVL_Node node) {
		AVL_Node nodeLeft = node.leftChild;
		AVL_Node nodeLeftRight = nodeLeft.rightChild;

		nodeLeft.rightChild = node;
		node.leftChild = nodeLeftRight;

		return nodeLeft;
	}

	public AVL_Node insert(int value) {
		System.out.println("....inserting !!");
		AVL_Node tempNode = this.insert(this.root, value);
		if (tempNode == null) {
			System.out.println("already inserted !!");
		} else {
			System.out.println("insert successfully.... !!");
		}
		return tempNode;
	}

	public AVL_Node insert(AVL_Node node, int value) {
		if (node == null) {
			node = new AVL_Node(value);
			return node;
		}
		if (node.value > value) {
			node.leftChild = insert(node.leftChild, value);
		} else if (node.value < value) {
			node.rightChild = insert(node.rightChild, value);
		} else {
			return null;
		}
		int height = this.getHeight(node);
		int balance = this.getBalanced(node);

		// Left-Left : Right-Rotate
		if ((balance > 1) && ((node.leftChild.height - node.rightChild.height) > 0)) {
			return this.rightRotate(node);
		} // Right-Right : Left-Rotate
		else if ((balance < -1) && ((node.leftChild.height - node.rightChild.height) < 0)) {
			return this.leftRotate(node);
		} // Right-Left : Left-Right-Rotate
		else if ((balance > 1) && ((node.leftChild.height - node.rightChild.height) < 0)) {
			node.leftChild = this.leftRotate(node.leftChild);
			return this.rightRotate(node);
		}

		return node;
	}

}
