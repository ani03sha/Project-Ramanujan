package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class _025FindKthNodeFromEndTest {

	private _025FindKthNodeFromEnd list;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the singly linked list
		list = new _025FindKthNodeFromEnd();
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	void testGtNthFromLast() {
		assertNull(list.gtNthFromLast(0));
		// Adding some elements in the list
		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		list.add(Integer.valueOf(3));
		list.add(Integer.valueOf(4));

		assertEquals(3, list.gtNthFromLast(3).data);
		assertEquals(1, list.gtNthFromLast(1).data);
		assertThrows(IllegalArgumentException.class, () -> {
			assertEquals(3, list.gtNthFromLast(5).data);
		});
	}

}
