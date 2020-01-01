package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _006BucketSortTest {
	
	private _006BucketSort bucketSort = new _006BucketSort();

	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._006BucketSort#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] a = new int[] { 0, 5, 9, 2, 1, 3, 4, 8, 6, 7 };
		int[] expected = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(expected, bucketSort.sort(a));

		a = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		expected = new int[] { 11, 12, 22, 25, 34, 64, 90 };
		assertArrayEquals(expected, bucketSort.sort(a));
	}

}
