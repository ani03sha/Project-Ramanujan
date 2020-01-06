package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _020InsertANodeAtMiddle {

	// Head of the linked list
	private static Node head;

	public Node insert(int data) {

		// First we are going to find the middle of the linked list using the two
		// pointer approach

		// Slow pointer
		Node slow = head;
		// Fast pointer
		Node fast = head.next;

		// Loop for each node in the list
		while (fast != null && fast.next != null) {
			// Move slow pointer one step ahead
			slow = slow.next;
			// Move fast pointer two steps ahead
			fast = fast.next.next;
		}
		// At this point, the middle is represented by the slow pointer

		// Creating a new node with the given data
		Node n = new Node(data, slow.next);
		// The next of slow will now point to the the new node
		slow.next = n;

		return head;
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
