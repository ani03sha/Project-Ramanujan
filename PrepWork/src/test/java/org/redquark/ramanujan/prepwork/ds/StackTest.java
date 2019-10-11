package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class StackTest {

	// Creating an instance of the Stack class
	private Stack<Integer> stack = new Stack<>();

	@BeforeEach
	void setUp() throws Exception {
		// Added some elements in the stack
		stack.push(Integer.valueOf(1));
		stack.push(Integer.valueOf(2));
		stack.push(Integer.valueOf(3));
		stack.push(Integer.valueOf(4));
		stack.push(Integer.valueOf(5));
	}

	@AfterEach
	void tearDown() throws Exception {
		// Referencing to null
		stack = null;
	}

	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.ds.Stack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertFalse(stack.isEmpty());
		// Clearing stack
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.ds.Stack#clear()}.
	 */
	@Test
	void testClear() {
		assertNotEquals(stack.toString(), "[]");
		stack.clear();
		assertEquals(stack.toString(), "[]");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Stack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		assertEquals(stack.toString(), "5 4 3 2 1 ");
		// Adding few elements
		stack.push(Integer.valueOf(6));
		stack.push(Integer.valueOf(7));
		assertEquals(stack.toString(), "7 6 5 4 3 2 1 ");
	}

	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.ds.Stack#pop()}.
	 */
	@Test
	void testPop() {
		assertEquals(stack.pop(), Integer.valueOf(5));
		assertEquals(stack.pop(), Integer.valueOf(4));

		// Clear the stack
		stack.clear();
		assertThrows(RuntimeException.class, () -> {
			stack.pop();
		});
	}

	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.ds.Stack#peek()}.
	 */
	@Test
	void testPeek() {
		assertEquals(stack.peek(), Integer.valueOf(5));
		assertEquals(stack.peek(), Integer.valueOf(5));
		stack.push(Integer.valueOf(6));
		assertEquals(stack.peek(), Integer.valueOf(6));

		// Clear the stack
		stack.clear();
		assertThrows(RuntimeException.class, () -> {
			stack.peek();
		});
	}

}
