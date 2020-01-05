package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _014ReverseAnArrayTest {

	private _014ReverseAnArray reverseArray = new _014ReverseAnArray();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._014ReverseAnArray#reverse(int[])}.
	 */
	@Test
	void testReverse() {
		int[] a = new int[] { 5, 4, 3, 2, 1 };
		int[] expected = new int[] { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, reverseArray.reverse(a));
		
		a = new int[] {1, 1, 1};
		expected = new int[] {1, 1, 1};
		assertArrayEquals(expected, reverseArray.reverse(a));
	}

}
