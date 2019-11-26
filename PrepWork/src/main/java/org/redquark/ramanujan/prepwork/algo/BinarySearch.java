package org.redquark.ramanujan.prepwork.algo;

/**
 * This class implements the binary search algorithm
 * 
 * @author Anirudh Sharma
 *
 */
public class BinarySearch {

	/**
	 * This method returns the index of the key, if present in the given array. If
	 * the key is not present, it returns -1.
	 */
	public <T extends Comparable<T>> int search(T[] a, T key) {
		// Lower index
		int left = 0;
		// Higher index
		int right = a.length - 1;

		// Loop until low is less than or equals to the high
		while (left <= right) {
			// Find the middle index
			int mid = left + (right - left) / 2;

			// Check if the middle element is the key
			if (a[mid].compareTo(key) == 0) {
				return mid;
			}

			// If key is greater than the element at the mid then ignore the left half
			if (a[mid].compareTo(key) < 0) {
				left = mid + 1;
			}

			// If key is less than the element at the mid then ignore the right half
			if (a[mid].compareTo(key) > 0) {
				right = right - 1;
			}
		}

		// If we reach here it means the element is not present in the array
		return -1;
	}
}
