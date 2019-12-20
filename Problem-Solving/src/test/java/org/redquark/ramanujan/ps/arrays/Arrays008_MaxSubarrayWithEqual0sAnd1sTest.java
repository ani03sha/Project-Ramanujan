package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays008_MaxSubarrayWithEqual0sAnd1sTest {

	Arrays008_MaxSubarrayWithEqual0sAnd1s maxSubarray = new Arrays008_MaxSubarrayWithEqual0sAnd1s();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays008_MaxSubarrayWithEqual0sAnd1s#findMaxLengthSubarray(int[])}.
	 */
	@Test
	void testFindMaxLengthSubarray() {
		int[] a = new int[] { 1, 0, 0, 1, 0, 1, 1 };
		int[] expected = new int[] { 0, 5 };
		assertArrayEquals(expected, maxSubarray.findMaxLengthSubarray(a));
		
		a = new int[] {0, 0, 1, 0, 1, 0, 0};
		expected = new int[] {1, 4};
		assertArrayEquals(expected, maxSubarray.findMaxLengthSubarray(a));
	}

}
