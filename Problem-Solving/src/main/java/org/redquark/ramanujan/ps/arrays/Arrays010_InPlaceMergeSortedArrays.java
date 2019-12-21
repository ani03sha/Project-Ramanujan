package org.redquark.ramanujan.ps.arrays;

/**
 * We are given two sorted array. We need to merge these two arrays such that
 * the initial numbers (after complete sorting) are in the first array and the
 * remaining numbers are in the second array
 * 
 * @author Anirudh Sharma
 *
 */
public class Arrays010_InPlaceMergeSortedArrays {

	public int[][] inplaceMerging(int[] a, int[] b) {
		// Lengths of two arrays
		int m = a.length;
		int n = b.length;
		// Consider each element of a and ignore the element if it is already in the
		// correct order else swap it with the next smaller element which happens to be
		// the first element of b
		for (int i = 0; i < m; i++) {
			// Compare current element of a with the first element of b
			if (a[i] > b[0]) {
				// Swap both a[i] and b[0]
				int temp = a[i];
				a[i] = b[0];
				b[0] = temp;
				// Move b[0] to its correct position to maintain the sorted order of b
				int k;
				int first = b[0];
				for (k = 1; k < n && b[k] < first; k++) {
					b[k - 1] = b[k];
				}
				b[k - 1] = first;
			}
		}
		return new int[][] { a, b };
	}
}
