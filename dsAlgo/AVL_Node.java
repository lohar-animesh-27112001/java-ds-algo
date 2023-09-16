package udemy;

public class AVL_Node {
	public int value;
	public int height;
	public AVL_Node leftChild;
	public AVL_Node rightChild;

	public AVL_Node() {
		this.height = 1;
	}

	public AVL_Node(int value) {
		this.value = value;
		this.height = 1;
	}
}
