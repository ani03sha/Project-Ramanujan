package org.redquark.ramanujan.prepwork.algo;

/**
 * @author Anirudh Sharma
 *
 */
public class QuickSort {

	/**
	 * This method implements Quick Sort algorithm to sort an array
	 * 
	 * low --> Starting index, high --> Ending index 
	 * quickSort(arr[], low, high) {
	 * if (low < high) { 
	 * pi is partitioning index, arr[pi] is now at right place 
	 * pi = partition(arr, low, high);
	 * quickSort(arr, low, pi - 1); // Before pi 
	 * quickSort(arr, pi + 1, high); // After pi } }
	 */
	public <T extends Comparable<T>> T[] sort(T[] arr, int low, int high) {

		if (low < high) {

			// Getting the partition index
			int partitionIndex = partition(arr, low, high);

			// Recursively sort elements before and after partition
			sort(arr, low, partitionIndex - 1);
			sort(arr, partitionIndex + 1, high);
		}

		return arr;
	}

	/**
	 * This method returns the partition index where the array segregates
	 * 
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot 
	 * partition (arr[],low, high) { 
	 * // pivot (Element to be placed at right position) 
	 * pivot = arr[high];
	 * i = (low - 1) // Index of smaller element
	 * for (j = low; j <= high- 1; j++) { 
	 * // If current element is smaller than the pivot 
	 * if (arr[j] < pivot) { 
	 * 		i++; // increment index of smaller element 
	 * swap arr[i] and arr[j] 
	 * 		} 
	 * } 
	 * 
	 * swap arr[i + 1] and arr[high]) 
	 * 
	 * return (i + 1) }
	 */
	private <T extends Comparable<T>> int partition(T[] arr, int low, int high) {

		// Setting the pivot as the last element in the array
		T pivot = arr[high];

		// Index of smaller element
		int index = low - 1;

		for (int i = low; i < high; i++) {
			// If the current element is less than the pivot
			if (arr[i].compareTo(pivot) < 0) {
				index++;

				// Swapping arr[index] and arr[j]
				T temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}

		// Swap arr[index + 1] and pivot
		T temp = arr[index + 1];
		arr[index + 1] = arr[high];
		arr[high] = temp;

		return (index + 1);
	}
}
