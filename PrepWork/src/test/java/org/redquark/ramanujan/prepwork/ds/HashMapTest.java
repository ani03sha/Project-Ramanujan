package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {

	private HashMap<Integer, String> hashMap;
	private HashMap<Integer, String> anotherHashMap;

	@BeforeEach
	void setUp() throws Exception {
		// Initializing the HashMap
		hashMap = new HashMap<>();
		anotherHashMap = new HashMap<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		hashMap = null;
		anotherHashMap = null;
	}

	@Test
	void testPut() {
		assertEquals(0, hashMap.size());
		hashMap.put(1, "Superman");
		hashMap.put(2, "Batman");
		assertEquals(2, hashMap.size());
		hashMap.put(17, "Flash");
		assertEquals(3, hashMap.size());
		assertThrows(RuntimeException.class, () -> {
			anotherHashMap.put(null, "F");
		});
		anotherHashMap.put(1, "A");
		anotherHashMap.put(2, "B");
		anotherHashMap.put(3, "C");
		anotherHashMap.put(4, "D");
		anotherHashMap.put(5, "E");
		anotherHashMap.put(4, "G");
		assertEquals(5, anotherHashMap.size());
	}

	@Test
	void testGet() {
		assertNull(hashMap.get(1));
		hashMap.put(1, "Superman");
		hashMap.put(2, "Batman");
		assertEquals("Batman", hashMap.get(2));
		assertNotEquals("Aquman", hashMap.get(6));
		assertNull(hashMap.get(null));
		hashMap.put(18, "Flash");
		assertEquals("Flash", hashMap.get(18));
		assertNull(hashMap.get(19));
	}

	@Test
	void testRemove() {
		assertFalse(hashMap.remove(1));
		hashMap.put(1, "Superman");
		assertTrue(hashMap.remove(1));
		assertFalse(hashMap.remove(1));
		hashMap.put(1000, "Wonder Woman");
		assertTrue(hashMap.remove(1000));
		assertFalse(hashMap.remove(null));
		hashMap.put(1, "Superman");
		hashMap.put(1, "Batman");
		hashMap.put(1, "Wonder Woman");
		hashMap.put(18, "Flash");
		assertTrue(hashMap.remove(18));
	}

	@Test
	void testContainsKey() {
		assertFalse(hashMap.containsKey(2));
		hashMap.put(1, "Superman");
		assertTrue(hashMap.containsKey(1));
		hashMap.put(2, "Batman");
		assertFalse(hashMap.containsKey(1000));
		assertTrue(hashMap.containsKey(2));
		hashMap.put(17, "Flash");
		assertTrue(hashMap.containsKey(17));
	}

	@Test
	void testSize() {
		assertEquals(0, hashMap.size());
		hashMap.put(1, "Superman");
		assertEquals(1, hashMap.size());
		hashMap.put(2, "Batman");
		hashMap.put(3, "Aquaman");
		assertEquals(3, hashMap.size());
	}

}
