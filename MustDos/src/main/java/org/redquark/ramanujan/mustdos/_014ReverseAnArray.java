package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _014ReverseAnArray {

	/**
	 * This method reverses the given array 'a'
	 */
	public int[] reverse(int[] a) {
		// We will swap the last element with the first, second last with the second and
		// so on...
		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
		return a;
	}

}
