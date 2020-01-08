package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _021LinkedListMergeSort {

	// Head of the Linked List
	Node head;

	/**
	 * This method recursively sorts the linked list using Merge Sort algorithm
	 */
	public Node sort(Node node) {
		// Base case - if head is null then there is no linked list
		if (node == null || node.next == null) {
			return node;
		}
		// Get the middle of the linked list using the 2-Pointer algorithm
		Node middle = getMiddle(node);
		// And get the next pointer of the middle node
		Node nextToMiddle = middle.next;
		// Set the next of middle to null - halving list
		middle.next = null;
		// Apply merge sort on the left list
		Node left = sort(node);
		// Apply merge sort on the right list
		Node right = sort(nextToMiddle);
		// Merge the left and right lists
		Node sorted = merge(left, right);

		return sorted;
	}

	/**
	 * This method re-merges the sorted nodes
	 */
	private Node merge(Node left, Node right) {
		// Resultant node
		Node result = null;
		// Base conditions
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		// Pick the node with smaller value and recur
		if (left.data <= right.data) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}
		return result;
	}

	/**
	 * This method returns the middle of the linked list
	 */
	private Node getMiddle(Node node) {
		if (node == null) {
			return node;
		}
		// Slow pointer
		Node slow = node;
		// Fast pointer
		Node fast = node;
		// Loop for each node in the list
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Slow pointer at this point will be the middle node
		return slow;
	}

	/**
	 * This method adds a new node at the front of the linked list
	 */
	void add(int data) {
		// Create a new node with the data
		Node n = new Node(data);
		// Made current head as the next of this new node
		n.next = head;
		// Update the new head;
		head = n;
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
	 * This class represents each node in the linked list
	 */
	static class Node {
		// Data to be stored in the node
		int data;
		// Next pointer of the node
		Node next;

		/**
		 * Default constructor
		 */
		Node(int data) {
			this.data = data;
		}
	}
}
