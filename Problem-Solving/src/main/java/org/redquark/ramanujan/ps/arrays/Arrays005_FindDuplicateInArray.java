package org.redquark.ramanujan.ps.arrays;

import java.util.stream.IntStream;

/**
 * Given a limited range array of size n where array contains elements between 1
 * to n-1 with one element repeating, find the duplicate number in it.
 * 
 * @author Anirudh Sharma
 *
 */
public class Arrays005_FindDuplicateInArray {

	/**
	 * This method finds the duplicate element in an array
	 */
	public int findDuplicate(int[] a) {
		// Length of the array
		int n = a.length;
		// Expected sum - using n(n+1)/2. Taking n-1 here because we have elements from
		// 1 to n-1
		int expected = (n * (n - 1)) / 2;
		// Actual sum of array elements
		int actual = IntStream.of(a).sum();
		// Duplicate number
		return actual - expected;
	}
}
