package org.redquark.ramanujan.mustdos;

/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 * 
 * @author Anirudh Sharma
 *
 */
public class _027KadaneAlgorithm {

	public int findMaxSumSubArray(int[] a) {
		// Maximum sum so far
		int maxSoFar = a[0];
		// Current maximum
		int currentMax = a[0];
		// Loop for the remaining elements in the array
		for (int i = 1; i < a.length; i++) {
			currentMax = Math.max(a[i], currentMax + a[i]);
			maxSoFar = Math.max(currentMax, maxSoFar);
		}
		return maxSoFar;
	}
}
