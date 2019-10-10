package org.redquark.ramanujan.prepwork.algo;

/**
 * @author Anirudh Sharma
 *
 */
public class MergeSort {

	public <T extends Comparable<T>> T[] sort(T[] arr, int l, int r) {
		if (l < r) {
			// Find the mid point of l and r
			int m = (l + r) / 2;

			// Recursively sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merging two halves
			merge(arr, l, m, r);
		}
		
		return arr;
	}

	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
		// Find sizes of two arrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create two temporary arrays
		T[] L = (T[]) new Comparable[n1];
		T[] R = (T[]) new Comparable[n2];

		// Copy data into these two arrays
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		// Process of merging two arrays starts

		// Initial indexes of subarrays
		int i = 0;
		int j = 0;

		// Initial index of the merged array
		int k = l;

		// Filling the array from subarrays
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j]) <= 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}