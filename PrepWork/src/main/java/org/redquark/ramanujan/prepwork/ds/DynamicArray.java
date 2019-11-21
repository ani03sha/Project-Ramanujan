package org.redquark.ramanujan.prepwork.ds;

/**
 * This class deals with all the operations of a dynamic array like add, remove,
 * resize etc.
 * 
 * @author Anirudh Sharma
 */
public class DynamicArray {

	public int[] array; // The dynamic array in picture
	private int count; // This variable will deal with the number of elements added by a user
	private int size; // The size of the array

	public DynamicArray() {
		// Here all the initialization stuff will go
		array = new int[1];
		count = 0; // This means no element in the array
		size = 1; // This means only one element can be stored in the array without resizing
	}

	/**
	 * This will add an element at the "end" of the array
	 */
	public void add(int data) {
		// Check if the number of elements in the array is equal to the size of the
		// array, which means the array is full and needs resizing.
		if (count == size) {
			growSize();
		}
		// Add the element at the end of the array
		array[count] = data;
		// Increment count as one more element is added
		count++;
	}

	/**
	 * This method adds an element at the given index
	 */
	public void addAt(int index, int data) {
		// Check if the array is full. If yes, make the size double of the previous one
		if (count == size) {
			growSize();
		}
		// This loop will run from the last element and will to the index where element
		// needs to be stored
		for (int i = count - 1; i >= index; i--) {
			// Shift all elements to the right from the given index
			array[i + 1] = array[i];
		}
		// Insert data at given index
		array[index] = data;
		count++;
	}

	/**
	 * This method removes element from the end of the array
	 */
	public void remove() {
		// Condition to check if the array is not empty
		if (count > 0) {
			array[count - 1] = 0;
			count--;
		}
	}

	/**
	 * This method removes the elements from the given index
	 */
	public void removeAt(int index) {
		// Condition to check if the array is not empty
		if (count > 0) {
			for (int i = index; i < count - 1; i++) {
				// Shift all elements to the left
				array[i] = array[i + 1];
			}
			// Since all the elements are shifted one position left so the original last
			// position is empty and therefore zero
			array[count - 1] = 0;
			count--;
		}
	}

	/**
	 * This method will double the size of array and copy old array into a new
	 * bigger array
	 */
	private void growSize() {
		int[] temp = null; // A temporary array to handle the intermediate operation of copying elements
		if (count == size) {
			// Create a new array with double the present size
			temp = new int[size * 2];
			for (int i = 0; i < size; i++) {
				// Copy all the elements in the current value into the bigger array
				temp[i] = array[i];
			}
			// Assign the bigger array into the original array again
			array = temp;

			// Double the size also
			size = size * 2;
		}
	}
}
