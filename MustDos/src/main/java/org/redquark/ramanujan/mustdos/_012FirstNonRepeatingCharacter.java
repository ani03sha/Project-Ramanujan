package org.redquark.ramanujan.mustdos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a string, find the first non-repeating character in it.
 * 
 * @author Anirudh Sharma
 *
 */
public class _012FirstNonRepeatingCharacter {

	/**
	 * This method finds the first non repeating character from a given string 's'.
	 */
	public char findFirstFirstNonRepeatingCharacter(String s) {
		// Create a map that will store the character and its frequency in a string.
		// Since we are assuming that there can be only 256 characters, hence we are
		// creating the map of size 256 only.
		Map<Character, Integer> characterMap = new LinkedHashMap<>(256);
		// Remove all the spaces from the string
		s = s.replaceAll("\\s+", "");
		// Convert the string to lowercase
		s = s.toLowerCase();
		// Loop for each character in the string and store its frequency in the map
		for (int i = 0; i < s.length(); i++) {
			// Get the current character
			char c = s.charAt(i);
			// Check if the character is already present in the string
			if (characterMap.containsKey(c)) {
				// Get the current frequency of character
				int frequency = characterMap.get(c);
				// If the character is present, we will increase its frequency by one and save
				// it against the key (character)
				characterMap.put(c, frequency + 1);
			}
			// If the character is not present in the map
			else {
				characterMap.put(c, 1);
			}
		}
		// Iterate the map and return the first key which has count (value) equals to
		// one
		for (Entry<Character, Integer> entry : characterMap.entrySet()) {
			// Check if the value store in the current entry object is one or not
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		// If we reach here it means we do not have any repeated character in the string
		// hence the first non repeating character in the string will be the first
		// character in the string.
		return s.charAt(0);
	}
}
