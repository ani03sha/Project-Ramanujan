package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _008RadixSortTest {

	private _008RadixSort radixSort = new _008RadixSort();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._008RadixSort#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] numbers = { 387, 468, 134, 123, 68, 221, 769, 37, 7 };
		radixSort.sort(numbers);
		int[] numbersSorted = { 7, 37, 68, 123, 134, 221, 387, 468, 769 };
		assertArrayEquals(numbersSorted, numbers);
	}

}
