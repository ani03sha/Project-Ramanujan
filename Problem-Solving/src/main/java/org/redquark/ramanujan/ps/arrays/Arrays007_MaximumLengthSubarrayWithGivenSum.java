package org.redquark.ramanujan.ps.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays007_MaximumLengthSubarrayWithGivenSum {

	/**
	 * This method will return the length of maximum subarray with the given sum
	 */
	public int findSubarray(int[] a, int s) {
		// Sum of the subarray
		int sum = 0;
		// Maximum length of the subarray
		int maxLength = 0;
		// Map to store (sum, index) tuples
		Map<Integer, Integer> tuples = new HashMap<>();
		// Loop through the entire array
		for (int i = 0; i < a.length; i++) {
			// Accumulate sum
			sum += a[i];
			// When subarray starts from index 0
			if (sum == s) {
				maxLength = i + 1;
			}
			// Make an entry for sum if it is not present in the tuples map
			if (!tuples.containsKey(sum)) {
				tuples.put(sum, i);
			}
			// Check if (sum - s) is present in map or not
			if (tuples.containsKey(sum - s)) {
				// Update the maxLength, if required
				maxLength = Math.max(maxLength, i - tuples.get(sum - s));
			}
		}
		return maxLength;
	}
}
