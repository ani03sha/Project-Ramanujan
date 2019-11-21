package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {
	
	private DynamicArray da;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the instance
		da = new DynamicArray();
		// Adding some data
		da.add(1);
		da.add(2);
		da.add(3);
		da.add(4);
		da.add(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		da = null;
	}

	@Test
	void testAdd() {
		da.add(6);
		assertEquals("[1, 2, 3, 4, 5, 6, 0, 0]", Arrays.toString(da.array));
		da.add(7);
		da.add(8);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(da.array));
		da.add(9);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0]", Arrays.toString(da.array));
	}

	@Test
	void testAddAt() {
		da.addAt(3, 9);
		assertEquals("[1, 2, 3, 9, 4, 5, 0, 0]", Arrays.toString(da.array));
		da.addAt(4, 10);
		da.addAt(5, 11);
		da.addAt(6, 12);
		assertEquals("[1, 2, 3, 9, 10, 11, 12, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0]", Arrays.toString(da.array));
	}

	@Test
	void testRemove() {
		da.remove();
		assertEquals("[1, 2, 3, 4, 0, 0, 0, 0]", Arrays.toString(da.array));
		da.remove();
		assertEquals("[1, 2, 3, 0, 0, 0, 0, 0]", Arrays.toString(da.array));
	}

	@Test
	void testRemoveAt() {
		da.removeAt(2);
		assertEquals("[1, 2, 4, 5, 0, 0, 0, 0]", Arrays.toString(da.array));
	}
}
