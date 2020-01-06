package org.redquark.ramanujan.mustdos;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1
 * to n. There are no duplicates in the list. One of the integers is missing in
 * the list. Write an efficient code to find the missing integer.
 * 
 * @author Anirudh Sharma
 *
 */
public class _017FindMissingNumber {

	/**
	 * This method will return the one missing numbers in the array having elements
	 * from 1 to n.
	 */
	public int findMissing(int[] a, int n) {
		// XOR of all the elements in the array
		int x1 = a[0];
		// XOR of all the numbers from 1 to n
		int x2 = 1;
		// Loop array to find XOR of all the elements in the array
		for (int i = 1; i < n; i++) {
			x1 = x1 ^ a[i];
		}
		// Loop array to find XOR of all numbers from 1 to n.
		for (int i = 2; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}
		// Return XOR of x1 and x2
		return x1 ^ x2;
	}
}
