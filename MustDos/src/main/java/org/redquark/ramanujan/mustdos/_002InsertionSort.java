package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _002InsertionSort {

	/**
	 * This method sorts the array using insertion sort algorithm
	 */
	public int[] sort(int[] a) {
		// Outer loop that will progress the marker one step ahead
		for (int i = 1; i < a.length; i++) {
			// Get the current element which we need to compare with the remaining i-1
			// elements of the array
			int key = a[i];
			// Select the j index which checks the 1-1 elements
			int j = i - 1;
			// Loop for these i-1 elements and compare each element with the key in the
			// reverse order
			while (j >= 0 && a[j] > key) {
				// Move the element to the left
				a[j + 1] = a[j];
				// Decrement counter by 1
				j--;
			}
			// Now put the key in its appropriate position
			a[j + 1] = key;
		}
		return a;
	}

}
