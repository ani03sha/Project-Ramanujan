package org.redquark.ramanujan.ps.arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays009_DutchNationalFlagProblem {

	/**
	 * This method sorts all the 0s, 1s and 2s together using DNF's three way
	 * partition
	 */
	public int[] sort(int[] a) {
		// Taking pivot as 1
		int pivot = 1;
		// Low, high and mid
		int low = 0;
		int mid = 0;
		int high = a.length - 1;

		// Loop for until mid is less than or equal to high
		while (mid <= high) {
			// If the current element is 0
			if (a[mid] < pivot) {
				swap(a, low, mid);
				++low;
				++mid;
			}
			// Current element is 2
			else if (a[mid] > pivot) {
				swap(a, mid, high);
				--high;
			}
			// Current element is 1
			else {
				++mid;
			}
		}
		return a;
	}

	/**
	 * This method swaps two elements in the array whose indices are given
	 */
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
