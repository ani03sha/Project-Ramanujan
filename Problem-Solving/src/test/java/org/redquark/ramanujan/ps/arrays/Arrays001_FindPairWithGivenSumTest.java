package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays001_FindPairWithGivenSumTest {

	private Arrays001_FindPairWithGivenSum findPair = new Arrays001_FindPairWithGivenSum();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays001_FindPairWithGivenSum#findPair(int[], int)}.
	 */
	@Test
	void testFindPair() {
		int[] a = new int[] { 1, 5, 6, 12, 3, 14 };
		int sum = 9;
		int[] expected = new int[] { 2, 4 };
		int[] actual = findPair.findPair(a, sum);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);

		a = new int[] {};
		sum = 10;
		expected = new int[] { 0, 0 };
		actual = findPair.findPair(actual, sum);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);

		a = new int[] { 4, 5, 9, 1, 3, 10 };
		sum = 21;
		expected = new int[] { 0, 0 };
		actual = findPair.findPair(actual, sum);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);

	}

}
