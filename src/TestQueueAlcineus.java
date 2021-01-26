/*
 Kenneth Alcineus
 This is a program that prints a queue using a custom Queue class.
 The purpose of the project is to learn how to substitute imported Java classes and create entirely custom and editable classes that may fulfill other purposes.
 As with the last two projects, one class is defined with constructors and methods to be used as a blueprint to create objects in another class.
*/
public class TestQueueAlcineus {

	public static void main(String[] args) {
		//Stage 1.1
		QueueAlcineus queue = new QueueAlcineus(8);
		//Stage 1.2
		for (int i = 0; i < 20; i++) {
			queue.enqueue(i + 1);
		}
		//Stage 1.3
		System.out.println("Here are the initial queue contents: (Queue Size = " + queue.getSize() + ")");
		for (int i = 0; i < queue.getSize(); i++) {
			System.out.print(queue.getElement(i) + " ");
		}
		System.out.println();
		//Stage 2
		while (queue.empty() == false) {
			for (int i = 0; i < 5; i++) {
				queue.dequeue();
			}
			//Stage 3
			if (queue.getSize() != 0) {
				System.out.println("Here are the new queue contents after removing five elements: (Queue Size = " + queue.getSize() + ")");
				for (int i = 0; i < queue.getSize(); i++) {
					System.out.print(queue.getElement(i) + " ");
				}
				System.out.println();
			}
		}
	}

}

class QueueAlcineus {
	private int[] elements;
	private int size = 0;
	/*
	 This is a constructor that initializes a default queue.
	 It allows a new queue object without parameters to be created.
	*/
	public QueueAlcineus() {
		elements = new int[size];
	}
	/*
	 This is a constructor that initializes a queue with a specified size.
	 It allows a new queue object with a parameter to be created.
	*/
	public QueueAlcineus(int size) {
		elements = new int[size];
	}
	/*
	 This is a method that uses a temporary array to add values to the queue, or the elements array.
	 If the size becomes greater than the length of the elements array, then the temporary array with twice the length of the elements array is created and used.
	*/
	public void enqueue(int v) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp.clone();
		}
		elements[size++] = v;
	}
	/*
	 This is a method that uses a temporary array to remove values from the queue, or the elements array.
	 This method creates a temporary variable along with a temporary array to return the first value of the queue before its removal.
	*/
	public int dequeue() {
		int first = elements[0];
		int[] temp = new int[size - 1];
		System.arraycopy(elements, 1, temp, 0, size - 1);
		elements = temp.clone();
		size--;
		return first;
	}
	/*
	 This is a method that returns a true or false value based on the size value
	 If the size of a queue is zero, then this method returns true. Otherwise, this method returns false.
	*/
	public boolean empty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;	
		}
	}
	/*
	 This type of method is known as an accessor, also known as a getter.
	 Using this getter, the size value of a queue object is returned to wherever the method is called from.
	*/
	public int getSize() {
		return size;
	}
	/*
	 This type of method is similar to an accessor, but it requires a parameter in order to access an instance of an array.
	 Using this method, the value found given the index of the elements array of a queue object is returned to wherever the method is called from.
	*/
	public int getElement(int i) {
		return elements[i];
	}
}