package org.redquark.ramanujan.ps.binary;

/**
 * In this class, we will discuss few related problems that operates on the k’th
 * bit of a number.
 * 
 * @author Anirudh Sharma
 *
 */
public class Binary002_BitHacks02 {

	/**
	 * This method turns off the k'th bit in the binary representation of n
	 */
	public String turnOffKthBit(int n, int k) {
		return Integer.toBinaryString(n & ~(1 << (k - 1)));
	}

	/**
	 * This method turns on the k'th bit in the binary representation of n
	 */
	public String turnOnKthBit(int n, int k) {
		return Integer.toBinaryString(n | (1 << (k - 1)));
	}

	/**
	 * This method checks if the k'th bit is set in the binary representation of n
	 */
	public boolean isKthBitSet(int n, int k) {
		return (n & (1 << (k - 1))) != 0;
	}

	/**
	 * This method toggles the k'th bit in the binary representation of n
	 */
	public String toggleKthBit(int n, int k) {
		return Integer.toBinaryString(n ^ (1 << (k - 1)));
	}
}
