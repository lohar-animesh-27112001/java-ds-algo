package udemy;

public class StackUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackCircularDoublyLinkedList firstStack = new StackCircularDoublyLinkedList();
		firstStack.createStack(10);
		firstStack.Push(15);
		firstStack.Push(21);
		firstStack.printStack();
		firstStack.Pop();
		firstStack.printStack();
		firstStack.Peek();
		firstStack.isEmpty();
		firstStack.deleteStack();
		firstStack.isEmpty();
	}

}

class StackCircularDoublyLinkedList extends CircularDoublyLinkedList {

	// Creating stack
	public void createStack(int value) {
		this.create_CircularDoublyLinkedList(value);
		System.out.println("Stack using Circular doubly linked list created successfully !!!");
	}

	// Print stack
	public void printStack() {
		this.printAll();
	}

	// Push function
	public void Push(int value) {
		this.push(value);
	}

	// Pop function
	public void Pop() {
		this.pop();
	}

	// Peek function use
	public void Peek() {
		System.out.println(this.tail.value);
	}

	// isEmpty function
	public void isEmpty() {
		if (this.head == null) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// deleteStack function
	public void deleteStack() {
		this.delete_CircularDoublyLinkedList();
		System.out.println("Stack deleted successfully !!!");
	}

}