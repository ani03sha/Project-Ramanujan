package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _010BinarySearch {

	/**
	 * This method searches the given key in the given array. The array needs to be
	 * sorted for this method to work.
	 */
	public int search(int[] a, int key) {
		// Lower index
		int low = 0;
		// Higher index
		int high = a.length - 1;
		// Loop until the low index is less than or equal to the high index
		while (low <= high) {
			// Find the mid index
			int mid = low + (high - low) / 2;
			// If the key is present at the mid index itself
			if (key == a[mid]) {
				return mid;
			}
			// If the key is less than the element at the mid index. This means the key lies
			// in the left half of the array.
			else if (key < a[mid]) {
				high = mid - 1;
			}
			// If the key is greater than the element at the mid index. This means the key
			// lies in the right half of the array.
			else {
				low = mid + 1;
			}
		}
		// IF we reach here it means we have not found the key in the array
		return -1;
	}
}
