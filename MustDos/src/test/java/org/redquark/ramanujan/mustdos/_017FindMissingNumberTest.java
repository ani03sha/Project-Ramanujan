package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _017FindMissingNumberTest {

	private _017FindMissingNumber findMissingNumber = new _017FindMissingNumber();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._017FindMissingNumber#findMissing(int[], int)}.
	 */
	@Test
	void testFindMissing() {
		int[] a = new int[] { 1, 2, 4, 5, 6 };
		assertEquals(3, findMissingNumber.findMissing(a, a.length));

		a = new int[] { 1, 3, 4, 5, 6, 7, 8 };
		assertEquals(2, findMissingNumber.findMissing(a, a.length));
	}

}
