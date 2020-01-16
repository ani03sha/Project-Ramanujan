package org.redquark.ramanujan.mustdos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class _028StringPermutations {

	/**
	 * This method will find all the permutations of the given string
	 */
	public List<String> findPermutations(String s) {
		// List that will store all the permutations of a given string s
		List<String> perms = new ArrayList<>();
		// This private method will actually calculate the permutations
		return findPermutations("", s, perms);
	}

	private List<String> findPermutations(String letter, String s, List<String> perms) {
		// Base condition
		if (s.isEmpty()) {
			perms.add(letter + s);
		} else {
			// Loop for each character in the string
			for (int i = 0; i < s.length(); i++) {
				findPermutations(letter + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()), perms);
			}
		}
		return perms;
	}
}
