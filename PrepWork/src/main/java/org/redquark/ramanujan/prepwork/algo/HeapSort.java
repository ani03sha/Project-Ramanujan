package org.redquark.ramanujan.prepwork.algo;

/**
 * @author Anirudh Sharma
 *
 */
public class HeapSort {

	/**
	 * This method sorts the array of element using the Heap Sort
	 */
	public <T extends Comparable<T>> T[] sort(T[] a) {
		// Length of the array
		int n = a.length;

		// Building heap (basically we are rearranging array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(a, n, i);
		}

		// One by one extract elements from the heap
		for (int i = n - 1; i >= 0; i--) {
			// Move the current root to the end
			T temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			// Call max heapify on the reduced heap
			heapify(a, i, 0);
		}

		return a;
	}

	/**
	 * This method heapifies a subtree rooted with node i which is an index in the
	 * array. Size of the heap is n.
	 */
	private <T extends Comparable<T>> void heapify(T[] a, int n, int i) {
		// Set root as the largest
		int largest = i;
		// Left child - (2 * i + 1)
		int l = 2 * i + 1;
		// Right child - (2 * i + 2)
		int r = 2 * i + 2;

		// If left child is larger than the root
		if (l < n && a[l].compareTo(a[largest]) > 0) {
			largest = l;
		}

		// If right child is largest than largest so far
		if (r < n && a[r].compareTo(a[largest]) > 0) {
			largest = r;
		}

		// IF largest is not root
		if (largest != i) {
			// Swap the elements
			T temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;

			// Recursively heapify the affected subtree
			heapify(a, n, largest);
		}
	}

}
