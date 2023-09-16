package udemy;

import java.util.ArrayList;

public class Tree_Arraylist {

	public String value;
	public ArrayList<Tree_Arraylist> child = new ArrayList<Tree_Arraylist>();

	public Tree_Arraylist() {
	}

	public Tree_Arraylist(String value) {
		this.createRoot(value);
	}

	public void createRoot(String value) {
		this.value = value;
	}

	public void addChild(Tree_Arraylist node) {
		this.child.add(node);
	}

	public void print(int level) {
		this.print(level, 2);
	}

	public void print(int level, int loop) {
		if (this.value != null && level >= 0) {
			System.out.print(this.value + "\n");
			for (Tree_Arraylist n : this.child) {
				for (int i = 0; i < loop; i++) {
					System.out.print(" ");
				}
				n.print(level - 1, loop + 2);
			}
		}
	}

}