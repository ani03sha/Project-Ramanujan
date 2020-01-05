package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _015SwapTwoNumbers {

	/**
	 * This method swaps two numbers without using a third variable
	 */
	public int[] swap(int[] a) {
		// This will be done using XOR operator
		a[0] = a[0] ^ a[1];
		a[1] = a[0] ^ a[1];
		a[0] = a[0] ^ a[1];
		return a;
	}
}
