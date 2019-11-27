package org.redquark.ramanujan.prepwork.ds;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Anirudh Sharma
 *
 */
public class PriorityQueue<T> {

	// Default capacity of the PriorityQueue
	private static final int DEFAULT_CAPACITY = 100;
	// Underlying array for the Heap data structure
	private T[] heap;
	// Number of elements in the heap
	private int currentSize;
	// Underlying comparator
	private Comparator<? super T> comparator;

	/**
	 * Default constructor that creates an empty priority queue
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		this.currentSize = 0;
		this.comparator = null;
		this.heap = (T[]) new Object[DEFAULT_CAPACITY + 1];
	}

	/**
	 * Constructor that creates a priority queue with the specified comparator
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<? super T> comparator) {
		this.currentSize = 0;
		this.comparator = comparator;
		this.heap = (T[]) new Object[DEFAULT_CAPACITY + 1];
	}

	/**
	 * Constructor that creates a priority queue from the given collection object
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue(Collection<? extends T> collection) {
		this.comparator = null;
		this.currentSize = collection.size();
		heap = (T[]) new Object[(currentSize + 2) * 11 / 10];

		// Temp index
		int i = 0;
		// Copy all the elements of the collection into the heap array
		for (T item : collection) {
			heap[i++] = item;
		}
		// Building the heap
		buildHeap();
	}

	/**
	 * This method adds an item to the priority queue
	 */
	public void add(T item) {
		if (currentSize + 1 == heap.length) {
			doubleArray();
		}

		// Percolate up
		int hole = ++currentSize;
		heap[0] = item;

		for (; compare(item, heap[hole / 2]) < 0; hole /= 2) {
			heap[hole] = heap[hole / 2];
		}
		heap[hole] = item;
	}

	/**
	 * Removes the smallest element in the priority queue
	 */
	public T remove() {
		// Minimum item in the heap
		T minimum = minimumElement();
		heap[1] = heap[currentSize--];
		percolateDown(1);
		return minimum;
	}

	/**
	 * Returns the number of items in the priority queue
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Make this priority queue empty
	 */
	public void clear() {
		currentSize = 0;
	}

	public T minimumElement() {
		if (currentSize == 0) {
			throw new RuntimeException("No element in the queue");
		}
		return heap[1];
	}

	/**
	 * Returns an iterator over the elements in this PriorityQueue. The iterator
	 * does not view the elements in any particular order.
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int current = 0;

			public boolean hasNext() {
				return current != size();
			}

			public T next() {
				if (hasNext()) {
					return heap[++current];
				} else {
					throw new NoSuchElementException();
				}
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * This internal method builds the heap
	 */
	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	/**
	 * Internal method to percolate down in the heap
	 */
	private void percolateDown(int hole) {
		int child;
		T temp = heap[hole];
		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize && compare(heap[child + 1], heap[child]) < 0) {
				child++;
			}
			if (compare(heap[child], temp) < 0) {
				heap[hole] = heap[child];
			} else {
				break;
			}
		}
		heap[hole] = temp;
	}

	/**
	 * Compares lhs and rhs using comparator if provided, or the default comparator.
	 */
	@SuppressWarnings("unchecked")
	private int compare(T lhs, T rhs) {
		if (comparator == null) {
			return ((Comparable<T>) lhs).compareTo(rhs);
		} else {
			return comparator.compare(lhs, rhs);
		}
	}

	/**
	 * Internal method to extend array
	 */
	private void doubleArray() {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[heap.length * 2];
		for (int i = 0; i < heap.length; i++) {
			newArray[i] = heap[i];
		}
		heap = newArray;
	}
}
