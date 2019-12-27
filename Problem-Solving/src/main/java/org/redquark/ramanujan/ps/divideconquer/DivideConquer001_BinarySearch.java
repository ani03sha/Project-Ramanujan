package org.redquark.ramanujan.ps.divideconquer;

/**
 * @author Anirudh Sharma
 *
 */
public class DivideConquer001_BinarySearch {

	/**
	 * This method performs binary search in a sorted array iteratively and returns
	 * the index of the key, if found
	 */
	public int searchIteratively(int[] a, int key) {
		// Low index
		int low = 0;
		// High index
		int high = a.length - 1;
		// Loop until the condition meets
		while (low <= high) {
			// Mid index
			int mid = low + (high - low) / 2;
			// Check if the middle element is the key
			if (key == a[mid]) {
				return mid;
			}
			// If the key is in the left half of the array
			else if (key < a[mid]) {
				high = mid - 1;
			}
			// If the key is in the right half of the array
			else {
				low = mid + 1;
			}
		}
		// If we reach here it means the key is not present in the array
		return -1;
	}

	/**
	 * This method performs binary search in a sorted array recursively and returns
	 * the index of the key, if found
	 */
	public int searchRecursively(int[] a, int key, int low, int high) {
		// Base condition
		if (low > high) {
			return -1;
		}
		// Mid index
		int mid = low + (high - low) / 2;
		// Check if the middle element is the key
		if (key == a[mid]) {
			return mid;
		}
		// Check if the key is in the left half
		else if (key < a[mid]) {
			return searchRecursively(a, key, low, mid - 1);
		}
		// Check if the key is in the right half
		else {
			return searchRecursively(a, key, mid + 1, high);
		}
	}
}