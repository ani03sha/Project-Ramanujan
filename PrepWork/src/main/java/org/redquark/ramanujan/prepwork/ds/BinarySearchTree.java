package org.redquark.ramanujan.prepwork.ds;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * This class represents the implementation of a Binary Search Tree with all the
 * basic operations
 * 
 * @author Anirudh Sharma
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

	// Root of the BST
	private Node<T> root;

	// Comparator object
	private Comparator<T> comparator;

	/**
	 * No argument constructor
	 */
	public BinarySearchTree() {
		this.root = null;
		this.comparator = null;
	}

	/**
	 * Constructor with the Comparator object
	 */
	public BinarySearchTree(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
	}

	/**
	 * Internal helper method to compare the two nodes of a tree
	 */
	private int compare(T x, T y) {
		// If custom comparator is null, then we will use the default comparison
		if (comparator == null) {
			return x.compareTo(y);
		} else {
			// Else, we will use the custom compare method
			return comparator.compare(x, y);
		}
	}

	/**
	 * This method will search the passed key value. Internally, this will use an
	 * overloaded method to search
	 */
	public boolean search(T key) {
		return search(root, key);
	}

	/**
	 * Helper method to search the key recursively
	 * 1. First we will check the key at the root. If found, return
	 * 2. Then we compare the key with data at root. If smaller, search in left subtree
	 * 3. If greater, then search in the right subtree
	 */
	private boolean search(Node<T> item, T key) {
		// If the root is null, which means there is no tree
		if (item == null) {
			return false;
		} else if (compare(key, item.data) == 0) { // If the key is present at the root of the tree
			return true;
		} else if (compare(key, item.data) < 0) { // If the key is smaller than the data at root
			return search(item.left, key); // Now we will search in the left subtree
		} else { // If the key is greater than the data at root
			return search(item.right, key); // Then we will search in the right subtree
		}
	}
	
	/**
	 * This method inserts the specified data at the appropriate position in the BST. 
	 * This method internally uses a private helper method to insert data
	 */
	public void insert(T data) {
		root = insert(root, data);
	}
	
	/**
	 * Helper method to insert a node at the appropriate position in the BST.
	 * 1. Check if the root is null, then we will add the new node as the root of the tree
	 * 2. If the item to be added is at the root, then we will do nothing
	 * 3. If the item to be added is smaller than the data at root then we will move towards left subtree
	 * 4. If the item to be added is greater than the data at root then we will move towards right subtree
	 */
	private Node<T> insert(Node<T> item, T data) {
		// Base condition - if root is null, which means there is no tree and we will
		// add the new node as the root of the tree
		if (item == null) {
			return new Node<T>(data);
		}
		// If the item to be added is already present at the root of the tree then we
		// will not add it as we do not add duplicates in the tree
		if (compare(data, item.data) == 0) {
			return item;
		}
		// If the key to be added is smaller than the one present at the root, then we
		// will add it in the left subtree else we will add it in the right subtree
		if (compare(data, item.data) < 0) {
			item.left = insert(item.left, data);
		} else {
			item.right = insert(item.right, data);
		}

		return item;
	}
	
	/**
	 * This method delete the specified data from the BST.
	 * This method internally uses a helper method to delete data
	 */
	public void delete(T data) {
		root = delete(root, data);
	}
	
	/**
	 * Helper method which is used to delete the specified data from the list.
	 * Deletion strategy is the following: replace the node being deleted with the
	 * largest node in the left subtree and then delete that largest node. By
	 * symmetry, the node being deleted can be swapped with the smallest node is the
	 * right subtree. 
	 * 
	 * 1. Check if the root is null, which means there is no tree and throw an exception 
	 * 2. Check if the item to be deleted is present in the left subtree 
	 * 3. Check if the item to be deleted is present in the right subtree 
	 * 4. If both conditions fail, then we delete the rightmost node in the left subtree
	 */
	private Node<T> delete(Node<T> item, T data) {
		// Base condition - root is null which means there is no tree to delete from
		if (item == null) {
			throw new RuntimeException("Cannot delete from empty tree");
		} else if (compare(data, item.data) < 0) { // If the key is smaller than the data at root
			item.left = delete(item.left, data); // Then we will move towards the left subtree
		} else if (compare(data, item.data) > 0) { // If the key is greater than the data at root
			item.right = delete(item.right, data); // Then we will move towards the right subtree
		} else {
			if (item.left == null) {
				return item.right;
			} else if (item.right == null) {
				return item.left;
			} else {
				// Retrieve the data from the rightmost node in the left subtree
				item.data = retrieveData(item.left);
				// Delete the rightmost node in the left subtree
				item.left = delete(item.left, item.data);
			}
		}
		return item;
	}
	
	/**
	 * Helper method to get the rightmost node in the left subtree
	 */
	private T retrieveData(Node<T> item) {
		while (item.right != null) {
			item = item.right;
		}
		return item.data;
	}
	
	/**
	 * This method returns the pre-order traversal of the BST.
	 * This method internally uses a helper method for recursion.
	 * 1. Traverse the parent
	 * 2. Traverse the left subtree of the above parent recursively
	 * 3. Traverse the right subtree of the above parent recursively
	 */
	public String preOrderTraversal() {
		return preOrder(root);
	}

	/**
	 * Helper method for the pre-order traversal
	 */
	private String preOrder(Node<T> item) {
		// StringBuffer instance that will store the data of nodes traversed
		StringBuffer result = new StringBuffer();
		// If root is null then there is no tree hence this condition
		if (item != null) {
			// Traversing the root node first
			result.append(item.data).append(" ");
			// Traversing the left subtree of current node
			preOrder(item.left);
			// Traversing the right subtree of current node
			preOrder(item.right);
		}
		// Return the String equivalent of the node traversed
		return result.toString();
	}
	
	/**
	 * This method returns the in-order traversal of the BST.
	 * This method internally uses a helper method for recursion.
	 * 1. Traverse the left subtree of the parent recursively
	 * 2. Traverse the parent
	 * 3. Traverse the right subtree of the parent recursively
	 */
	public String inOrderTraversal() {
		return inOrder(root);
	}

	/**
	 * Helper method for the in-order traversal
	 */
	private String inOrder(Node<T> item) {
		// StringBuffer instance that will store the data of nodes traversed
		StringBuffer result = new StringBuffer();
		// If root is null then there is no tree hence this condition
		if (item != null) {
			// Traversing the left subtree of current node
			inOrder(item.left);
			// Traversing the root node in between
			result.append(item.data).append(" ");
			// Traversing the right subtree of current node
			inOrder(item.right);
		}
		// Return the String equivalent of the node traversed
		return result.toString();
	}
	
	/**
	 * This method returns the in-order traversal of the BST.
	 * This method internally uses a helper method for recursion.
	 * 1. Traverse the left subtree of the parent recursively
	 * 2. Traverse the right subtree of the parent recursively
	 * 3. Traverse the parent
	 */
	public String postOrderTraversal() {
		return postOrder(root);
	}

	/**
	 * Helper method for the post-order traversal
	 */
	private String postOrder(Node<T> item) {
		// StringBuffer instance that will store the data of nodes traversed
		StringBuffer result = new StringBuffer();
		// If root is null then there is no tree hence this condition
		if (item != null) {
			// Traversing the left subtree of current node
			postOrder(item.left);
			// Traversing the right subtree of current node
			postOrder(item.right);
			// Traversing the root node last
			result.append(item.data).append(" ");
		}
		// Return the String equivalent of the node traversed
		return result.toString();
	}
	
	/**
	 * This method returns the level order traversal of BST.
	 * 1. First we find the height of the tree as there will be these many levels
	 * 2. Then we iterate through height number of times i.e. for each level
	 * 3. Then we call the helper method that will do traversal for that level
	 */
	public String levelOrderTraversal() {
		// StringBuffer instance that will store the data of nodes traversed
		StringBuffer result = new StringBuffer();
		// Getting the height of the tree
		int h = height();
		// Iterate h-number of times
		for (int i = 0; i < h; i++) {
			// This method will print each level
			levelOrder(root, i, result);
		}
		// Return the string representation of result
		return result.toString();
	}
	
	/**
	 * Helper method to traverse each node at the specified level
	 * 1. If root is null then there is no tree, we cannot do anything
	 * 2. If there is only one level i.e. the root level then we print it
	 * 3. Perform step 1 and 2 for each left and right subtree
	 */
	private void levelOrder(Node<T> item, int level, StringBuffer result) {
		// Base condition - if the root is null then we do not have to do anything
		if (root == null) {
			return;
		}
		// For the root level
		if (level == 1) {
			result.append(item.data).append(" ");
		}
		// For the levels below root
		if (level > 1) {
			levelOrder(item.left, level--, result);
			levelOrder(item.right, level--, result);
		}
	}

	/**
	 * This method returns the height of the BST.
	 * This method internally uses a helper method to find out the height
	 */
	public int height() {
		return height(root);
	}
	
	/**
	 * Helper method to find out the height recursively
	 * 1. If root is null then height is 0
	 * 2. Else, we will find the max of heights of left and right subtrees
	 * 3. Add 1 for the root node to the above result
	 */
	private int height(Node<T> item) {
		// Base condition - if root is null then there is no tree
		if (item == null) {
			return 0;
		} else {
			// Recursively calculate the heights of left and right subtree and get the
			// maximum of both
			// Then add 1 to it for the root
			return 1 + Math.max(height(item.left), height(item.right));
		}
	}
	
	/**
	 * This method counts the number of leaves in a BST.
	 * A leaf is a node which has no child.
	 * This method uses a helper method to count the leaves
	 */
	public int countLeaves() {
		return countLeaves(root);
	}

	/**
	 * Helper overloaded method to count the leaves
	 * 1. If the root is null then the leaves are zero
	 * 2. If there is only root in the tree, then the count will be one - the root itself
	 * 3. Count leaves of left and right subtree recursively and add them
	 */
	private int countLeaves(Node<T> item) {
		// Base condition - if root is null then the leaves are zero
		if(item == null) {
			return 0;
		} else if(item.left == null && item.right == null) { // If there is only root
			return 1;
		} else {
			// Recursively count the leaves of left and right subtrees and return the sum of both
			return countLeaves(item.left) + countLeaves(item.right);
		}
	}
	
	/**
	 * The width of a BST is the maximum number of nodes at one level.
	 * This method returns the width of a BST.
	 * 1. Find the height of the tree which is equal to the number of levels present in the tree
	 * 2. Iterate for each level
	 * 3. Find the width of each level and compare it with the current maximum
	 */
	public int width() {
		// Variable to store width
		int max = 0;
		// Iterate through height of the tree. This is done to find the width of each
		// level
		for (int i = 0; i < height(); i++) { // Each iteration represents each level
			// Find the width of the current level
			int temp = width(root, i);
			// Find the maximum between max and width of current level
			if (temp > max) {
				max = temp;
			}
		}
		// Return the width
		return max;
	}

	/**
	 * Helper method which returns the width of each level
	 * 1. If root is null then there is no tree. Hence width will be zero
	 * 2. if there are no levels except root then the width will be 1
	 * 3. Else we will add the widths of left and right subtrees recursively
	 */
	private int width(Node<T> item, int depth) {
		// Base condition - if root is null then there is no tree
		if (item == null) {
			return 0;
		} else if (depth == 0) { // If there are no levels except one
			return 1;
		} else {
			// Return the sum of widths of left and right subtree
			return width(item.left, depth--) + width(item.right, depth--);
		}
	}
	
	/**
	 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
	 * This method uses a helper method to find the diameter
	 */
	public int diameter() {
		return diameter(root);
	}

	/**
	 * Helper method to find the diameter of a BST
	 * 1. If root is null then there is no tree
	 * 2. Find the length if path goes through the root
	 * 3. Find the length if path does not goes through the root
	 * 3. Return the maximum of two
	 */
	private int diameter(Node<T> item) {
		// Base condition - if root is null then there is no tree
		if(item == null) {
			return 0;
		}
		// If the path goes through the root
		int a = height(item.left) + height(item.right) + 3;
		// If the path does not go through the root
		int b = Math.max(diameter(item.left), diameter(item.right));
		// Return the maximum of two values
		return Math.max(a, b);
	}

	/**
	 * This method restores the original tree if its preorder and inorder ar given
	 */
	public void restore(T[] preorder, T[] inorder) {
		root = restore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	/**
	 * Helper method to restore the tree from given preorder and inorder arrays
	 */
	private Node<T> restore(T[] preorder, int preL, int preR, T[] inorder, int inL, int inR) {
		// Check if the left of preorder array is smaller or equals to than right of
		// preorder array
		if (preL <= preR) {
			// Counter
			int count = 0;
			// Find the root in the inorder array
			while (preorder[preL] != inorder[inL + count]) {
				count++;
			}
			// Create a new node as the root of the new tree to be constructed
			Node<T> temp = new Node<T>(preorder[preL]);
			// Recursive calls to this method for creating left and right subtrees
			temp.left = restore(preorder, preL + 1, preL + count, inorder, inL, inL + count - 1);
			temp.right = restore(preorder, preL + count + 1, preR, inorder, inL + count + 1, inR);
			// Return the root of newly created tree
			return temp;
		} else {
			return null;
		}
	}
	
	/**
	 * This method will return the deep copy of the existing BST
	 */
	public BinarySearchTree<T> clone() {
		// Creating a reference of the BST
		BinarySearchTree<T> twin = null;
		// Check for the nullability of comparator
		if(comparator == null) {
			twin = new BinarySearchTree<>();
		} else {
			twin = new BinarySearchTree<>(comparator);
		}
		// Creating the root of clone
		twin.root = clone(root);
		// Return the clone of the original tree
		return twin;
	}
	
	/**
	 * Helper method for creating nodes of the clone recursively
	 */
	private Node<T> clone(Node<T> item) {
		// Base condition - if root is null then there is no BST
		if(item == null) {
			return null;
		} else {
			// Create a new node with the data from the original tree
			// Perform this task recursively for the left and right subtrees
			return new Node<T>(item.data, clone(item.left), clone(item.right));
		}
	}
	
	/**
	 * Overridden method of default toString.
	 * This method returns the String representation of the BST
	 */
	public String toString() {
		// StringBuffer instance to store data of the BST
		StringBuffer result = new StringBuffer();
		// Iterate through the tree
		for(T data : this) {
			result.append(data.toString()).append(" ");
		}
		// Return the String representation of the tree
		return result.toString();
	}

	/**
	 * Iterator of the BST.
	 * This will use an inner class for its operations
	 */
	@Override
	public Iterator<T> iterator() {
		return new BinarySearchTreeIterator();
	}

	/******************************
	 * The Node class
	 ******************************/
	private static class Node<T> {

		// Data to be stored in each node of the tree
		private T data;
		// Left child of the node
		private Node<T> left;
		// Right child of the node
		private Node<T> right;

		/**
		 * Parameterized constructor for creating nodes in a BST
		 */
		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		/**
		 * Overloaded constructor for the root of the BST
		 */
		public Node(T data) {
			this(data, null, null);
		}

		/**
		 * Overridden toString method
		 */
		public String toString() {
			return data.toString();
		}
	}
	
	/******************************
	 * The Iterator class
	 ******************************/
	private class BinarySearchTreeIterator implements Iterator<T> {

		// This implementation will use Stack data structure
		private Stack<Node<T>> stack = new Stack<>();

		/**
		 * Default constructor which will push the root into the stack if it is not
		 * empty
		 */
		public BinarySearchTreeIterator() {
			// Check if the root is not null then we will push it into the Stack
			if (root != null) {
				stack.push(root);
			}
		}

		/**
		 * This method will check if the current node reference has the next node
		 */
		@Override
		public boolean hasNext() {
			// True - if the current node has a next node
			// False - if the current node does not have a next node
			return !stack.isEmpty();
		}

		/**
		 * This method returns the reference of the next node of the current node
		 */
		@Override
		public T next() {
			// Get the current node (but not removing it)
			Node<T> current = stack.peek();
			// Check if the current node has the left subtree
			if (current.left != null) {
				stack.push(current.left);
			} else {
				// Remove the top of stack
				Node<T> temp = stack.pop();
				// Loop if right of current node is null
				while (temp.right == null) {
					if (stack.isEmpty()) {
						return current.data;
					}
					temp = stack.pop();
				}
				stack.push(temp.right);
			}
			return current.data;
		}

		/**
		 * Unsupported operation
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
