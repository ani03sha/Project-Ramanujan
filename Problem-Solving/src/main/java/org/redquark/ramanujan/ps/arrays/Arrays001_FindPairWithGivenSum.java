package org.redquark.ramanujan.ps.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	/**
	 * This method returns the list of pair of indexes of all those numbers in an
	 * array whose sum is equal to the given sum
	 */
	public List<Integer[]> findAllPairs(int[] a, int sum) {

		// This list will store all the pairs having the given sum
		List<Integer[]> pairs = new ArrayList<>();
		// This array will store the indexes of the two numbers whose sum is equal to
		// the given sum
		Integer[] pair;

		// Base condition - if there are not enough elements to add, return null
		if (a.length < 2) {
			return null;
		}

		// Map that will store the difference of the sum and the current element as the
		// key and index as the value
		Map<Integer, Integer> pairDifference = new HashMap<>();

		// Loop through the entire array
		for (int i = 0; i < a.length; i++) {
			// Difference between the sum and the current element
			int difference = sum - a[i];
			// Check if the difference is already present in the map
			if (pairDifference.containsKey(difference)) {
				pair = new Integer[2];
				pair[0] = pairDifference.get(difference);
				pair[1] = i;
				pairs.add(pair);
			} else {
				pairDifference.put(a[i], i);
			}
		}
		return pairs;
	}
}
