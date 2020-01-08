package org.redquark.ramanujan.mustdos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Anirudh Sharma
 *
 */
public class _023MaximumOccurringCharacter {

	/**
	 * This method will return the maximum occurring character in a string
	 */
	public char maximumOccurringCharacter(String s) {
		// Remove any spaces from the string
		s = s.replaceAll("\\s+", "");
		// Convert the string to lower case
		s = s.toLowerCase();
		// Map that will store the frequency of each character. Since we are assuming
		// the character are only 256 so we will set the Map's size as 256.
		Map<Character, Integer> characterMap = new HashMap<>(256);
		// Loop for each character in the string
		for (int i = 0; i < s.length(); i++) {
			// Get the current character
			char c = s.charAt(i);
			// Check if the character is already present in the map
			if (characterMap.containsKey(c)) {
				// Get the current frequency, increment it by 1 and put it again
				characterMap.put(c, characterMap.get(c) + 1);
			} else {
				// Else we set the frequency as 1
				characterMap.put(c, 1);
			}
		}
		// Variable that will store the maximum frequency
		int maximumFrequency = Integer.MIN_VALUE;
		// Variable that will store character with the maximum frequency
		char c = 0;
		// Now we will iterate the map to find out the character with the maximum
		// frequency
		for (Entry<Character, Integer> entry : characterMap.entrySet()) {
			if (entry.getValue() > maximumFrequency) {
				maximumFrequency = entry.getValue();
				c = entry.getKey();
			}
		}
		return c;
	}
}
