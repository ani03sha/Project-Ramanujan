package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _026CheckPalindromeTest {

	private _026CheckPalindrome checkPalindrome = new _026CheckPalindrome();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._026CheckPalindrome#isPalindrome(java.lang.String)}.
	 */
	@Test
	void testIsPalindrome() {
		assertTrue(checkPalindrome.isPalindrome("aba"));
		assertFalse(checkPalindrome.isPalindrome("anirudh"));
		assertTrue(checkPalindrome.isPalindrome("A man, a plan, a canal, Panama!"));
		assertTrue(checkPalindrome.isPalindrome("Was it a car or a cat I saw?"));
		assertTrue(checkPalindrome.isPalindrome("Never odd or even"));
	}

}
