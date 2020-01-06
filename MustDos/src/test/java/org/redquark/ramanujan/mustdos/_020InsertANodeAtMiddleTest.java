package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.mustdos._020InsertANodeAtMiddle.Node;

/**
 * @author Anirudh Sharma
 *
 */
class _020InsertANodeAtMiddleTest {

	private _020InsertANodeAtMiddle list;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the singly linked list
		list = new _020InsertANodeAtMiddle();

		// Adding some elements in the list
		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		list.add(Integer.valueOf(3));
		list.add(Integer.valueOf(4));
		list.add(Integer.valueOf(5));
		list.add(Integer.valueOf(7));
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._020InsertANodeAtMiddle#insert(int)}.
	 */
	@Test
	void testInsert() {
		StringBuilder actual = new StringBuilder();
		Node head = list.insert(6);
		while (head != null) {
			actual.append(head.data).append(" ");
			head = head.next;
		}
		StringBuilder expected = new StringBuilder();
		expected.append("7 5 4 6 3 2 1 ");
		assertEquals(expected.toString(), actual.toString());
	}

}
