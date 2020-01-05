package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _012FirstNonRepeatingCharacterTest {

	private _012FirstNonRepeatingCharacter nonRepeatingCharacter = new _012FirstNonRepeatingCharacter();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._012FirstNonRepeatingCharacter#findFirstFirstNonRepeatingCharacter(java.lang.String)}.
	 */
	@Test
	void testFindFirstFirstNonRepeatingCharacter() {
		assertEquals('n', nonRepeatingCharacter.findFirstFirstNonRepeatingCharacter("Anirudh is awesome"));
		assertEquals('p', nonRepeatingCharacter
				.findFirstFirstNonRepeatingCharacter("Help is always given at Hogwarts to those who ask for it"));
		assertEquals('d', nonRepeatingCharacter.findFirstFirstNonRepeatingCharacter(
				"One day in restrospect the years of struggle will strike you as the most beautiful"));
		assertEquals('d', nonRepeatingCharacter.findFirstFirstNonRepeatingCharacter("Dance rhytm"));
	}

}
