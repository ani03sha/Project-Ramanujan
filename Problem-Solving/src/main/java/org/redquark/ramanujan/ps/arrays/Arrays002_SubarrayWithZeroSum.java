package org.redquark.ramanujan.ps.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays002_SubarrayWithZeroSum {

	/**
	 * This method will check if there is a subarray with zero sum in the given
	 * array
	 */
	public boolean checkIfZeroSumSubarrayExists(int[] a) {

		// Set that will store the cumulative sum
		Set<Integer> sum = new HashSet<>();

		// Add initial sum value
		sum.add(0);

		// This variable will store the cumulative sum of elements from 0 to i
		int cumulativeSum = 0;
		
		// Loop until we encounter an already added value in the sum
		for (int i = 0; i < a.length; i++) {
			// Update cumulative sum
			cumulativeSum += a[i];
			// Check if the cumulative sum is already added in the set
			if(!sum.add(cumulativeSum)) {
				return true;
			}
			sum.add(cumulativeSum);
		}
		return false;
	}
}
