package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _003SelectionSortTest {

	private _003SelectionSort selectionSort = new _003SelectionSort();
	
	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._003SelectionSort#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] a = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, selectionSort.sort(a));

		a = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		expected = new int[] { 11, 12, 22, 25, 34, 64, 90 };
		assertArrayEquals(expected, selectionSort.sort(a));
	}

}
