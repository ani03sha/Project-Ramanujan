package org.redquark.ramanujan.prepwork.algo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class BinarySearchTest {

	private BinarySearch binarySearch = new BinarySearch();
	
	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.algo.BinarySearch#search(T[], java.lang.Comparable)}.
	 */
	@Test
	void testSearch() {
		
		Integer[] integerArray = {6, 16, 21, 27, 38, 49, 59, 66, 72, 83, 89, 94, 97};
		Arrays.sort(integerArray);
		assertEquals(-1, binarySearch.search(integerArray, 88));
		assertEquals(5, binarySearch.search(integerArray, 49));
		assertEquals(9, binarySearch.search(integerArray, 83));
		
		Character[] charArray = {'a', 'd', 'g', 'k', 'n', 'p', 'r', 'u', 'y'};
		Arrays.sort(charArray);
		assertEquals(-1, binarySearch.search(charArray, 'm'));
		assertEquals(5, binarySearch.search(charArray, 'p'));
		assertEquals(1, binarySearch.search(charArray, 'd'));
	}

}
