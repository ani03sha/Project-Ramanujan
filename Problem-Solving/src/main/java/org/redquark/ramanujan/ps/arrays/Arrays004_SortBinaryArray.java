package org.redquark.ramanujan.ps.arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays004_SortBinaryArray {

	/**
	 * This method sorts the given binary array in one pass [Time Complexity: O(n)]
	 */
	public int[] sort(int[] a) {
		// Variable to keep track of index
		int j = -1;
		// Loop for the length of the array
		for (int i = 0; i < a.length; i++) {
			// Check if the current element is 0
			if (a[i] < 1) {
				// Increment the index
				j++;
				// Now swap the elements
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		return a;
	}
}