package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _004MergeSort {

	/**
	 * This method sorts the given array using the merge sort algorithm
	 */
	public int[] sort(int[] a, int l, int r) {
		// If the left index is less than the right index
		if (l < r) {
			// Find the mid points of l and r
			int m = l + (r - l) / 2;
			// Recursively call the first half
			sort(a, l, m);
			// Recursively call the second half
			sort(a, m + 1, r);
			// Call the merging algorithm
			merge(a, l, m, r);
		}
		// Return the sorted array
		return a;
	}

	/**
	 * This method merges the subarrays that are sorted
	 */
	private void merge(int[] a, int l, int m, int r) {
		// Find the sizes of the subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;
		// Create temp arrays of sizes n1 and n2 - These are going to hold elements of
		// left and right parts
		int[] L = new int[n1];
		int[] R = new int[n2];
		// Copy data into these arrays
		for (int i = 0; i < n1; i++) {
			L[i] = a[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = a[m + 1 + j];
		}
		/**
		 * Merging process starts from here
		 */
		// Initial indices of left and right subarray
		int i = 0;
		int j = 0;
		// Initial index of the merged subarray
		int k = l;
		// Start filling up the array such that so that the elements in them are sorted
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;
		}
		// Copy remaining elements of L[], if any
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}
		// Copy remaining elements of R[], if any
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}
}
