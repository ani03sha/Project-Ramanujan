package org.redquark.ramanujan.prepwork.ds;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents the Trie data structure implementation
 * 
 * @author Anirudh Sharma
 * @param <T>
 *
 */
public class Trie<T> {

	// Root of the Trie
	private Node<T> root;

	/**
	 * Default constructor that will create the root node of the Trie
	 */
	public Trie() {
		root = new Node<>(' ');
	}

	/**
	 * This method inserts the given word in the Trie (Dictionary)
	 */
	public void insert(String word) {
		// Checks if the word is already present in the Trie
		if (search(word)) {
			throw new RuntimeException("This word is already present in the Trie");
		}

		// Get the reference of the root in the current node
		Node<T> current = root;

		// Iterate for each character of the word
		for (char c : word.toCharArray()) {
			// Get the child of the current node
			Node<T> child = current.subNode(c);
			// Checks if the child is not null
			if (child != null) {
				// Move the current node as the child
				current = child;
			} else {
				// If the child is null then we need to add the new node as the child of the
				// current node
				current.children.add(new Node<>(c));
				// Move the current node to the child of the current node
				current = current.subNode(c);
			}
			// Increment the counter by 1
			current.count++;
		}
		// If we reach here it means we reach the end of the word so make the isEnd flag
		// true
		current.isEnd = true;
	}

	/**
	 * This method searches the passed word in the Trie data structure
	 */
	public boolean search(String word) {
		// Get the reference of the root of the Trie
		Node<T> current = root;

		// Loop until the end of the word character by character
		for (char c : word.toCharArray()) {
			// If there is no sub node of the root then it means the trie is empty or we
			// have not reach the end of the word yet there are no further characters
			if (current.subNode(c) == null) {
				return false;
			} else {
				// Move the current node to its child
				current = current.subNode(c);
			}
		}
		// If after the loop if we have reached to the end of the words stored as well,
		// it means we have found the word
		return current.isEnd == true;
	}

	/**
	 * This method removes the given word from the Trie data structure
	 */
	public void remove(String word) {
		// Base condition - if the word is not present in the Trie
		if (!search(word)) {
			throw new RuntimeException("Word is not present in the tree");
		}

		// Get the reference of the root in the current node
		Node<T> current = root;

		// Loop until the length of the word character by character
		for (char c : word.toCharArray()) {
			// Get the child of the current node
			Node<T> child = current.subNode(c);
			// Check if the count of the children of current node is 1
			if (child.count == 1) {
				// Remove the node
				current.children.remove(child);
				return;
			} else {
				// Decrement the counter by 1
				child.count--;
				current = child;
			}
		}
		// Set the end to the false
		current.isEnd = false;
	}

	/**
	 * This class represents each node of the Trie data structure
	 */
	private static class Node<T> {

		// Content to be stored in the node. Typically it is a character from the word
		private char content;
		// This variable checks if it is the end of the word
		private boolean isEnd;
		// Count of characters
		private int count;
		// List of all the children of this node
		private List<Node<T>> children;

		/**
		 * This constructor creates a new node for each character of the word passed
		 */
		Node(char c) {
			this.content = c;
			this.isEnd = false;
			this.count = 0;
			this.children = new LinkedList<>();
		}

		/**
		 * This method returns the children of the the passed character
		 */
		Node<T> subNode(char c) {
			if (children != null) {
				for (Node<T> n : children) {
					if (n.content == c) {
						return n;
					}
				}
			}
			return null;
		}
	}
}
