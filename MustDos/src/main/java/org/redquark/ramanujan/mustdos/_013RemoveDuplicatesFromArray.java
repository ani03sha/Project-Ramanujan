package org.redquark.ramanujan.mustdos;

import java.util.Arrays;

/**
 * Remove duplicates from array without using any Collections API
 * 
 * @author Anirudh Sharma
 *
 */
public class _013RemoveDuplicatesFromArray {

	/**
	 * This method removes the duplicates from an array 'a'.
	 */
	public int[] removeDuplicates(int[] a) {
		// Length of the array
		int n = a.length;
		// Base condition - if the array has only 0 or 1 element
		if (n == 0 || n == 1) {
			return a;
		}
		// Sort the array
		Arrays.sort(a);
		// This will store the index of next unique element
		int j = 0;
		// Loop for each element in the array
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1]) {
				a[j++] = a[i];
			}
		}
		// For the last element
		a[j++] = a[n - 1];
		// Copy the array from beginning to the j index
		a = Arrays.copyOfRange(a, 0, j);
		
		return a;
	}
}
