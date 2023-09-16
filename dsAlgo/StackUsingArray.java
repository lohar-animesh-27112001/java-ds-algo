package udemy;

public class StackUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray firstStackArr = new StackArray(10);
		firstStackArr.Push(11);
		firstStackArr.Push(12);
		firstStackArr.Push(110);
		firstStackArr.Push(102);
		firstStackArr.printAll();
		firstStackArr.Peek();
		firstStackArr.Pop();
		firstStackArr.Pop();
		firstStackArr.printAll();
		firstStackArr.Peek();
		firstStackArr.isEmpty();
		firstStackArr.isFull();
		firstStackArr.deleteStack();
		firstStackArr.isEmpty();
		firstStackArr.isFull();

	}

}

class StackArray extends SingleDMArray {

	public StackArray(int sizeOfArr) {
		super(sizeOfArr);
		// TODO Auto-generated constructor stub
	}

	// Push
	public void Push(int value) {
		this.push(value);
	}

	// Pop
	public void Pop() {
		this.pop();
	}

	// Peek
	public void Peek() {
		System.out.println(this.arr[this.index - 1]);
	}

	// isEmpty
	public void isEmpty() {
		if (this.index == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// isFull
	public void isFull() {
		if (this.index == this.sizeOfArr) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// deleteStack
	public void deleteStack() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
		this.index = 0;
		System.out.println("Stack deleted successfully !!!");
	}

}
