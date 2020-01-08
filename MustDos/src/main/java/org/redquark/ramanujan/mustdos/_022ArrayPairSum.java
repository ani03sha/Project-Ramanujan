package org.redquark.ramanujan.mustdos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class _022ArrayPairSum {

	/**
	 * This method returns the list of pairs in an array whose sum is equal to the
	 * given sum.
	 */
	public Set<Pair> findPairs(int[] a, int sum) {
		// Set that will store the resultant pairs
		Set<Pair> pairs = new HashSet<>();
		// HashMap that will be used to determine the pair
		Map<Integer, Integer> pair = new HashMap<>();
		// Loop for each element in the array
		for (int i = 0; i < a.length; i++) {
			if (pair.containsKey(sum - a[i])) {
				pairs.add(new Pair(sum - a[i], a[i]));
			}
			pair.put(a[i], i);
		}
		return pairs;
	}

	/**
	 * This class represents each pair of elements
	 */
	static class Pair {
		// Elements in the pair
		int first;
		int second;

		/**
		 * Default constructor
		 */
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int hashCode() {
			return Objects.hash(first, second);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Pair)) {
				return false;
			}
			Pair other = (Pair) obj;
			return first == other.first && second == other.second;
		}
	}
}
