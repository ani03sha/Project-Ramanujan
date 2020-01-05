package org.redquark.ramanujan.mustdos;

/**
 * Given a string and a character, task is to make a function which count
 * occurrence of the given character in the string.
 * 
 * @author Anirudh Sharma
 *
 */
public class _011OccurrenceOfGivenCharacter {

	/**
	 * This method counts the occurrence of given character 'c' in the given string
	 * 's'.
	 */
	public int countOccurrences(String s, char c) {
		// Counter
		int count = 0;
		// Convert the string to lower case so that we can treat uppercase and lowercase
		// letters alike
		s = s.toLowerCase();
		// Remove all the white spaces from the string
		s.replaceAll("\\s+", "");
		// Loop for each character in the string
		for (int i = 0; i < s.length(); i++) {
			// Check if the current character is equal to the given character
			if (s.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
}
