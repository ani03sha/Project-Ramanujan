package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _002InsertionSortTest {
	
	private _002InsertionSort insertionSort = new _002InsertionSort();

	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._002InsertionSort#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] a = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, insertionSort.sort(a));

		a = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		expected = new int[] { 11, 12, 22, 25, 34, 64, 90 };
		assertArrayEquals(expected, insertionSort.sort(a));
	}

}
