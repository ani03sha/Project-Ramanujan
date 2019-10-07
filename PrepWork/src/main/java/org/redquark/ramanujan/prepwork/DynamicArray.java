package org.redquark.ramanujan.prepwork;

import java.util.Arrays;

/**
 * This class deals with all the operations of a dynamic array like add, remove,
 * resize etc.
 * 
 * @author Anirudh Sharma
 */
public class DynamicArray {

	private int[] array; // The dynamic array in picture
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
	public void growSize() {
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

	/**
	 * This method shrinks the array to free up unnecessary held memory
	 */
	public void shrinkSize() {
		int[] temp = null; // A temporary array to handle the intermediate operation of copying elements
		if (count > 0) {
			// The temp should be the count size array because only the "count" number of
			// elements are present in the original array
			temp = new int[count];
			for (int i = 0; i < count; i++) {
				temp[i] = array[i];
			}
			size = count;
			// Assign temp to original array again - Rest memory spaces will be garbage
			// collected
			array = temp;
		}
	}

	public static void main(String[] args) {

		DynamicArray da = new DynamicArray();

		// Adding some elements in the array
		da.add(1);
		da.add(2);
		da.add(3);
		da.add(4);
		da.add(5);
		da.add(6);
		da.add(7);
		da.add(8);
		da.add(9);
		da.add(10);
		
		// Original array
		System.out.println("Original array: " + Arrays.toString(da.array));
		System.out.println("Original array [size]: " + da.size);
		System.out.println("Original array [count]: " + da.count);
		
		// Shrink size of array
		da.shrinkSize();
		System.out.println("After shrinking: " + Arrays.toString(da.array));
		System.out.println("After shrinking [size]: " + da.size);
		System.out.println("After shrinking [count]: " + da.count);
		
		// Add element at index 1
		da.addAt(1, 11);
		System.out.println("After adding element at index 1: " + Arrays.toString(da.array));
		System.out.println("After adding element at index 1 [size]: " + da.size);
		System.out.println("After adding element at index 1 [count]: " + da.count);
		
		// Delete last element
		da.remove();
		System.out.println("After deleting last element: " + Arrays.toString(da.array));
		System.out.println("After deleting last element [size]: " + da.size);
		System.out.println("After deleting last element [count]: " + da.count);
		
		// Delete element at index 1
		da.removeAt(1);
		System.out.println("After deleting last element at index 1: " + Arrays.toString(da.array));
		System.out.println("After deleting last element at index 1 [size]: " + da.size);
		System.out.println("After deleting last element at index 1 [count]: " + da.count);
		
		// Finally shrinking size
		da.shrinkSize();
	}

}
