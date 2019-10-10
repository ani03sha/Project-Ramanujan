package org.redquark.ramanujan.prepwork.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class QuickSortTest {

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.algo.QuickSort#sort(T[], int, int)}.
	 */
	@Test
	void testSort() {

		QuickSort quickSort = new QuickSort();

		Integer[] unsortedInt = new Integer[] { 0, 5, 9, 2, 1, 3, 4, 8, 6, 7 };
		Integer[] sortedInt = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(sortedInt, quickSort.sort(unsortedInt, 0, unsortedInt.length - 1));

		unsortedInt = new Integer[] { 5, 4, 3, 2, 1, 0 };
		sortedInt = new Integer[] { 0, 1, 2, 3, 4, 5 };
		assertArrayEquals(sortedInt, quickSort.sort(unsortedInt, 0, unsortedInt.length - 1));

		unsortedInt = new Integer[] { -1, -2, -3, -4, -5 };
		sortedInt = new Integer[] { -5, -4, -3, -2, -1 };
		assertArrayEquals(sortedInt, quickSort.sort(unsortedInt, 0, unsortedInt.length - 1));

		unsortedInt = new Integer[] { -1, -5, -10, -990, 990, 1010 };
		sortedInt = new Integer[] { -990, -10, -5, -1, 990, 1010 };
		assertArrayEquals(sortedInt, quickSort.sort(unsortedInt, 0, unsortedInt.length - 1));
	}

}
