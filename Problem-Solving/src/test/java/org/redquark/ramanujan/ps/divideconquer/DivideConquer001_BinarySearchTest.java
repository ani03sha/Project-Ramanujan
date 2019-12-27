package org.redquark.ramanujan.ps.divideconquer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class DivideConquer001_BinarySearchTest {

	private DivideConquer001_BinarySearch search = new DivideConquer001_BinarySearch();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.divideconquer.DivideConquer001_BinarySearch#searchIteratively(int[], int)}.
	 */
	@Test
	void testSearchIteratively() {
		int[] a = new int[] { 10, 30, 50, 70, 90, 110, 130, 150 };
		int key = 50;
		assertEquals(2, search.searchIteratively(a, key));

		key = 150;
		assertEquals(7, search.searchIteratively(a, key));

		key = 60;
		assertEquals(-1, search.searchIteratively(a, key));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.divideconquer.DivideConquer001_BinarySearch#searchRecursively(int[], int, int, int)}.
	 */
	@Test
	void testSearchRecursively() {
		int[] a = new int[] { 10, 30, 50, 70, 90, 110, 130, 150 };
		int key = 50;
		assertEquals(2, search.searchRecursively(a, key, 0, a.length - 1));

		key = 150;
		assertEquals(7, search.searchIteratively(a, key));

		key = 60;
		assertEquals(-1, search.searchIteratively(a, key));
	}

}
