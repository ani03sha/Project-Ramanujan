package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _027KadaneAlgorithmTest {

	private _027KadaneAlgorithm kadane = new _027KadaneAlgorithm();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._027KadaneAlgorithm#findMaxSumSubArray(int[])}.
	 */
	@Test
	void testFindMaxSumSubArray() {
		int[] a = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		assertEquals(7, kadane.findMaxSumSubArray(a));

		a = new int[] { 2, 3, 4, 5, 7 };
		assertEquals(21, kadane.findMaxSumSubArray(a));
	}

}
