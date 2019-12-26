package org.redquark.ramanujan.ps.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Binary002_BitHacks02Test {

	private Binary002_BitHacks02 bitHacks = new Binary002_BitHacks02();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary002_BitHacks02#turnOffKthBit(int, int)}.
	 */
	@Test
	void testTurnOffKthBit() {
		assertEquals("10000", bitHacks.turnOffKthBit(20, 3));
		assertEquals("1000", bitHacks.turnOffKthBit(8, 2));
		assertEquals("11", bitHacks.turnOffKthBit(11, 4));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary002_BitHacks02#turnOnKthBit(int, int)}.
	 */
	@Test
	void testTurnOnKthBit() {
		assertEquals("11100", bitHacks.turnOnKthBit(20, 4));
		assertEquals("1010", bitHacks.turnOnKthBit(8, 2));
		assertEquals("1011", bitHacks.turnOnKthBit(11, 4));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary002_BitHacks02#isKthBitSet(int, int)}.
	 */
	@Test
	void testIsKthBitSet() {
		assertTrue(bitHacks.isKthBitSet(20, 3));
		assertFalse(bitHacks.isKthBitSet(0, 2));
		assertTrue(bitHacks.isKthBitSet(16, 5));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary002_BitHacks02#toggleKthBit(int, int)}.
	 */
	@Test
	void testToggleKthBit() {
		assertEquals("11100", bitHacks.toggleKthBit(20, 4));
		assertEquals("1010", bitHacks.toggleKthBit(8, 2));
		assertEquals("11", bitHacks.toggleKthBit(11, 4));
	}

}
