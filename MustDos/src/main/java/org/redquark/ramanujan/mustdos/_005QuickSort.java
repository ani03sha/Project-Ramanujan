package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _005QuickSort {

	/**
	 * This method sorts the given array using Quick Sort algorithm
	 */
	public int[] sort(int[] a, int low, int high) {
		// Check of the left index is lower than the right index
		if (low < high) {
			// Find the partition index
			int p = partition(a, low, high);
			// Recursively sort the left subarray
			sort(a, low, p - 1);
			// Recursively sort the right subarray
			sort(a, p + 1, high);
		}
		// Return the sorted array
		return a;
	}

	/**
	 * This method finds the partition index
	 */
	private int partition(int[] a, int low, int high) {
		// Set the pivot as the rightmost element of the array
		int pivot = a[high];
		// Index for pass
		int i = low - 1;
		// Loop until we reach the second last element of the array. Second last because
		// we have set the last element as the pivot.
		for (int j = low; j < high; j++) {
			// Check if the current element is less than the pivot
			if (a[j] < pivot) {
				i++;
				// Swap the elements
				swap(a, i, j);
			}
		}
		// Now swap a[i+1] and pivot/a[high]
		swap(a, i + 1, high);
		// Returns the i+1 index
		return i + 1;
	}

	/**
	 * This method swaps the elements at the passed indices
	 */
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
