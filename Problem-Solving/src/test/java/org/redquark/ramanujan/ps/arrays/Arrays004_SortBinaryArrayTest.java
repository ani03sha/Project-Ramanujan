package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays004_SortBinaryArrayTest {

	private Arrays004_SortBinaryArray sortBinaryArray = new Arrays004_SortBinaryArray();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays004_SortBinaryArray#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] a = new int[] { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
		int[] expected = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		assertArrayEquals(expected, sortBinaryArray.sort(a));

		a = new int[] { 1, 0, 0, 0, 1, 0, 1, 1 };
		expected = new int[] { 0, 0, 0, 0, 1, 1, 1, 1 };
		assertArrayEquals(expected, sortBinaryArray.sort(a));
	}

}
