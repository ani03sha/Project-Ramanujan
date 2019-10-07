package org.redquark.ramanujan.prepwork;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is the implementation of LinkedList data structure. 
 * This is Singly Linked List which means the next pointer moves only in one direction, which
 * is in the forward direction.
 * 
 * @author Anirudh Sharma
 *
 */
public class SinglyLinkedList<T> implements Iterable<T> {

	// This node will represent the head node of the singly linked list
	private Node<T> head;

	/**
	 * No-argument constructor. This will create an empty singly linked list
	 */
	public SinglyLinkedList() {
		// If head is null, this means there is no singly linked list
		head = null;
	}

	/**
	 * This method will check if the singly list is empty or not.
	 */
	public boolean isEmpty() {
		// True - if head is null (means no linked list)
		// False - if head is not null (means at least one element is present)
		return head == null;
	}
	
	/**
	 * This method will add a new node as the first node of the linked list.
	 * 1. Create a new node object
	 * 2. Assign the next pointer of this node to the head of the current linked list
	 * 3. Reassign the head to the currently created node. This will be new head
	 */
	public void addFirst(T data) {
		// Creating a new node object.
		// After executing this, we will have head pointing to the current node and the
		// next pointer of this node will be the current head
		head = new Node<T>(data, head);
	}
	
	/**
	 * This method will return the head of the current singly linked list
	 */
	public T getFirst() {
		// First node will be the head of the linked list hence we are returning the
		// data stored in the head node
		return head.data;
	}
	
	/**
	 * This method will remove the head of the current singly linked list and returns it
	 */
	public T removeFirst() {
		// Temporary node that will store the head of the current singly linked list
		T temp = getFirst();
		// Point the header to the next node of the current head node
		head = head.next;
		// Return the temp node (which is removed)
		return temp;
	}
	
	/**
	 * This method will add a new node at the end of the linked list
	 * 1. Create a new node
	 * 2. Iterate the list to find the last node i.e. until we reach to the node whose next is null
	 * 3. Point the next of that node to the current node
	 * 4. Point the next of newly created node to null
	 */
	public void addLast(T data) {
		// Check if the head is null. This means there is no linked list and the new
		// node will be the head
		if (head == null) {
			// Call the addFirst method which will add the node as the first element of this
			// linked list
			addFirst(data);
		} else {
			// Creating a temp node - referencing head
			Node<T> temp = head;
			// Iterate the list until we find to the current last node
			while (temp.next != null) {
				// Moving the pointer one node at a time
				temp = temp.next;
			}
			// At this point, temp will be storing the last node.
			// Hence we are pointing the last node to the newly created node.
			// Next pointer of this new node will point to null as it will be the new last
			// node.
			temp.next = new Node<T>(data, null);
		}
	}
	
	/**
	 * This method will return the data stored in the last node of the linked list
	 * 1. Iterate the list until we reach the end of the linked list
	 * 2. Return the data stored in the last node of the linked list
	 */
	public T getLast() {
		// Base condition to check if the head is null i.e. no linked list
		if (head == null) {
			// Throw the exception
			throw new NoSuchElementException();
		}
		// Creating a temp node to get the reference of the head
		Node<T> temp = head;
		// Iterate until we reach to the end of the singly linked list
		while (temp.next != null) {
			// Move the pointer one node at a time
			temp = temp.next;
		}
		// At this point temp will be having the last node. So we are returning the data
		// stored in it.
		return temp.data;
	}
	
	public T removeLast() {
		// Base condition to check if the head is null i.e. no element in the list
		if(head == null) {
			throw new NoSuchElementException();
		}
		// Getting the reference of the head in the temp node
		Node<T> temp = head;
		// Iterate until we reach the second last node of the linked list
		while(temp.next.next != null) {
			// Moving pointer one node at a time
			temp = temp.next;
		}
		// Currently the temp is the second last node. So we get the data stored in the last node.
		// At this point temp.next will be the last node
		T data = temp.next.data;
		// Point the next of current second last node to null to make it the last node
		temp.next = null;
		// Returning the data stored in the previous last node
		return data;
	}
	
