package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.mustdos._022ArrayPairSum.Pair;

/**
 * @author Anirudh Sharma
 *
 */
class _022ArrayPairSumTest {

	private _022ArrayPairSum pairSum = new _022ArrayPairSum();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._022ArrayPairSum#findPairs(int[], int)}.
	 */
	@Test
	void testFindPairs() {
		int[] a = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
		Set<Pair> expected = new HashSet<>();
		expected.add(new Pair(1, 5));
		expected.add(new Pair(7, -1));
		assertTrue(expected.equals(pairSum.findPairs(a, sum)));

		a = new int[] { 2, 5, 17, -1 };
		sum = 7;
		expected = new HashSet<>();
		expected.add(new Pair(2, 5));
		assertTrue(expected.equals(pairSum.findPairs(a, sum)));
	}

}
