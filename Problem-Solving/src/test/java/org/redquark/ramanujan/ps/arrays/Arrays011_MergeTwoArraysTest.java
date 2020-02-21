package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays011_MergeTwoArraysTest {

	private Arrays011_MergeTwoArrays mergeArrays = new Arrays011_MergeTwoArrays();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays011_MergeTwoArrays#mergeSorted(int[], int[])}.
	 */
	@Test
	void testMergeSorted() {
		// Vacant cells in X[] is represented by 0
		int a[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
		int b[] = { 1, 8, 9, 10, 15 };
		int[] expected = { 1, 2, 3, 5, 6, 8, 9, 10, 15 };
		assertArrayEquals(expected, mergeArrays.mergeSorted(a, b));
	}

}
