package org.redquark.ramanujan.ps.binary;

/**
 * @author Anirudh Sharma
 *
 */
public class Binary001_BitHacks01 {

	/**
	 * This method checks if a number is even or odd
	 */
	public String isEvenOrOdd(int n) {
		return (n & 1) == 1 ? "Odd" : "Even";
	}

	/**
	 * This method checks if the two numbers have opposite signs or not
	 */
	public boolean haveOppositeSigns(int a, int b) {
		return (a ^ b) < 0;
	}

	/**
	 * This method adds one to the given number
	 */
	public int addOne(int n) {
		return -~n;
	}

	/**
	 * This method swaps two numbers using bit operations and without using third
	 * variable
	 */
	public int[] swap(int[] a) {
		if (a[0] != a[1]) {
			a[0] = a[0] ^ a[1];
			a[1] = a[0] ^ a[1];
			a[0] = a[0] ^ a[1];
		}
		return a;
	}
}
