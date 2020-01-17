/**
 * 
 */
package org.redquark.ramanujan.mustdos;

/**
 * @author Anirudh
 *
 */
public class _029StringRotation {

	/**
	 * This method checks if two strings are rotation of each other or not
	 */
	public boolean isRotation(String original, String rotated) {
		// Check if two strings are of equal length
		if (original.length() != rotated.length()) {
			return false;
		}
		// Concatenate two strings
		String concatenated = original + original;
		// Checks if the rotated string is present in the concatenated string
		if (concatenated.indexOf(rotated) != -1) {
			return true;
		}
		return false;
	}

}
