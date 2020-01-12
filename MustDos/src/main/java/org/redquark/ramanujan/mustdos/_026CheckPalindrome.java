package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _026CheckPalindrome {

	/**
	 * This method checks if the given string is a Palindrome or not
	 */
	public boolean isPalindrome(String s) {
		// Remove all the special characters from the string
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		// Convert all characters in the lowercase
		s = s.toLowerCase();
		// Convert String into character array
		char[] elements = s.toCharArray();
		// Lower index
		int low = 0;
		// Higher index
		int high = elements.length - 1;
		// Loop for each character in the string
		while (low < high) {
			if (elements[low++] != elements[high--]) {
				return false;
			}
		}
		return true;
	}
}
