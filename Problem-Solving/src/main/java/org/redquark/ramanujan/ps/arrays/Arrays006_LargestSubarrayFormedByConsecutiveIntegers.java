package org.redquark.ramanujan.ps.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find length of the longest subarray which
 * contains numbers that can be arranged in a continuous sequence.
 * 
 * @author Anirudh Sharma
 *
 */
public class Arrays006_LargestSubarrayFormedByConsecutiveIntegers {

	/**
	 * This method will find out the largest subarray formed by the consecutive
	 * integers
	 */
	public int subarrayWithoutDuplicates(int[] a) {
		// Maximum length of subarray
		int maxLength = 1;
		// Loop for the length of the array
		for (int i = 0; i < a.length - 1; i++) {
			// Initialize the max and min
			int max = a[i];
			int min = a[i];
			// Consider all subarrays starting from i and ending at j
			for (int j = i + 1; j < a.length; j++) {
				// Update the max and min, if needed
				max = Math.max(max, a[j]);
				min = Math.min(min, a[j]);
				// If the current sub array has all contiguous elements
				if (max - min == j - i) {
					maxLength = Math.max(maxLength, max - min + 1);
				}
			}
		}
		return maxLength;
	}

	/**
	 * This method checks for the maximum length of the subarray with continuous
	 * integers allowing duplicates also
	 */
	public int subarrayWithDuplicates(int[] a) {
		// Maximum length of the subarray
		int maxLength = 1;
		// Loop for the length of the array
		for (int i = 0; i < a.length - 1; i++) {
			// Create a Set for each subarray
			Set<Integer> duplicateMarker = new HashSet<>();
			// Add the current element in the set
			duplicateMarker.add(a[i]);
			// Max and min in current subarray
			int max = a[i];
			int min = a[i];
			// Consider all subarrays starting from i and ending at j
			for (int j = i + 1; j < a.length; j++) {
				// If the set contains the already present element then we discard this subarray
				if (duplicateMarker.contains(a[j])) {
					break;
				}
				// Add current element to the set and update max and min, if required
				duplicateMarker.add(a[j]);
				max = Math.max(max, a[j]);
				min = Math.min(min, a[j]);
				// Update maxLength if required
				if (max - min == j - i) {
					maxLength = Math.max(maxLength, max - min + 1);
				}
			}
		}
		return maxLength;
	}
}
