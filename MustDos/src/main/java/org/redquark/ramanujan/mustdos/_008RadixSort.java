package org.redquark.ramanujan.mustdos;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class _008RadixSort {

	/**
	 * This method sorts the array using Radix Sort algorithm
	 */
	public void sort(int[] a) {
		// Get the maximum elements among the elements in the array to know the number
		// of digits
		int max = getMaxElement(a);
		// Calculate number of digits in the maximum number
		int numberOfDigits = calculateNumberOfDigits(max);
		// Place value - or the place in digit i.e. ones, tens, hundreds etc.
		int placeValue = 1;
		// Loop for each digit in the number from LSD to MSD
		while (numberOfDigits-- > 0) {
			countSort(a, placeValue);
			placeValue *= 10;
		}
	}

	/**
	 * This method calculates the number of digits in the maximum number
	 */
	private int calculateNumberOfDigits(int n) {
		// This will be valid only if the number is greater than 0
		return (int) (Math.log(n) + 1);
	}

	/**
	 * This method will perform counting sort of array according to the digits
	 * represented by exponent
	 */
	private void countSort(int[] a, int placeValue) {
		// Radix or the base
		int radix = 10;
		// The array that will store the frequency of size 10 as there are 10 digits
		// only
		int[] frequencies = new int[radix];
		// This array will store the sorted values
		int[] sorted = new int[a.length];
		// Find the frequencies of the digits in the number
		for (int i = 0; i < a.length; i++) {
			// Current digit
			int digit = (a[i] / placeValue) % radix;
			frequencies[digit]++;
		}
		// Get the cumulative frequencies
		for (int i = 1; i < radix; i++) {
			frequencies[i] += frequencies[i - 1];
		}
		// Fill the array with sorted values
		for (int i = a.length - 1; i >= 0; i--) {
			int digit = (a[i] / placeValue) % radix;
			sorted[frequencies[digit] - 1] = a[i];
			frequencies[digit]--;
		}
		// Copy the sorted array into the original array
		System.arraycopy(sorted, 0, a, 0, a.length);
	}

	/**
	 * This method finds the maximum element in the array
	 */
	private int getMaxElement(int[] a) {
		return Arrays.stream(a).max().getAsInt();
	}
}
