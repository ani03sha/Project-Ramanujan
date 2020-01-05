package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _011OccurrenceOfGivenCharacterTest {
	
	private _011OccurrenceOfGivenCharacter count = new _011OccurrenceOfGivenCharacter();

	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._011OccurrenceOfGivenCharacter#countOccurrences(java.lang.String, char)}.
	 */
	@Test
	void testCountOccurrences() {
		assertEquals(3, count.countOccurrences("OneDayIWillBeGreat", 'e'));
		assertEquals(5, count.countOccurrences("javaisthebestprogramminglanguage", 'a'));
		assertEquals(2, count.countOccurrences("practice makes a man perfect", 'p'));
		assertEquals(0, count.countOccurrences("A friend in need is a friend indeed", 'x'));
	}

}
