package org.redquark.ramanujan.mustdos;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class _007CountingSort {

	/**
	 * This method returns the sorted array using Counting Sort technique
	 */
	public int[] sort(int[] a) {
		// Get the maximum array element
		int max = Arrays.stream(a).max().getAsInt();
		// Get the minimum array element
		int min = Arrays.stream(a).min().getAsInt();
		// Range of elements
		int range = max - min + 1;
		// Count array
		int[] count = new int[range];
		// Array that will store the output
		int[] output = new int[a.length];
		// Loop for all the elements in the array and store their counts
		for (int i = 0; i < a.length; i++) {
			count[a[i] - min]++;
		}
		// Find the cumulative sum of array
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		// Store the values from the count array in their respective positions
		for (int i = a.length - 1; i >= 0; i--) {
			output[count[a[i] - min] - 1] = a[i];
			count[a[i] - min]--;
		}
		// Place the values from the output array to the original one
		for (int i = 0; i < a.length; i++) {
			a[i] = output[i];
		}
		// Return the original array
		return a;
	}
}
