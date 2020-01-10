package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _025FindKthNodeFromEnd {

	// Head of the linked list
	private static Node head;

	/**
	 * This method returns the k'th node form the end of the linked list
	 */
	public Node gtNthFromLast(int k) {
		// Base condition - if head is null therefore there is no linked list and every
		// node will be null
		if (head == null) {
			return head;
		}
		// Create main and reference pointers
		Node main = head;
		Node reference = head;
		// Counter of nodes
		int count = 0;
		// Loop the reference pointer until the count is less than the given k
		while (count < k) {
			if (reference == null) {
				throw new IllegalArgumentException("The list does not enough nodes");
			}
			reference = reference.next;
			count++;
		}
		// Now we will move both pointers together
		while (reference != null) {
			main = main.next;
			reference = reference.next;
		}
		return main;
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
