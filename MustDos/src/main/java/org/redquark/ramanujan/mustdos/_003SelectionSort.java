package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _003SelectionSort {

	/**
	 * This method sorts the array using selection sort algorithm
	 */
	public int[] sort(int[] a) {
		// Loop that will incrementally consider subarrays
		for (int i = 0; i < a.length - 1; i++) {
			// Current minimum element's index
			int minimumIndex = i;
			// Loop for each element in the subarray to find the minimum element and will
			// put it at the current i'th index
			for (int j = i + 1; j < a.length; j++) {
				// Check if the current minimum is greater than any element in the subarray
				if (a[minimumIndex] > a[j]) {
					minimumIndex = j;
				}
			}
			// Here, we have found out the minimum element in the subarray, therefore we
			// will assign it against the current index (i).
			int temp = a[i];
			a[i] = a[minimumIndex];
			a[minimumIndex] = temp;
		}
		return a;
	}
}
