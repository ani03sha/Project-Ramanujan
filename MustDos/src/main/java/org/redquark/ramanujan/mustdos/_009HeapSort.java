package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _009HeapSort {

	/**
	 * This method sorts the given array using Heap Sort algorithm where we are
	 * going to use max heap
	 */
	public int[] sort(int[] a) {
		// Length of the array
		int n = a.length;
		// Build the heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			// Heapify the array i.e. storing them in the heap
			heapify(a, n, i);
		}
		// One by one extract an element from the heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to the end
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			// Call the max heapify to reduce heap
			heapify(a, i, 0);
		}
		return a;
	}

	/**
	 * This method heapifies a subtree rooted at the index i.
	 */
	private void heapify(int[] a, int n, int i) {
		// Initialize largest as the root
		int largest = i;
		// Left child
		int left = 2 * i + 1;
		// Right child
		int right = 2 * i + 2;
		// Check if the left child is larger than the largest
		if (left < n && a[left] > a[largest]) {
			largest = left;
		}
		// Check if the right child is larger than the largest
		if (right < n && a[right] > a[largest]) {
			largest = right;
		}
		// If largest is not root then swap
		if (largest != i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			// Recursively heapify the affected subtree
			heapify(a, n, largest);
		}
	}
}
