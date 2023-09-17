package dsAlgo;

public class QueueUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueArray firstArrQueue = new QueueArray(10);
		firstArrQueue.Enqueue(100);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(11);
		firstArrQueue.Enqueue(1014);
		firstArrQueue.isFull();
		firstArrQueue.printAll();
		firstArrQueue.Dequeue();
		firstArrQueue.Dequeue();
		firstArrQueue.Dequeue();
		firstArrQueue.printAll();
		firstArrQueue.Peek();
		firstArrQueue.isEmpty();
		firstArrQueue.isFull();
		firstArrQueue.deleteQueue();
		firstArrQueue.isEmpty();
		firstArrQueue.isFull();

	}

}

class QueueArray extends SingleDMArray {

	// Creating Queue
	public QueueArray(int sizeOfArr) {
		super(sizeOfArr);
	}

	// Print Queue
	public void printQueue() {
		this.printAll();
		;
	}

	// Enqueue
	public void Enqueue(int value) {
		this.push(value);
	}

	// Dequeue
	public void Dequeue() {
		if (this.isEmpty()) {

		} else {
			this.delete(0);
			for (int i = 1; i < this.index; i++) {
				this.arr[i - 1] = this.arr[i];
			}
			this.arr[this.index - 1] = Integer.MIN_VALUE;
			this.index--;
		}

	}

	// Peek function use
	public void Peek() {
		System.out.println(this.arr[0]);
	}

	// isEmpty function
	public Boolean isEmpty() {
		if (this.arr[0] == Integer.MIN_VALUE) {
			System.out.println(true);
			return true;
		} else {
			System.out.println(false);
			return false;
		}
	}

	// isFull function
	public void isFull() {
		if (this.index == this.arr.length) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// deleteQueue function
	public void deleteQueue() {
		for (int i = 0; i < this.arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
		this.index = 0;
		System.out.println("Stack deleted successfully !!!");
	}

}
