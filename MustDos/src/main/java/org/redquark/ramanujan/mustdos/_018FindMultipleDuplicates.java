package org.redquark.ramanujan.mustdos;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of n elements which contains elements from 0 to n-1, with any
 * of these numbers appearing any number of times. Find these repeating numbers
 * in O(n) and using only constant memory space.
 * 
 * @author Anirudh Sharma
 *
 */
public class _018FindMultipleDuplicates {

	/**
	 * This method will return the list containing all the duplicates in the given
	 * array 'a'
	 */
	public List<Integer> getDuplicates(int[] a) {
		// List of duplicates
		List<Integer> duplicates = new ArrayList<>();
		// Loop for each element in the array
		for (int i = 0; i < a.length; i++) {
			// In this step, we are replacing the current value with its scaled modulo 10
			a[a[i] % 10] = a[a[i] % 10] + 10;
		}
		// Loop again but this time store the duplicates in the list
		for (int i = 0; i < a.length; i++) {
			// In case if the element was duplicate then 10 will be added to it more than
			// once making the sum 20 or more
			if (a[i] > 19) {
				duplicates.add(i);
			}
		}
		return duplicates;
	}
}
