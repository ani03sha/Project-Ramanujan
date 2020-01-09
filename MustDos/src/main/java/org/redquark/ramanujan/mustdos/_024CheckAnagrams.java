package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh Sharma
 *
 */
public class _024CheckAnagrams {

	/**
	 * This method checks if the two strings are anagram of each other or not
	 */
	public boolean areAnagrams(String a, String b) {
		// If both strings are of different length then they cannot be anagrams
		if (a.length() != b.length()) {
			return false;
		}
		// Count array for both strings
		int[] count = new int[256];
		// Loop for each character in the Strings
		for (int i = 0; i < a.length() && i < b.length(); i++) {
			count[a.charAt(i)]++;
			count[b.charAt(i)]--;
		}
		// Check if there is any non zero value in the array
		for(int i = 0; i < count.length; i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
