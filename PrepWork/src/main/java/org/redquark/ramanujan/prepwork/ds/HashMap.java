package org.redquark.ramanujan.prepwork.ds;

/**
 * @author Anirudh Sharma
 *
 */
public class HashMap<K, V> {

	// Array of Entry objects (item to be stored in a bucket)
	private Entry<K, V>[] table;

	// Default capacity of the HashMap
	private static final int DEFAULT_CAPACITY = 16;

	// Initial capacity of the HashMap
	private int initalCapacity;

	/**
	 * Default constructor - This will create a new Entry array with the default
	 * capacity of the HashMap
	 */
	@SuppressWarnings("unchecked")
	public HashMap() {
		initalCapacity = DEFAULT_CAPACITY;
		// Creating a new array with the default capacity
		table = new Entry[initalCapacity];
	}

	/**
	 * Parameterized constructor that will create the Entry table with the given
	 * initial capacity
	 */
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		initalCapacity = capacity;
		table = new Entry[initalCapacity];
	}

	/**
	 * This method stores a key-value pair in the HashMap
	 */
	public void put(K key, V value) {
		// Check if the key to be stored is null - Null key is not allowed
		if (key == null) {
			throw new RuntimeException("Null keys are not allowed");
		}

		// Find the hash value of the key to find the bucket location
		int hash = hash(key);

		// Create an Entry object with the given key and value pair
		Entry<K, V> entry = new Entry<>(key, value, null);

		// If no value is found at the index 'hash' of the Entry table then put our
		// object in it
		if (table[hash] == null) {
			table[hash] = entry;
		} else {
			// If there is already an Entry stored at the 'hash' index - we have encountered
			// hash collision. In this condition, we will create a linked list and store our
			// newly created object at the end of that linked list
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while (current != null) {
				// Check if the key we are going to store is already present in the table
				if (current.key.equals(key)) {
					if (previous == null) {
						entry.next = current.next;
						table[hash] = entry;
					} else {
						entry.next = current.next;
						previous.next = entry;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = entry;
		}
	}

	/**
	 * This method will return the value V stored against the key K
	 */
	public V get(K key) {
		// Check if the key is null. Since we do not allow null keys, therefore the
		// value returned will be null
		if (key == null) {
			return null;
		}

		// Find the hash value of the key so that we can determine the bucket location
		// (Entry table index)
		int hash = hash(key);

		// If there is no value at the 'hash' index, we will return null
		if (table[hash] == null) {
			return null;
		} else {
			// Else we will try to iterate through the list, if present
			// Get the value stored at 'hash' index
			Entry<K, V> temp = table[hash];
			// Iterate through the list
			while (temp != null) {
				// If found return the corresponding value
				if (temp.key.equals(key)) {
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	/**
	 * This method removes the given key from the HashMap and returns true if the
	 * value is found and removed
	 */
	public boolean remove(K key) {
		// Check for null key
		if (key == null) {
			return false;
		}

		// Find the hash value on the Key object
		int hash = hash(key);

		// Check if something is stored at the 'hash' index or not
		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(key)) {
					if (previous == null) {
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}

	/**
	 * This method checks if the given key is present in the HashMap or not
	 */
	public boolean containsKey(K key) {
		// Finding the hash of the key
		int hash = hash(key);
		// Check if something is stored at the 'hash' index or not
		if (table[hash] == null) {
			return false;
		} else {
			// Getting the reference of the Entry object stored at the 'hash' index
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(key)) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}

	/**
	 * This method returns the size of the HashMap
	 */
	public int size() {
		// Variable to store size
		int count = 0;
		// Loop for all the buckets and their corresponding linked lists if any
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				int nodeCount = 0;
				for (Entry<K, V> e = table[i]; e.next != null; e = e.next) {
					nodeCount++;
				}
				// Add the nodes to the total count
				count += nodeCount;
				count++;
			}
		}
		return count;
	}

	/**
	 * This method returns the hashcode of the Key object.
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode()) % initalCapacity;
	}

	private static class Entry<K, V> {
		// Key to be stored
		private K key;
		// Value to be stored
		private V value;
		// Next pointer in case multiple entries resolve to the same bucket location
		private Entry<K, V> next;

		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

}
