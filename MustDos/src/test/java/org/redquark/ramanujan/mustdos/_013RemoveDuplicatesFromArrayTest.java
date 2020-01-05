package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _013RemoveDuplicatesFromArrayTest {

	private _013RemoveDuplicatesFromArray removeDuplicates = new _013RemoveDuplicatesFromArray();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._013RemoveDuplicatesFromArray#removeDuplicates(int[])}.
	 */
	@Test
	void testRemoveDuplicates() {
		int[] a = new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int[] expected = new int[] { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, removeDuplicates.removeDuplicates(a));

		a = new int[] { 1, 1, 1, 1, 1, 1 };
		expected = new int[] { 1 };
		assertArrayEquals(expected, removeDuplicates.removeDuplicates(a));

		a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		expected = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected, removeDuplicates.removeDuplicates(a));

		a = new int[] { 1, 2, 1, 1, 1, 1, 1 };
		expected = new int[] { 1, 2 };
		assertArrayEquals(expected, removeDuplicates.removeDuplicates(a));
		
		a = new int[] { 1 };
		expected = new int[] { 1 };
		assertArrayEquals(expected, removeDuplicates.removeDuplicates(a));
	}

}
