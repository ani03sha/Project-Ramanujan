package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _019ReverseLinkedListInplace {

	private static Node head;

	/**
	 * This method reverses the linked list
	 */
	public Node reverse() {
		// Create three reference pointers
		Node current = head;
		Node previous = null;
		Node next = null;

		// Loop for each node in the list
		while (current != null) {
			// Set next as the current next of "current" node
			next = current.next;
			// Next of current to the previous
			current.next = previous;
			// Move one pointer ahead
			previous = current;
			current = next;
		}
		// Set the head
		head = previous;

		return head;
	}

	/**
	 * Overridden toString method
	 */
	@Override
	public String toString() {
		// StringBuilder instance to store all the elements in the linked list
		StringBuilder result = new StringBuilder();
		// Reference of the head node
		Node node = head;
		// Loop for each node in the list
		while (node != null) {
			// Append the data in the node
			result.append(node.data).append(" ");
			// Move pointer one node ahead
			node = node.next;
		}
		return result.toString();
	}

	/**
	 * This method adds the new node as the first node in the linked list
	 */
	void add(int data) {
		head = new Node(data, head);
	}

	/**
	 * This method represents each node of the linked list
	 */
	static class Node {
		// Data to be stored in the node
		int data;
		// Next pointer to the node
		Node next;

		/**
		 * Default constructor
		 */
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
