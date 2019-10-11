package org.redquark.ramanujan.prepwork.ds;

/**
 * LinkedList based implementation of Stack
 * 
 * @author Anirudh Sharma
 *
 */
public class Stack<T> {

	// Top of the stack
	private Node<T> top;

	/**
	 * Default constructor of the stack
	 */
	public Stack() {
		top = null;
	}

	/**
	 * This method checks if the stack is empty or not
	 */
	public boolean isEmpty() {
		// True - if top is null
		// False - if top is not null
		return top == null;
	}

	/**
	 * This method deletes all the element in the stack by making top equals to null
	 */
	public void clear() {
		// Assign null to top
		top = null;
	}

	/**
	 * This method adds element to the top of the stack. This method internally adds
	 * node to the front of the underlying linked list
	 */
	public void push(T data) {
		// 1. A new node is created
		// 2. New node has data (which is passed) and current top as the next pointer
		// 3. Update the top with the newly created node
		top = new Node<T>(data, top);
	}

	/**
	 * This method removes the node at the top and returns the data stored in it
	 */
	public T pop() {
		// Base condition - if the Stack is empty then we cannot do anything
		if (isEmpty()) {
			throw new RuntimeException("Can't delete, Stack is empty");
		}
		// Storing the data in the top
		T data = top.data;
		// Point top to the next of the current top
		top = top.next;
		// Return data in the previous top
		return data;
	}

	/**
	 * This method returns the top without removing it
	 */
	public T peek() {
		// If the stack is empty
		if (isEmpty()) {
			throw new RuntimeException("Can't delete, Stack is empty");
		}
		return top.data;
	}

	/**
	 * Overridden toString method
	 */
	public String toString() {
		// If the stack is empty
		if (isEmpty()) {
			return "[]";
		}
		// Getting the reference of the top
		Node<T> temp = top;
		// StringBuilder to store the String representation
		StringBuilder result = new StringBuilder();
		// Loop through the entire stack
		while (temp != null) {
			result.append(temp.data).append(" ");
			temp = temp.next;
		}
		return result.toString();
	}

	/***************************
	 * The Node class
	 ***************************/
	private static class Node<T> {

		// Data to be stored in the node of the linked list
		private T data;
		// Next pointer of the node
		private Node<T> next;

		/**
		 * Constructor with both data and next pointer specified
		 */
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

}