	/**
	 * This method inserts a new node after the specified key
	 * 1. Iterate until you reach the node which is specified as the key
	 * 2. Create a new node
	 * 3. Point the next of newly created node to the next of key
	 * 4. Point the next of key to the newly created node
	 */
	public void insertAfter(T key, T data) {
		// Getting the reference of the head in the temp
		Node<T> temp = head;
		// Iterate until we reach the key
		while (temp != null && !temp.data.equals(key)) {
			// Move the pointer one node at a time
			temp = temp.next;
		}
		// Create a new node whose next will be the next of current temp
		// And the next of current key will be updated to the newly created node
		temp.next = new Node<T>(data, temp.next);
	}
	
	/**
	 * This method inserts a new node before a specified key
	 * 1. If head is null then we cannot do anything - There is no list
	 * 2. If the key is head itself, then our new node will be the first node in the list
	 * 3. Maintain two pointers - previous to key and key itself
	 * 4. After reaching at the key, add the new node between previous and current
	 */
	public void insertBefore(T key, T data) {
		// Base condition - check if head is null
		if (head == null) {
			throw new UnsupportedOperationException();
		}
		// Checks if the head is key. In this case, our node will be added as the first
		// node in the list
		if (head.data.equals(key)) {
			addFirst(data);
			return;
		}
		// Creating two node pointers - previous and current
		Node<T> previous = null;
		Node<T> current = head;
		// Iterate until we reach to the key
		while (current != null && !current.data.equals(key)) {
			// Setting previous to current node
			previous = current;
			// Move current pointer one node forward
			current = current.next;
		}
		// Now we need to insert the node between previous and current
		previous.next = new Node<T>(data, current);
	}
	
	/**
	 * This method delete the node whose data is specified key
	 * 1. if head is null, then we cannot do anything. Throw exception
	 * 2. If head is the key then we point the next of current head as the new head
	 * 3. Iterate until we reach the node with key as the data field using previous and current pointer
	 * 4. Point next of previous to next of current
	 */
	public void remove(T key) {
		// Base condition - if head is null then there is no list
		if (head == null) {
			throw new RuntimeException("Cannot delete");
		}
		// Base condition - if head is the key
		if (head.data.equals(key)) {
			// Move the head to the next node
			head = head.next;
			return;
		}
		// Two pointers to keep track of previous and current nodes
		Node<T> previous = null;
		Node<T> current = head;
		// Iterate until we reach the key
		while (current != null && !current.data.equals(key)) {
			// Setting previous node to current node
			previous = current;
			// Moving current node one pointer ahead
			current = current.next;
		}
		// If the node is not present in the list
		if (current == null) {
			throw new RuntimeException("Cannot delete");
		}
		// Setting the next of previous to next of current thus eliminating the node
		// with key from the list
		previous.next = current.next;
	}
	
	/**
	 * This method deletes the entire linked list.
	 * We achieve this by pointing head to the null
	 */
	public void clear() {
		// Assigning null to head i.e. removes the existence of list
		head = null;
	}
	
	/**
	 * This method checks if the given key present in the linked list
	 */
	public boolean contains(T key) {
		// Iterate loop through the list
		for (T temp : this) {
			// Comparing key with the data present inside the current node
			if (temp.equals(key)) {
				// If found, return true...
				return true;
			}
		}
		// ... if not, return false;
		return false;
	}
	
	/**
	 * This method returns the data stored in the node specified by the given position
	 */
	public T get(int position) {
		// Base condition - head is null
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		// Getting the reference of the head in the temp node
		Node<T> temp = head;
		// Iterating loop until the position value
		for (int i = 0; i < position; i++) {
			if (temp != null) {
				// Moving the pointer one node ahead
				temp = temp.next;
			}
		}
		// If the position is greater than the number of elements in the list
		if (temp == null) {
			throw new IndexOutOfBoundsException();
		}
		// At this point, temp is representing the node at specified position
		return temp.data;
	}
	
