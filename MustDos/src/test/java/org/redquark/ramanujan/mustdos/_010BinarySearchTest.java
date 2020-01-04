package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _010BinarySearchTest {

	private _010BinarySearch binarySearch = new _010BinarySearch();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._010BinarySearch#search(int[], int)}.
	 */
	@Test
	void testSearch() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int key = 8;
		assertEquals(7, binarySearch.search(a, key));

		a = new int[] { 20, 40, 60, 80, 100, 120 };
		key = 60;
		assertEquals(2, binarySearch.search(a, key));

		a = new int[] { 5, 8, 9, 11, 15, 79 };
		key = 45;
		assertEquals(-1, binarySearch.search(a, key));
	}

}
