package udemy;

public class Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList firstSLL = new SingleLinkedList();
		System.out.println(firstSLL.createSinglyLinkedList(100));
		System.out.println(firstSLL.head.value);

		// insert node
		firstSLL.insertNode(20);
		firstSLL.insertNode(30);
		firstSLL.insertEndNode(200);

		// print all node values of linked list
		System.out.println("Here printed all the value of linked list :");
		firstSLL.printAll();
		System.out.println();
		System.out.println("Size of linked list : " + firstSLL.size);

		// search node in linked list
		System.out.println(firstSLL.findValue(200));
		System.out.println(firstSLL.findValue(2000));

		// Delete node
		firstSLL.deleteValue(200);
		firstSLL.deleteValue(20);
		firstSLL.printAll();
		firstSLL.deleteValue(30);
		firstSLL.deleteValue(100);
		firstSLL.printAll();

		firstSLL.insertNode(1000);
		firstSLL.insertNode(3000);
		firstSLL.insertEndNode(2000);
		firstSLL.printAll();
		firstSLL.deleteEntireLinkedList();
		firstSLL.printAll();

	}

}

class Node {
	public int value;
	public Node next; // Type to next reference is node , Node is pointer actually
}

class SingleLinkedList {
	public Node head;
	public int size;

	public Node createSinglyLinkedList(int nodeValue) {
//		head = new Node() ;
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		size = 1;

		return head;
	}

	public Node insertNode(int nodeValue) {
		if (head == null) {
			createSinglyLinkedList(nodeValue);
			return head;
		} else {
			Node node = new Node();
			node.value = nodeValue;
			node.next = head;
			head = node;
			size++;

			return node;
		}
	}

	public Node insertEndNode(int nodeValue) {
		if (head == null) {
			createSinglyLinkedList(nodeValue);
			return head;
		}
		Node tempNode = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		Node newNode = new Node();
		newNode.value = nodeValue;
		tempNode.next = newNode;
		size++;
		tempNode = null;
		return newNode;

	}

	public void printAll() {
		Node newNode = head;
		System.out.print("[ ");
		while (newNode != null) {
			System.out.print(newNode.value + " -> ");
			newNode = newNode.next;
		}
		System.out.print("null ]");
		System.out.println();
		newNode = null;
	}

	public boolean findValue(int nodeValue) {
		if (head != null) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("value founded at index : " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("node not found");
		return false;
	}

	public Boolean deleteValue(int nodeValue) {
		if (head != null) {

			if (head.value == nodeValue && size > 1) {
				head = head.next;
				System.out.println("header node deleted successfully !!!");
				size--;
				return true;
			} else if (head.value == nodeValue) {
				head = null;
				System.out.println("header node deleted successfully !!!");
				size--;
				return true;
			}

			Node tempNode = head;
			Node tempPrevNode = head;

			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue && size > 2) {
					tempPrevNode.next = tempNode.next;
					System.out.println("node " + tempNode.value + " deleted successfully !!!");
					tempNode = null;
					size--;
					return true;
				} else if (tempNode.value == nodeValue && size == 2 && head.value != nodeValue) {
					tempPrevNode.next = null;
					size--;
					System.out.println("node " + tempNode.value + " deleted successfully !!!");
					tempNode = null;
					return true;
				}

				tempPrevNode = tempNode;
				tempNode = tempNode.next;
			}
		}
		System.out.println("node not found");
		return false;
	}

	public void deleteEntireLinkedList() {
		head = null;
		System.out.println("Entire Linked List deleted successfully !!!");
	}

}