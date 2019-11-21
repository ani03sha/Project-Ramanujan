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
		bst.insert(3);
		assertTrue(bst.search(3));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#delete(java.lang.Comparable)}.
	 */
	@Test
	void testDelete() {
		bst.insert(6);
		bst.insert(5);
		bst.delete(4);
		assertFalse(bst.search(4));
		bst.delete(1);
		assertFalse(bst.search(1));
		bst.delete(3);
		assertFalse(bst.search(3));
		bst.delete(7);
		assertFalse(bst.search(7));
		bst.delete(8);
		assertFalse(bst.search(8));
		
		assertThrows(RuntimeException.class, () -> {
			bst.delete(3);
		});
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
		assertEquals(2, bst.width());
		bst.insert(-2);
		assertEquals(3, bst.width());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#diameter()}.
	 */
	@Test
	void testDiameter() {
		assertEquals(4, bst.diameter());
		bst.insert(5);
		assertEquals(5, bst.diameter());
		bst.insert(6);
		assertEquals(6, bst.diameter());
		bst.delete(7);
		assertEquals(5, bst.diameter());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#clone()}.
	 */
	@Test
	void testClone() {
		assertEquals(bst.preOrderTraversal(), bst.clone().preOrderTraversal());
		assertEquals(bst.inOrderTraversal(), bst.clone().inOrderTraversal());
		assertEquals(bst.postOrderTraversal(), bst.clone().postOrderTraversal());
		assertEquals(bst.levelOrderTraversal(), bst.clone().levelOrderTraversal());
		assertEquals(bst.height(), bst.clone().height());
		assertEquals(bst.width(), bst.width());
		assertEquals(bst.diameter(), bst.clone().diameter());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.BinarySearchTree#iterator()}.
	 */
	@Test
	void testIterator() {
		Iterator<Integer> iterator = bst.iterator();
		List<Integer> tempList = new ArrayList<>();
		while(iterator.hasNext()) {
			tempList.add(iterator.next());
		}
		List<Integer> listFromTree = new ArrayList<>();
		String[] inorder = bst.inOrderTraversal().split(" ");
		for(String s : inorder) {
			listFromTree.add(Integer.parseInt(s));
		}
		
		assertTrue(tempList.containsAll(listFromTree));
		assertTrue(listFromTree.containsAll(tempList));
		
		assertThrows(UnsupportedOperationException.class, () -> {
			bst.iterator().remove();
		});
	}
	
	@Test
	void testToString() {
		assertEquals("3 1 7 4 8 ", bst.toString());
	}

}
