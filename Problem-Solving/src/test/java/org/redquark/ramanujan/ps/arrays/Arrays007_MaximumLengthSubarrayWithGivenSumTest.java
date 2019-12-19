package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays007_MaximumLengthSubarrayWithGivenSumTest {

	private Arrays007_MaximumLengthSubarrayWithGivenSum maxLengthSubarray = new Arrays007_MaximumLengthSubarrayWithGivenSum();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays007_MaximumLengthSubarrayWithGivenSum#findSubarray(int[], int)}.
	 */
	@Test
	void testFindSubarray() {
		int[] a = new int[] { 10, 5, 2, 7, 1, 9 };
		int s = 15;
		assertEquals(4, maxLengthSubarray.findSubarray(a, s));

		a = new int[] { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		s = 8;
		assertEquals(4, maxLengthSubarray.findSubarray(a, s));
	}

}
