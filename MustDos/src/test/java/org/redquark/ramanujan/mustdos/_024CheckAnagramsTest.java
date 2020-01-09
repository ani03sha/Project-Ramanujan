package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _024CheckAnagramsTest {

	private _024CheckAnagrams anagrams = new _024CheckAnagrams();
	
	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._024CheckAnagrams#areAnagrams(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAreAnagrams() {
		assertTrue(anagrams.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
		assertFalse(anagrams.areAnagrams("test", "ttew"));
	}

}
