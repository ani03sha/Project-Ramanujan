package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _006BucketSort {

	/**
	 * This method sorts the array whose elements are uniformly distributed in a
	 * range
	 */
	public int[] sort(int[] a) {
		// Array of buckets
		int[] buckets = new int[maxValue(a) + 1];
		// Array that will stored the sorted elements
		int[] sorted = new int[a.length];
		// Loop for each element in the array
		for (int i = 0; i < a.length; i++) {
			buckets[a[i]]++;
		}
		int outPosition = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				sorted[outPosition++] = i;
			}
		}
		return sorted;
	}

	/**
	 * This method returns the max value that will be used to calculate the size of
	 * buckets to be created
	 */
	private int maxValue(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
}
