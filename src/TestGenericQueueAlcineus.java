/*
 Kenneth Alcineus
 This is a program that prints a generic queue using the Queue class from the previous project but applying array lists instead of arrays.
 The purpose of the project is to learn how to work with the ArrayList class, File class, and generic types to create more effective ways to gather data dynamically.
 As with the last three projects, one class is defined with constructors and methods to be used as a blueprint to create objects in another class.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestGenericQueueAlcineus {

	public static void main(String[] args) {
		Scanner data1 = null;
		Scanner data2 = null;
		try {
			data1 = new Scanner(new File("src/people.dat"));
			data2 = new Scanner(new File("src/numbers.dat"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Required files are not found! Please make sure 'people.dat' and 'numbers.dat' are in the 'src' folder.");
			System.exit(0);
		}
		GenericQueueAlcineus<String> queue1 = new GenericQueueAlcineus<String>();
		while (data1.hasNextLine()) {
			queue1.enqueue(data1.nextLine());
		}
		GenericQueueAlcineus<Integer> queue2 = new GenericQueueAlcineus<Integer>();
		while (data2.hasNextLine()) {
			queue2.enqueue(data2.nextInt());
		}
		data1.close();
		data2.close();
		
		System.out.println();
		System.out.println("Initial queue 1 contents:");
		queue1.printQueue();
		while (!queue1.empty()) {
			for (int i = 0; i < 5; i++) {
				queue1.dequeue();
			}
			if (queue1.getSize() != 0) {
				System.out.println();
				System.out.println("Here are the new queue contents after removing five elements:");
				queue1.printQueue();			
			}
		}
		
		System.out.println();
		System.out.println("Initial queue 2 contents:");
		queue2.printQueue();
		while (!queue2.empty()) {
			for (int i = 0; i < 5; i++) {
				queue2.dequeue();
			}
			if (queue2.getSize() != 0) {
				System.out.println();
				System.out.println("Here are the new queue contents after removing five elements:");
				queue2.printQueue();
			}
		}
	}

}

@SuppressWarnings("serial")
class GenericQueueAlcineus<E> extends ArrayList<E> {
	/*
	 This is a constructor that initializes a default generic queue.
	 It allows a new generic queue object without parameters to be created.
	*/
	public GenericQueueAlcineus() {
		//No Argument
	}
	/*
	 This is a method with a generic parameter and uses the 'add' method from the ArrayList class to append elements to a queue. 
	 Since the size of array lists can change dynamically, there is no need for temporary arrays.
	*/
	public void enqueue(E v) {
		add(v);
	}
	/*
	 This is a generic method that uses the 'remove' method from the ArrayList class to remove and return the first element of a queue.
	 This method creates a temporary generic variable to return the first element of a queue before its removal.
	*/
	public E dequeue() {	
		while (!isEmpty()) {
			E first = get(0);
			remove(0);
			return first;
		}
		return null;
	}
	/*
	 This is a method that uses the 'isEmpty' method from the ArrayList class to return a true or false value based on the number of contents in a queue.
	 If the size of a queue is zero, then this method returns true. Otherwise, this method returns false.
	*/
	public boolean empty() {
		return isEmpty();
	}
	/*
	 This type of method is known as an accessor, also known as a getter, and it uses the 'size' method from the ArrayList class to get the size of a queue.
	 Using this getter, the size value of a queue object is returned to wherever the method is called from.
	*/
	public int getSize() {
		return size();
	}
	/*
	 This is a method that prints the contents of a queue.
	 This method converts a queue to a string in order to remove commas and brackets.
	*/
	public void printQueue() {
		System.out.println(toString().replace(",", "").replace("[", "").replace("]", "").trim());
	}
}