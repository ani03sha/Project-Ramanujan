package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _023MaximumOccurringCharacterTest {

	private _023MaximumOccurringCharacter maxOccurringCharacter = new _023MaximumOccurringCharacter();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._023MaximumOccurringCharacter#maximumOccurringCharacter(java.lang.String)}.
	 */
	@Test
	void testMaximumOccurringCharacter() {
		assertEquals('t', maxOccurringCharacter.maximumOccurringCharacter("test"));
		assertEquals('s', maxOccurringCharacter.maximumOccurringCharacter("Sample       string"));
		assertEquals('c', maxOccurringCharacter.maximumOccurringCharacter("cbbbbCcCc"));
	}

}
