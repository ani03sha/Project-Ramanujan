package org.redquark.ramanujan.prepwork.ds;

/**
 * @author Anirudh Sharma
 *
 */
public class BinaryMinHeap<T extends Comparable<T>> {

	// The capacity of the Binary Min Heap
	private static final int CAPACITY = 2;
	// Current number of elements in the Binary Min Heap
	private int size;
	// Internal Heap array
	private T[] heapArray;

	/**
	 * Default constructor to create an instance of a BinaryMinHeap
	 */
	@SuppressWarnings("unchecked")
	public BinaryMinHeap() {
		this.size = 0;
		this.heapArray = (T[]) new Comparable[CAPACITY];
	}

	/**
	 * Construct a BinaryHeap given an array of items
	 */
	@SuppressWarnings("unchecked")
	public BinaryMinHeap(T[] array) {
		this.size = array.length;
		// Since we do not use index 0 for the simplicity that is why the heap array
		// will have the elements one place shifted from the passed array
		this.heapArray = (T[]) new Comparable[array.length + 1];
		System.arraycopy(array, 0, this.heapArray, 1, array.length);

		// Building the heap
		buildHeap();
	}

	/**
	 * This method builds the heap from the given array elements
	 */
	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		// Get the reference of the k'th element
		T temp = heapArray[k];
		// Child item
		int child = 0;
		for (; 2 * k <= size; k = child) {
			child = 2 * k;
			if (child != size && heapArray[child].compareTo(heapArray[child + 1]) > 0) {
				child++;
			}
			if (temp.compareTo(heapArray[child]) > 0) {
				heapArray[k] = heapArray[child];
			} else {
				break;
			}
		}
		heapArray[k] = temp;
	}

	/**
	 * This method will delete the top item from the heap which will be the smallest
	 * element in the heap
	 */
	public T deleteMinimum() {
		// Base condition - empty heap
		if (size == 0) {
			throw new RuntimeException("Cannot delete from the empty heap");
		}
		// Get the reference of the root
		T min = heapArray[1];
		// Make the last element of the heap as the minimum
		heapArray[1] = heapArray[size--];
		percolatingDown(1);
		return min;
	}

	/**
	 * This method inserts a new item in the heap
	 */
	public void insert(T item) {
		// Check if the heap is already full
		if (size == heapArray.length - 1) {
			// Create the heap with the double size
			doubleSize();
		}
		// Inserts a new item to the end of the array
		int position = size++;
		// Percolate up
		for (; position > 1 && item.compareTo(heapArray[position / 2]) < 0; position = position / 2) {
			heapArray[position] = heapArray[position / 2];
		}
		heapArray[position] = item;
	}

	@SuppressWarnings("unchecked")
	private void doubleSize() {
		// Old heap array
		T[] old = heapArray;
		// Create a new Heap array with double the size of the original array
		heapArray = (T[]) new Comparable[heapArray.length * 2];
		// Copy all the elements of the old heapArray to the new heapArray
		System.arraycopy(old, 1, heapArray, 1, size);
	}

	/**
	 * Overridden toString method to return the String representation of the
	 * elements stored in the heap
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= size; i++) {
			result.append(heapArray[i]).append(" ");
		}
		return result.toString();
	}
}
