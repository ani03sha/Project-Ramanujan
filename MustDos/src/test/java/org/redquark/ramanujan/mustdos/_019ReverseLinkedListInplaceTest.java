package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.mustdos._019ReverseLinkedListInplace.Node;

/**
 * @author Anirudh Sharma
 *
 */
class _019ReverseLinkedListInplaceTest {

	private _019ReverseLinkedListInplace list;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the singly linked list
		list = new _019ReverseLinkedListInplace();

		// Adding some elements in the list
		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		list.add(Integer.valueOf(3));
		list.add(Integer.valueOf(4));
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._019ReverseLinkedListInplace#reverse()}.
	 */
	@Test
	void testReverse() {
		StringBuilder actual = new StringBuilder();
		Node head = list.reverse();
		while (head != null) {
			actual.append(head.data).append(" ");
			head = head.next;
		}
		StringBuilder expected = new StringBuilder();
		expected.append("1 2 3 4 ");
		assertEquals(expected.toString(), actual.toString());
	}

}
