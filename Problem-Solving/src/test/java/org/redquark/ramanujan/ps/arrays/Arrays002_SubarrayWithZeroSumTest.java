package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays002_SubarrayWithZeroSumTest {

	private Arrays002_SubarrayWithZeroSum zeroSum = new Arrays002_SubarrayWithZeroSum();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays002_SubarrayWithZeroSum#checkIfZeroSumSubarrayExists(int[])}.
	 */
	@Test
	void testCheckIfZeroSumSubarrayExists() {
		assertTrue(zeroSum.checkIfZeroSumSubarrayExists(new int[] { 4, 2, -3, 1, 6 }));
		assertTrue(zeroSum.checkIfZeroSumSubarrayExists(new int[] { 4, 2, 0, 1, 6 }));
		assertFalse(zeroSum.checkIfZeroSumSubarrayExists(new int[] { -3, 2, 3, 1, 6 }));
	}

}
