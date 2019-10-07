package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Anirudh Sharma
 * @param <T>
 *
 */
public class SinglyLinkedListTest<T> {

	// Instance of the SinglyLinkedList
	SinglyLinkedList<Integer> list;

	@Before
	public void setUp() throws Exception {
		// Initializing the singly linked list
		list = new SinglyLinkedList<>();

		// Adding some elements in the list
		list.addFirst(Integer.valueOf(1));
		list.addFirst(Integer.valueOf(2));
		list.addFirst(Integer.valueOf(3));
		list.addFirst(Integer.valueOf(4));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		// Removing all the elements from the list
		list.clear();
		// Since we are calling this method just after clearing it, there are no
		// elements in it as of now
		assertTrue(list.isEmpty());

		// Adding some elements in the list - so the list is no longer empty
		list.addFirst(Integer.valueOf(1));
		assertFalse(list.isEmpty());

	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#addFirst(java.lang.Object)}.
	 */
	@Test
	public void testAddFirst() {
		// Adding some elements to the list. They will be added at the front of the
		// existing list.
		// Therefore if we add 1, 2, 3, 4 in this order our list would be 4 => 3 => 2 =>
		// 1
		list.addFirst(Integer.valueOf(5));

		assertEquals(list.toString(), "5 4 3 2 1 ");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirst() {
		// This test case will check if the first element returned by the list is
		// correct or not
		assertEquals(list.getFirst(), Integer.valueOf(4));

		// Adding another element in the list
		list.addFirst(5);
		assertEquals(list.getFirst(), Integer.valueOf(5));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		// This test case will check if the first element removed correctly or not
		assertEquals(list.removeFirst(), Integer.valueOf(4));
		// Since the first element is already removed, lets remove one more element
		assertEquals(list.removeFirst(), Integer.valueOf(3));
		// Remove some more elements
		list.removeFirst();
		list.removeFirst();
		// Check if the list is empty or not
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#addLast(java.lang.Object)}.
	 */
	@Test
	public void testAddLast() {
		// This test case will check if the element is correctly added to the end of the
		// linked list or not
		list.addLast(Integer.valueOf(5));
		assertEquals(list.toString(), "4 3 2 1 5 ");
		// Now we clear the list, so the element added will be the first element in the
		// list or the head
		list.clear();
		list.addLast(Integer.valueOf(6));
		assertEquals(list.getFirst(), Integer.valueOf(6));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#getLast()}.
	 */
	@Test
	public void testGetLast() {
		// This test case will check if the last element returned by list is correct or
		// not
		assertEquals(list.getLast(), Integer.valueOf(1));
		// Remove the last element
		list.removeLast();
		assertEquals(list.getLast(), Integer.valueOf(2));
		// Add two elements to the last
		list.addLast(Integer.valueOf(5));
		list.addLast(Integer.valueOf(6));
		assertEquals(list.getLast(), Integer.valueOf(6));
		// Clear the list and then try to get the last element
		list.clear();
		assertThrows(NoSuchElementException.class, () -> {
			list.getLast();
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLast() {
		// This test case checks if the last element removed from the list is correct or
		// not
		assertEquals(list.removeLast(), Integer.valueOf(1));
		assertEquals(list.toString(), "4 3 2 ");
		// Remove one more element from the last
		assertEquals(list.removeLast(), Integer.valueOf(2));
		assertEquals(list.toString(), "4 3 ");
		// Clearing the list and then trying to remove the last element in the list
		list.clear();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeLast();
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#insertAfter(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testInsertAfter() {
		// This test case will check if the element is inserted at the correct place or
		// not
		list.insertAfter(Integer.valueOf(2), Integer.valueOf(5));
		assertEquals(list.toString(), "4 3 2 5 1 ");
		// Do this one more time
		list.insertAfter(Integer.valueOf(4), Integer.valueOf(6));
		assertEquals(list.toString(), "4 6 3 2 5 1 ");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#insertBefore(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testInsertBefore() {
		// This test case checks if the new element is added before the specified
		// element correctly or not
		list.insertBefore(Integer.valueOf(1), Integer.valueOf(5));
		assertEquals(list.toString(), "4 3 2 5 1 ");
		// Do this one more time
		list.insertBefore(Integer.valueOf(5), Integer.valueOf(6));
		assertEquals(list.toString(), "4 3 2 6 5 1 ");
		// Check when the element has to be inserted before the head
		list.insertBefore(list.getFirst(), Integer.valueOf(7));
		assertEquals(list.getFirst(), Integer.valueOf(7));
		// Clearing the list and then try to add element before a list which is not
		// present
		list.clear();
		assertThrows(UnsupportedOperationException.class, () -> {
			list.insertBefore(Integer.valueOf(1), Integer.valueOf(2));
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		// This test case checks if the element specified is correctly removed or not
		list.remove(Integer.valueOf(3));
		assertEquals(list.toString(), "4 2 1 ");
		// Removing the head itself
		list.remove(Integer.valueOf(4));
		assertEquals(list.getFirst(), Integer.valueOf(2));
		// Trying to delete the node which is not present in the list
		assertThrows(RuntimeException.class, () -> {
			list.remove(Integer.valueOf(10));
		});
		// Removing the element from an empty list
		list.clear();
		assertThrows(RuntimeException.class, () -> {
			list.remove(Integer.valueOf(4));
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#clear()}.
	 */
	@Test
	public void testClear() {
		// This test case checks if the list is made empty or not
		list.clear();
		assertEquals(list.toString(), "");
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		// This test case checks if the specified key is present in the list or not
		assertTrue(list.contains(4));
		assertFalse(list.contains(0));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#get(int)}.
	 */
	@Test
	public void testGet() {
		// This test case checks if the value returned by the list at the specified
		// position is correct or not
		assertEquals(list.get(3), Integer.valueOf(1));
		// Trying to get an element at the position greater than the number of elements
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(5);
		});
		// Trying to get an element from an empty list
		list.clear();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(0);
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#reverse()}.
	 */
	@Test
	public void testReverse() {
		// This test case checks if the linked list is correctly reversed or not
		assertEquals(list.reverse().toString(), "1 2 3 4 ");
		assertNotEquals(list.reverse().toString(), "4 3 2 1 ");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#deepCopy()}.
	 */
	@Test
	public void testDeepCopy() {
		// This test case checks if the deep copy returned is correct or not
		assertEquals(list.deepCopy().toString(), "4 3 2 1 ");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		// Test case to check the size of the list
		assertEquals(list.size(), Integer.valueOf(4));
		// Adding some elements and then determine size
		list.addLast(Integer.valueOf(5));
		list.addLast(Integer.valueOf(6));
		assertEquals(list.size(), Integer.valueOf(6));
		// Removing some elements and then determine size
		list.removeLast();
		list.removeLast();
		list.removeLast();
		assertEquals(list.size(), Integer.valueOf(3));
		// Clear the list
		list.clear();
		assertEquals(list.size(), Integer.valueOf(0));
	}
	
	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.SinglyLinkedList#iterator()}.
	 */
	@Test
	public void testIterator() {
		// This test case checks for the iterator implementation
		assertTrue(list.iterator().hasNext());
		for (int i = 4; i > 0; i--) {
			assertEquals(list.iterator().next(), Integer.valueOf(i));
			list.removeFirst();
		}
		assertFalse(list.iterator().hasNext());
		// The below line will check the next element of the empty list - an exception
		// should be thrown
		assertThrows(NoSuchElementException.class, () -> {
			list.iterator().next();
		});
		// Test for the remove operation
		assertThrows(UnsupportedOperationException.class, () -> {
			list.iterator().remove();
		});
	}
	
	@After
	public void tearDown() {
		list = null;
	}

}
