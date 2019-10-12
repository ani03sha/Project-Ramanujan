package org.redquark.ramanujan.prepwork.ds;

import java.util.Iterator;

/**
 * This is an implementation of a dynamic wraparound queue structure. It
 * implements the Iterator interface for traversing the queue.
 * 
 * @author Anirudh Sharma
 *
 */
public class Queue<T> implements Iterable<T> {

	// Default capacity of the Queue. The queue of this size will be created when a
	// brand new instance of Queue is created
	private static final int DEFAULT_CAPACITY = 10;

	// Total number of elements in the Queue
	private int capacity;

	// Current number of elements in the Queue
	private int current;

	// Front index of the Queue
	private int front;

	// Rear index of the Queue
	private int rear;

	// Underlying array
	private T[] A;

	/**
	 * Constructor to create an empty Queue
	 */
	@SuppressWarnings("unchecked")
	public Queue() {
		this.capacity = DEFAULT_CAPACITY;
		this.A = (T[]) new Object[DEFAULT_CAPACITY];
		this.front = 0;
		this.rear = -1;
	}

	/**
	 * This method checks if the Queue is empty or not
	 */
	public boolean isEmpty() {
		// True - if the Queue is empty
		// False - If the Queue is not empty
		return current == 0;
	}

	/**
	 * This method checks if the Queue is logically full
	 */
	public boolean isFull() {
		// True - if the Queue is logically full
		// False - if we have space to add more elements
		return current == capacity;
	}

	/**
	 * Adds the data into back of the Queue. It works with the wraparound. If the
	 * Queue is full, we double its size
	 */
	public void enqueue(T data) {
		// Checks if the Queue is full
		if (isFull()) {
			// If the Queue is full, then double the size of the underlying array and hence
			// the Queue
			doubleSize();
		}
		// Increment the rear by 1
		rear++;
		// Enqueue the value
		A[rear % capacity] = data;
		// Increment current by 1
		current++;
	}

	/**
	 * Returns and removes the front element from the Queue. It works with
	 * wraparound.
	 */
	public T dequeue() {
		// Getting the front element of the Queue
		T e = getFront();
		// Making the space eligible for Garbage Collection
		A[front % capacity] = null;
		// Incrementing the front
		front++;
		// Decrementing the current
		current--;
		// Returning the front which was deleted
		return e;
	}

	/**
	 * Makes the Queue physically empty
	 */
	public void clear() {
		// Loop for all the elements in the Queue
		for (int i = 0; i < capacity; i++) {
			current = 0;
			rear = -1;
			front = 0;
		}
	}

	/**
	 * Increase the Queue's capacity by doubling the size of the underlying array
	 */
	@SuppressWarnings("unchecked")
	private void doubleSize() {
		// Creating a new array
		T[] newArray = (T[]) new Object[2 * capacity];
		// Copy items of the old array to the new one
		for (int i = front; i <= rear; i++) {
			newArray[i - front] = A[i % capacity];
		}
		// Referencing the newly created array to the underlying array
		A = newArray;
		// Setting front to 0
		front = 0;
		// Setting the rear to one less than current
		rear = current - 1;
		capacity = capacity * 2;
	}

	/**
	 * This method returns the front element from the Queue. It works with the
	 * wraparound.
	 */
	public T getFront() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		} else {
			return A[front % capacity];
		}
	}

	/**
	 * Obtains an Iterator object used to traverse the Queue from its front to back.
	 */
	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	/**
	 * Custom implementation for this Queue class
	 * 
	 * @author Anirudh Sharma
	 *
	 */
	private class QueueIterator implements Iterator<T> {

		// Traversal index
		private int index;

		/**
		 * Constructor - This will create an empty iterator
		 */
		public QueueIterator() {
			index = front;
		}

		/**
		 * This method checks if there are more items in the Queue
		 */
		@Override
		public boolean hasNext() {
			return index <= rear;
		}

		/**
		 * Returns the next item in the Queue
		 */
		@Override
		public T next() {
			return A[(index++) % capacity];
		}

		/**
		 * This is not implemented and should throw an exception when called
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
