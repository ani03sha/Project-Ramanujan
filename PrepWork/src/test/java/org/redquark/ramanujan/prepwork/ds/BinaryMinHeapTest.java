package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMinHeapTest {

	private BinaryMinHeap<Integer> bmh;
	private BinaryMinHeap<Integer> bmhWithArray;

	@BeforeEach
	void setUp() throws Exception {
		// Array having items to be stored in the Heap
		Integer[] items = { 6, 4, 7, 2, 9 };
		// Adding the array to the heap
		bmhWithArray = new BinaryMinHeap<>(items);
		bmh = new BinaryMinHeap<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		bmh = null;
		bmhWithArray = null;
	}

	@Test
	void testDeleteMinimum() {
		assertEquals(2, bmhWithArray.deleteMinimum());
		assertEquals(4, bmhWithArray.deleteMinimum());
		assertEquals(6, bmhWithArray.deleteMinimum());
		assertEquals(7, bmhWithArray.deleteMinimum());
		assertEquals(9, bmhWithArray.deleteMinimum());
		assertThrows(RuntimeException.class, () -> {
			bmhWithArray.deleteMinimum();
		});

		assertThrows(RuntimeException.class, () -> {
			bmh.deleteMinimum();
		});
	}

	@Test
	void testInsert() {
		// Add some value in the heap
		bmh.insert(25);
		bmh.insert(61);
		bmh.insert(12);
		bmh.insert(19);
		assertEquals("12 19 25 61 ", bmh.toString());

		assertEquals("2 4 7 6 9 ", bmhWithArray.toString());
		bmhWithArray.insert(3);
		assertEquals("2 4 3 6 9 7 ", bmhWithArray.toString());
	}

}
