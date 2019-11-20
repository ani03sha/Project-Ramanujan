package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class BinarySearchTreeTest {

	private BinarySearchTree<Integer> bst;

	@BeforeEach
	void setUp() throws Exception {
		// Creating a new instance of BST
		bst = new BinarySearchTree<>();

		// Adding some elements in the BST
		bst.insert(3);
		bst.insert(7);
		bst.insert(4);
		bst.insert(8);
		bst.insert(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Nullifying the reference to make it eligible for Garbage collection
		bst = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#search(java.lang.Comparable)}.
	 */
	@Test
	void testSearch() {
		assertTrue(bst.search(7));
		assertFalse(bst.search(2));
		bst.insert(2);
		assertTrue(bst.search(2));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#insert(java.lang.Comparable)}.
	 */
	@Test
	void testInsert() {
		bst.insert(2);
		assertTrue(bst.search(2));
		bst.insert(9);
		assertTrue(bst.search(9));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#delete(java.lang.Comparable)}.
	 */
	@Test
	void testDelete() {
		bst.delete(3);
		assertFalse(bst.search(3));
		bst.delete(1);
		assertFalse(bst.search(1));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#preOrderTraversal()}.
	 */
	@Test
	void testPreOrderTraversal() {
		assertEquals("3 1 7 4 8 ", bst.preOrderTraversal());
		bst.insert(2);
		bst.insert(5);
		assertEquals("3 1 2 7 4 5 8 ", bst.preOrderTraversal());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#inOrderTraversal()}.
	 */
	@Test
	void testInOrderTraversal() {
		assertEquals("1 3 4 7 8 ", bst.inOrderTraversal());
		bst.insert(2);
		bst.insert(5);
		assertEquals("1 2 3 4 5 7 8 ", bst.inOrderTraversal());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#postOrderTraversal()}.
	 */
	@Test
	void testPostOrderTraversal() {
		assertEquals("1 4 8 7 3 ", bst.postOrderTraversal());
		bst.insert(2);
		bst.insert(5);
		assertEquals("2 1 5 4 8 7 3 ", bst.postOrderTraversal());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#levelOrderTraversal()}.
	 */
	@Test
	void testLevelOrderTraversal() {
		assertEquals("3 1 7 4 8 ", bst.levelOrderTraversal());
		bst.insert(2);
		bst.insert(5);
		assertEquals("3 1 7 2 4 8 5 ", bst.levelOrderTraversal());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#height()}.
	 */
	@Test
	void testHeight() {
		assertEquals(3, bst.height());
		bst.insert(2);
		bst.insert(9);
		bst.insert(11);
		assertEquals(5, bst.height());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#countLeaves()}.
	 */
	@Test
	void testCountLeaves() {
		assertEquals(3, bst.countLeaves());
		bst.insert(2);
		bst.insert(9);
		bst.insert(11);
		assertEquals(3, bst.countLeaves());
		bst.delete(11);
		assertEquals(3, bst.countLeaves());
		bst.insert(-1);
		assertEquals(4, bst.countLeaves());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#width()}.
	 */
	@Test
	void testWidth() {
		assertEquals(3, bst.width());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#diameter()}.
	 */
	@Test
	void testDiameter() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#restore(T[], T[])}.
	 */
	@Test
	void testRestore() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#clone()}.
	 */
	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

}
