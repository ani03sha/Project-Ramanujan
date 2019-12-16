package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		assertNull(findPair.findPair(a, sum));

		a = new int[] { 4, 5, 9, 1, 3, 10 };
		sum = 21;
		expected = new int[] { 0, 0 };
		actual = findPair.findPair(actual, sum);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays001_FindPairWithGivenSum#findAllPairs(int[], int)}.
	 */
	@Test
	void testFindAllPairs() {
		int[] a = new int[] { 2, 3, 4, -2, 6, 8, 9, 11 };
		int sum = 6;
		List<Integer[]> expected = new ArrayList<>();
		expected.add(new Integer[] { 0, 2 });
		expected.add(new Integer[] { 3, 5 });
		List<Integer[]> actual = findPair.findAllPairs(a, sum);
		List<List<Integer>> finalExpected = expected.stream().map(Arrays::asList).collect(Collectors.toList());
		List<List<Integer>> finalActual = actual.stream().map(Arrays::asList).collect(Collectors.toList());
		assertTrue(finalExpected.equals(finalActual));
		
		a = new int[] {};
		sum = 10;
		assertNull(findPair.findAllPairs(a, sum));
	}
}
