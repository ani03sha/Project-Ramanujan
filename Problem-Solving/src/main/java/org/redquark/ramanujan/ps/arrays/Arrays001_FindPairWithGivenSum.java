package org.redquark.ramanujan.ps.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays001_FindPairWithGivenSum {

	/**
	 * This method will return the index of elements whose sum is equal to the given
	 * sum
	 */
	public int[] findPair(int[] a, int sum) {

		// This array will store the indexes of two elements whose sum is equal to the
		// given sum
		int[] pair = new int[2];

		// If the array has not even 2 elements we cannot proceed further
		if (a.length < 2) {
			return null;
		}

		// Map will store the difference of the sum and the current element as the key
		// and index as the value
		Map<Integer, Integer> pairDifference = new HashMap<>();

		// Loop for each element in the array
		for (int i = 0; i < a.length; i++) {
			int difference = sum - a[i];
			if (pairDifference.containsKey(difference)) {
				pair[0] = i;
				pair[1] = pairDifference.get(difference);
			} else {
				pairDifference.put(a[i], i);
			}
		}

		return pair;
	}
}
