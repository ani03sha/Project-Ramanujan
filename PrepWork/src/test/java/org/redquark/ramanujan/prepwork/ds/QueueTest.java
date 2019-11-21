package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	
	private Queue<Integer> queue;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the object
		queue = new Queue<>();
		
		// Adding some data
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	@Test
	void testIsEmpty() {
		assertFalse(queue.isEmpty());
		queue.clear();
		assertTrue(queue.isEmpty());
		queue.enqueue(6);
		assertFalse(queue.isEmpty());
		queue.clear();
		assertTrue(queue.isEmpty());
	}

	@Test
	void testIsFull() {
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		
		assertTrue(queue.isFull());
		
		queue.dequeue();
		
		assertFalse(queue.isFull());
	}

	@Test
	void testEnqueue() {
		assertFalse(queue.isFull());
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		assertTrue(queue.isFull());
		queue.enqueue(11);
		assertFalse(queue.isFull());
	}

	@Test
	void testDequeue() {
		queue.dequeue();
		assertEquals(2, queue.getFront());
		queue.dequeue();
		queue.dequeue();
		assertEquals(4, queue.getFront());
	}

	@Test
	void testClear() {
		assertFalse(queue.isEmpty());
		queue.clear();
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		assertThrows(RuntimeException.class, () -> {
			queue.getFront();
		});
	}

	@Test
	void testGetFront() {
		assertEquals(1, queue.getFront());
		queue.dequeue();
		queue.dequeue();
		assertEquals(3, queue.getFront());
		queue.clear();
		assertThrows(RuntimeException.class, () -> {
			queue.getFront();
		});
	}

	@Test
	void testIterator() {
		Iterator<Integer> iterator = queue.iterator();
		List<Integer> tempList = new ArrayList<>();
		while(iterator.hasNext()) {
			tempList.add(iterator.next());
		}
		List<Integer> itemsFromQueue = new ArrayList<>();
		while(iterator.hasNext()) {
			itemsFromQueue.add(queue.getFront());
			queue.dequeue();
		}
		
		assertTrue(tempList.containsAll(itemsFromQueue));
		
		assertThrows(UnsupportedOperationException.class, () -> {
			iterator.remove();
		});
	}

}
