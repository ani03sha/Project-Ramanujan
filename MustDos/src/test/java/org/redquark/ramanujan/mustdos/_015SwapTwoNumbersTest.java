package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _015SwapTwoNumbersTest {

	private _015SwapTwoNumbers swapping = new _015SwapTwoNumbers();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._015SwapTwoNumbers#swap(int[])}.
	 */
	@Test
	void testSwap() {
		int[] a = new int[] { -1, 1 };
		int[] expected = new int[] { 1, -1 };
		assertArrayEquals(expected, swapping.swap(a));

		a = new int[] { 0, 1 };
		expected = new int[] { 1, 0 };
		assertArrayEquals(expected, swapping.swap(a));

		a = new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
		expected = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
		assertArrayEquals(expected, swapping.swap(a));
	}

}
