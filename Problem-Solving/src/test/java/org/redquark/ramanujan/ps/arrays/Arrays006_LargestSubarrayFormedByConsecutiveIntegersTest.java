package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays006_LargestSubarrayFormedByConsecutiveIntegersTest {

	private Arrays006_LargestSubarrayFormedByConsecutiveIntegers largestSubarray = new Arrays006_LargestSubarrayFormedByConsecutiveIntegers();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays006_LargestSubarrayFormedByConsecutiveIntegers#subarrayWithoutDuplicates(int[])}.
	 */
	@Test
	void testSubarrayWithoutDuplicates() {
		int[] a = new int[] { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		assertEquals(5, largestSubarray.subarrayWithoutDuplicates(a));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays006_LargestSubarrayFormedByConsecutiveIntegers#subarrayWithDuplicates(int[])}.
	 */
	@Test
	void testSubarrayWithDuplicates() {
		int[] a = new int[] { 10, 12, 12, 10, 10, 11, 10 };
		assertEquals(2, largestSubarray.subarrayWithDuplicates(a));
	}

}
