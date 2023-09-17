package dsAlgo;

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueCircularDoublyLinkedList firstQueue = new QueueCircularDoublyLinkedList();
		firstQueue.createQueue(10);
		firstQueue.Enqueue(21);
		firstQueue.Enqueue(100);
		firstQueue.Enqueue(201);
		firstQueue.printQueue();
		firstQueue.Dequeue();
		firstQueue.Dequeue();
		firstQueue.printQueue();
		firstQueue.Peek();
		firstQueue.isEmpty();
		firstQueue.deleteQueue();
		firstQueue.isEmpty();

	}

}

class QueueCircularDoublyLinkedList extends CircularDoublyLinkedList {

	// Creating Queue
	public void createQueue(int value) {
		this.create_CircularDoublyLinkedList(value);
		System.out.println("Queue using Circular doubly linked list created successfully !!!");
	}

	// Print Queue
	public void printQueue() {
		this.printAll();
	}

	// Enqueue
	public void Enqueue(int value) {
		this.push(value);
	}

	// Dequeue
	public void Dequeue() {
		this.delete();
	}

	// Peek function use
	public void Peek() {
		System.out.println(this.head.value);
	}

	// isEmpty function
	public void isEmpty() {
		if (this.head == null) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// deleteQueue function
	public void deleteQueue() {
		this.delete_CircularDoublyLinkedList();
		System.out.println("Queue deleted successfully !!!");
	}

}
