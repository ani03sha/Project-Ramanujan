package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _001BubbleSort {

	public int[] sort(int[] a) {
		// This flag will keep track if any swap happened or not. If not, then we can
		// terminate the loop then and there as all elements are already in their
		// correct places.
		boolean swapped;
		// Outer loop for each pass. The condition i<a.lenght-1 is because after one
		// complete iteration of inner loop, the largest element will be at its correct
		// position
		for (int i = 0; i < a.length - 1; i++) {
			// Set swapped to false
			swapped = false;
			// Inner loop for comparing one element to its next
			for (int j = 0; j < a.length - i - 1; j++) {
				// Case when the elements are in the wrong order
				if (a[j] > a[j + 1]) {
					// Swap the numbers
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					// Since swap happened, we will set the flag
					swapped = true;
				}
			}
			// If no swap happened then no need to compare further
			if (!swapped) {
				break;
			}
		}
		return a;
	}

}
