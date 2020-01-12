package org.redquark.ramanujan.ps.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having equal number of 0’s and 1’s
 * 
 * @author Anirudh Sharma
 *
 */
public class Arrays008_MaxSubarrayWithEqual0sAnd1s {

	/**
	 * This method returns the indexes of maximum subarray having equal 0s and 1s
	 */
	public int[] findMaxLengthSubarray(int[] a) {
		// Map to store (sum, index) tuples
		Map<Integer, Integer> tuples = new HashMap<>();
		// Insert (0, -1) pair into the set to handle the case when subarray with sum 0
		// starts from index 0
		tuples.put(0, -1);
		// Maximum length of subarray
		int maxLength = 0;
		// Ending index of the subarray which has sum 0
		int endIndex = -1;
		// Cumulative sum
		int cumulativeSum = 0;
		// Traverse through the given array
		for (int i = 0; i < a.length; i++) {
			// Sum of elements so far and replace 0 with -1;
			cumulativeSum += (a[i] == 0) ? -1 : 1;
			// If sum is already present in the map
			if (tuples.containsKey(cumulativeSum)) {
				// Update the length and ending index if required
				if (maxLength < i - tuples.get(cumulativeSum)) {
					maxLength = i - tuples.get(cumulativeSum);
					endIndex = i;
				}
			} else {
				tuples.put(cumulativeSum, i);
			}
		}
		// Starting index
		int startIndex = endIndex - maxLength + 1;

		return new int[] { startIndex, endIndex };

	}
}
