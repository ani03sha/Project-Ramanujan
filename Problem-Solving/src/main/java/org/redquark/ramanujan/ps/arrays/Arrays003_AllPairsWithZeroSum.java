package org.redquark.ramanujan.ps.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class Arrays003_AllPairsWithZeroSum {

	/**
	 * This method will return all the pairs of indexes for which the sum of
	 * elements is zero
	 */
	public List<Pair> findPairs(int[] a) {
		// Map that will store the sum as the key along with the pairs as the value
		Map<Integer, List<Integer>> sumMap = new HashMap<>();
		// List of pairs that will store the indexes of the subarray having zero sum
		List<Pair> pairs = new ArrayList<>();
		// Variable to store the cumulative sum
		int cumulativeSum = 0;

		// Loop through all the elements in the array
		for (int i = 0; i < a.length; i++) {
			// Update the value of sum
			cumulativeSum += a[i];
			// If the sum is zero then we have found the subarray with zero sum starting
			// from index 0 to i
			if (cumulativeSum == 0) {
				pairs.add(new Pair(0, i));
			}
			// Temp list
			List<Integer> temp = new ArrayList<>();
			// If the sum is already present in the map then there is at least one subarray
			// with index ending at i with zero sum
			if (sumMap.containsKey(cumulativeSum)) {
				// Get the list of pairs with the zero sum
				temp = sumMap.get(cumulativeSum);
				// Now add all these pairs to the final list
				for (int j = 0; j < temp.size(); j++) {
					pairs.add(new Pair(temp.get(j) + 1, i));
				}
			}
			// Add the current index to the list
			temp.add(i);
			// Add the current key-value pair to the map
			sumMap.put(cumulativeSum, temp);
		}
		return pairs;
	}

	/**
	 * This class represents one such pair of start and end indexes of subarray for
	 * which the sum of elements is zero
	 */
	class Pair {
		// Start index of the subarray
		private int start;
		// End index of the subarray
		private int end;

		/**
		 * Default constructor that will create an object that will store the start and
		 * end index of the subarray
		 */
		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
		/**
		 * @return the start
		 */
		public int getStart() {
			return start;
		}
		/**
		 * @return the end
		 */
		public int getEnd() {
			return end;
		}
	}
}
