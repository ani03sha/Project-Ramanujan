package org.redquark.ramanujan.ps.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Arrays005_FindDuplicateInArrayTest {

	private Arrays005_FindDuplicateInArray findDuplicate = new Arrays005_FindDuplicateInArray();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.arrays.Arrays005_FindDuplicateInArray#findDuplicate(int[])}.
	 */
	@Test
	void testFindDuplicate() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 2 };
		assertEquals(2, findDuplicate.findDuplicate(a));

		a = new int[] { 1, 2, 3, 4, 5, 6, 4, 7 };
		assertEquals(4, findDuplicate.findDuplicate(a));
	}

}
