package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays009_DutchNationalFlagProblemTest {

	private Arrays009_DutchNationalFlagProblem dnf = new Arrays009_DutchNationalFlagProblem();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays009_DutchNationalFlagProblem#sort(int[])}.
	 */
	@Test
	void testSort() {
		int[] a = new int[] { 1, 0, 2, 0, 0, 1, 1, 2, 1, 2, 0, 2, 1, 2, 0 };
		int[] expected = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 };
		assertArrayEquals(expected, dnf.sort(a));
	}

}
