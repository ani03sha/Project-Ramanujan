package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class TrieTest {

	private Trie<Character> trie;

	@BeforeEach
	void setUp() throws Exception {
		// Creating a new instance
		trie = new Trie<>();

		// Insert some words in the Trie
		trie.insert("Harry");
		trie.insert("Hermione");
		trie.insert("Ron");
		trie.insert("Albus");
	}

	@AfterEach
	void tearDown() throws Exception {
		trie = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Trie#insert(java.lang.String)}.
	 */
	@Test
	void testInsert() {
		trie.insert("Voldemort");
		assertTrue(trie.search("Voldemort"));
		assertFalse(trie.search("Neville"));
		trie.insert("Neville");
		assertTrue(trie.search("Neville"));
		assertThrows(RuntimeException.class, () -> {
			trie.insert("Albus");
		});
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Trie#search(java.lang.String)}.
	 */
	@Test
	void testSearch() {
		assertTrue(trie.search("Hermione"));
		assertTrue(trie.search("Albus"));
		assertTrue(trie.search("Ron"));
		assertTrue(trie.search("Hermione"));
		assertFalse(trie.search("Voldemort"));
		trie.insert("Voldemort");
		trie.insert("Luna");
		assertTrue(trie.search("Luna"));
		assertTrue(trie.search("Voldemort"));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Trie#remove(java.lang.String)}.
	 */
	@Test
	void testRemove() {
		trie.remove("Albus");
		assertFalse(trie.search("Albus"));
		assertThrows(RuntimeException.class, () -> {
			trie.remove("Albus");
		});
		trie.remove("Harry");
		assertFalse(trie.search("Harry"));
	}

}
