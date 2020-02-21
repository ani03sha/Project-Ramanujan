package org.redquark.ramanujan.ps.arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays011_MergeTwoArrays {

	/**
	 * This method moves vacant cells in the beginning of the array and then merge
	 * it with the smaller array
	 */
	public int[] mergeSorted(int[] a, int[] b) {
		// Moves non empty elements of a in the beginning
		int k = 0;
		// Loop for all the elements in the array
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[k++] = a[i];
			}
		}
		return merge(a, b, k - 1, b.length - 1);
	}

	private int[] merge(int[] a, int[] b, int m, int n) {
		// Size of a[] is k+1
		int k = m + n + 1;
		// Run till a[] or if b[] has elements left
		while (m >= 0 && n >= 0) {
			// Put next greater elements in next free position in a[] from end
			if (a[m] > b[n]) {
				a[k--] = a[m--];
			} else {
				a[k--] = b[n--];
			}
		}
		// Copy remaining elements of b[] (if any) in a[]
		while (n >= 0) {
			a[k--] = b[n--];
		}
		return a;
	}
}
