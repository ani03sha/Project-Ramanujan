package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays010_InPlaceMergeSortedArraysTest {

	private Arrays010_InPlaceMergeSortedArrays inplaceMerging = new Arrays010_InPlaceMergeSortedArrays();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays010_InPlaceMergeSortedArrays#inplaceMerging(int[], int[])}.
	 */
	@Test
	void testInplaceMerging() {
		int[] a = new int[] { 1, 5, 9, 10, 15, 20 };
		int[] b = new int[] { 2, 3, 8, 13 };
		int[][] expected = new int[][] { { 1, 2, 3, 5, 8, 9 }, { 10, 13, 15, 20 } };
		assertArrayEquals(expected, inplaceMerging.inplaceMerging(a, b));

		a = new int[] { 1, 4, 7, 8, 10 };
		b = new int[] { 2, 3, 9 };
		expected = new int[][] { { 1, 2, 3, 4, 7 }, { 8, 9, 10 } };
		assertArrayEquals(expected, inplaceMerging.inplaceMerging(a, b));
	}

}
