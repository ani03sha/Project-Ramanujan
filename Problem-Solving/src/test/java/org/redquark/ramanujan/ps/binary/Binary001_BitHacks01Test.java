package org.redquark.ramanujan.ps.binary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class Binary001_BitHacks01Test {

	private Binary001_BitHacks01 bitHacks = new Binary001_BitHacks01();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary001_BitHacks01#isEvenOrOdd(int)}.
	 */
	@Test
	void testIsEvenOrOdd() {
		assertEquals("Odd", bitHacks.isEvenOrOdd(7));
		assertEquals("Even", bitHacks.isEvenOrOdd(-8));
		assertEquals("Odd", bitHacks.isEvenOrOdd(Integer.MAX_VALUE));
		assertEquals("Even", bitHacks.isEvenOrOdd(Integer.MIN_VALUE));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary001_BitHacks01#haveOppositeSigns(int, int)}.
	 */
	@Test
	void testHaveOppositeSigns() {
		assertTrue(bitHacks.haveOppositeSigns(9, -8));
		assertTrue(bitHacks.haveOppositeSigns(-9, 8));
		assertFalse(bitHacks.haveOppositeSigns(-9, -8));
		assertFalse(bitHacks.haveOppositeSigns(9, 8));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary001_BitHacks01#addOne(int)}.
	 */
	@Test
	void testAddOne() {
		assertEquals(5, bitHacks.addOne(4));
		assertEquals(Integer.MIN_VALUE, bitHacks.addOne(Integer.MAX_VALUE));
		assertEquals(0, bitHacks.addOne(-1));
		assertEquals(-7, bitHacks.addOne(-8));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.ps.binary.Binary001_BitHacks01#swap(int[])}.
	 */
	@Test
	void testSwap() {
		int[] a = new int[] { 4, 3 };
		int[] expected = new int[] { 3, 4 };
		assertArrayEquals(expected, bitHacks.swap(a));
	}

}