	/**
	 * This method will return the reversed list of the list on which it is called
	 * 1. Create a new empty temp list
	 * 2. Get the reference of the head of the original list
	 * 3. Iterate through the list and add the current element of original list to the new list by calling addFirst
	 * 4. Returns the reversed list
	 * 
	 * Complexity: O(n)
	 */
	public SinglyLinkedList<T> reverse() {
		// Creating an instance of SinglyLinkedList.
		// This will store the reversed list
		SinglyLinkedList<T> reversedList = new SinglyLinkedList<>();
		// Getting reference to head of the original list
		Node<T> temp = head;
		// Iterate until we reach to the end of the list
		while (temp != null) {
			// Calling the addFirst method on each item
			reversedList.addFirst(temp.data);
			// Moving the pointer one node ahead
			temp = temp.next;
		}
		// Returns the reversed list
		return reversedList;
	}

	/**
	 * This method returns the deep copy of the original linked list
	 * 1. Create an instance of the SinglyLinkedList for deep copy
	 * 2. Get the reference of the head of the original list
	 * 3. Add each element of the original list in the reverse order
	 * 4. Reverse the newly created list and return
	 */
	public SinglyLinkedList<T> deepCopy() {
		// Create a temporary new list
		// This will store the deep copy of the original list
		SinglyLinkedList<T> deepCopyList = new SinglyLinkedList<>();
		// Get the reference of the head of the original list
		Node<T> temp = head;
		// Iterate through the original list
		while (temp != null) {
			// Add the data in current node to the list using addFirst method
			deepCopyList.addFirst(temp.data);
			// Move pointer one node ahead at a time
			temp = temp.next;
		}
		// At this point we have a new list but it is in the reverse order.
		// Hence, we call the reverse method on it and return
		return deepCopyList.reverse();
	}
	
	/**
	 * This method returns the iterator on the SinglyLinkedList
	 * This internally returns the instance of an inner class SinglyLinkedListIterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	/**
	 * Returns the String representation of the linked list.
	 * Overriding the default toString() method
	 */
	public String toString() {
		// Creating an instance of StringBuffer which will store the string
		// representation of the list
		StringBuffer result = new StringBuffer();
		// Iterate through the list
		for (T temp : this) {
			result.append(temp + " ");
		}
		// Returning after converting to String
		return result.toString();
	}
	
	/********************************************
	 * The Node class
	 ********************************************/
	private static class Node<T> {

		// Data to be stored in each node
		private T data;

		// Next pointer - this will point to the next node in the linked list
		private Node<T> next;

		/**
		 * This will be called whenever we create a new node (element) in the singly
		 * linked list
		 */
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/********************************************
	 * The Iterator class
	 ********************************************/
	private class SinglyLinkedListIterator implements Iterator<T> {

		// This will store the reference to the next node of the current node
		private Node<T> nextNode;

		public SinglyLinkedListIterator() {
			// Assigns the next node to the current head
			this.nextNode = head;
		}

		/**
		 * This method checks if the next node of current node is null or not
		 */
		@Override
		public boolean hasNext() {
			// This will return the boolean value based on whether the next node of current
			// node is null or not
			return nextNode != null;
		}

		/**
		 * This method will return the reference to the next node of the current node
		 */
		@Override
		public T next() {
			// If there is no next node then we throw the exception
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// Getting the data stored in the nextNode reference
			T data = nextNode.data;
			// Move the pointer one node ahead
			nextNode = nextNode.next;
			// Return the data
			return data;
		}

		/**
		 * In case the user calls remove operation while iterating then we throw the
		 * exception
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
