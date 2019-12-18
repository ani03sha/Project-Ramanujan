package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.ps.arrays.Arrays003_AllPairsWithZeroSum.Pair;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays003_AllPairsWithZeroSumTest {

	private Arrays003_AllPairsWithZeroSum zeroPairs = new Arrays003_AllPairsWithZeroSum();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays003_AllPairsWithZeroSum#findPairs(int[])}.
	 */
	@Test
	void testFindPairs() {
		int[] a = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		List<Pair> expected = zeroPairs.findPairs(a);
		assertEquals(5, expected.size());

		Pair pair = expected.get(0);
		assertEquals(2, pair.getStart());
		assertEquals(4, pair.getEnd());

		pair = expected.get(1);
		assertEquals(2, pair.getStart());
		assertEquals(6, pair.getEnd());

		pair = expected.get(2);
		assertEquals(5, pair.getStart());
		assertEquals(6, pair.getEnd());

		pair = expected.get(3);
		assertEquals(6, pair.getStart());
		assertEquals(9, pair.getEnd());

		pair = expected.get(4);
		assertEquals(0, pair.getStart());
		assertEquals(10, pair.getEnd());

	}

}
