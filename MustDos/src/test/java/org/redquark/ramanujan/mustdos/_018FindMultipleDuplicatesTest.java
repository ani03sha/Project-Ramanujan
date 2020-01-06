package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _018FindMultipleDuplicatesTest {

	private _018FindMultipleDuplicates duplicates = new _018FindMultipleDuplicates();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._018FindMultipleDuplicates#getDuplicates(int[])}.
	 */
	@Test
	void testGetDuplicates() {
		int[] a = new int[] { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> expected = Arrays.asList(2, 3);
		assertTrue(expected.equals(duplicates.getDuplicates(a)));

		a = new int[] { 1, 2, 3, 1, 3, 6, 6 };
		expected = Arrays.asList(1, 3, 6);
		assertTrue(expected.equals(duplicates.getDuplicates(a)));
	}

}
