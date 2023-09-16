package udemy;

public class Circular_Doubly_Linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularDoublyLinkedList firstCDLL = new CircularDoublyLinkedList();
		firstCDLL.create_CircularDoublyLinkedList(100);
		firstCDLL.printAll();

		// add from head
		firstCDLL.add(51);
		firstCDLL.add(94);
		firstCDLL.add(76);
		firstCDLL.add(89);

		// push in tail
		firstCDLL.push(101);
		firstCDLL.push(300);

		// Print whole linked list
		firstCDLL.printAll();

		// Delete
		firstCDLL.delete();
		firstCDLL.delete();
		firstCDLL.printAll();

		// Pop
		firstCDLL.pop();
		firstCDLL.pop();
		firstCDLL.printAll();
	}

}

class DoublyNode {
	public int value;
	public DoublyNode next;
	public DoublyNode prev;
}

class CircularDoublyLinkedList {
	public int size = 0;
	DoublyNode head;
	DoublyNode tail;

	// Create CircularDoublyLinkedList
	public void create_CircularDoublyLinkedList(int nodeValue) {
		head = new DoublyNode();
		tail = new DoublyNode();
		head.value = nodeValue;
		tail = head;
		head.next = null;
		head.prev = tail;
		tail.prev = head;
		tail.next = head;
		size++;
		System.out.println("Circular doubly linked list created successfully !!!");

	}

	// Push in Linked List by tail
	public DoublyNode push(int nodeValue) {
		if (head == null) {
			create_CircularDoublyLinkedList(nodeValue);
			return head;
		}
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		DoublyNode tempNode = new DoublyNode();
		if (size == 1) {
			tail = newNode;
			head.next = tail;
			head.prev = tail;
			tail.prev = head;
			tail.next = head;
			size++;
			return newNode;
		} else {
			tempNode = tail;
			tail = newNode;
			tempNode.next = tail;
			tail.prev = tempNode;
			tail.next = head;
			head.prev = tail;
			size++;
			return newNode;
		}
	}

	// Push in Linked List by head
	public DoublyNode add(int nodeValue) {
		if (head == null) {
			create_CircularDoublyLinkedList(nodeValue);
			return head;
		}
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		DoublyNode tempNode = new DoublyNode();
		if (size == 1) {
			tempNode = head;
			head = newNode;
			tail = tempNode;
			head.next = tail;
			tail.prev = head;
			tail.next = head;
			head.prev = tail;
			size++;
			return newNode;
		} else {
			tempNode = head;
			head = newNode;
			head.next = tempNode;
			tempNode.prev = head;
			head.prev = tail;
			size++;
			return newNode;
		}
	}

	// Print Linked List
	public void printAll() {
		if (head == null) {
			System.out.println("Linked list is empty !!!");
		} else {
			DoublyNode tempNode = head;
			System.out.print("[ head -> " + tempNode.value);
			for (int i = 1; i < size; i++) {
				tempNode = tempNode.next;
				System.out.print(" <- " + tempNode.value + " ->");
			}
			System.out.print(" (tail) -> head ]");
			System.out.println();
//			System.out.println("HEAD(" + head +") : " + head.value + " , TAIL(" + tail +") : " + tail.value) ;
//			System.out.println("HEAD.previous position : " + head.prev + " , TAIL.next position : " + tail.next) ;

		}
	}

	// Delete in Linked List
	public DoublyNode delete() {
		DoublyNode tempNode = head.next;
		head = null;
		head = tempNode;
		tail.next = head;
		size--;
		return head;
	}

	// Pop in Linked List
	public DoublyNode pop() {
		DoublyNode tempNode = tail.prev;
		tail = null;
		tail = tempNode;
		tail.next = head;
		head.prev = tail;
		size--;
		return head;
	}

	// Delete the Circular doubly linked list
	public void delete_CircularDoublyLinkedList() {
		DoublyNode tempNode = head.next;
		for (int i = 0; i < size; i++) {
			tempNode.prev = null;
			tempNode = tempNode.next;
		}
		head = null;
		tail = null;
	}

}