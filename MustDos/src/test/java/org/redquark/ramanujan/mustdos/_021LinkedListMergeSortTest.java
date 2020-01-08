package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.mustdos._021LinkedListMergeSort.Node;

/**
 * @author Anirudh Sharma
 *
 */
class _021LinkedListMergeSortTest {

	private _021LinkedListMergeSort linkedListSorting;

	@BeforeEach
	void setUp() throws Exception {
		linkedListSorting = new _021LinkedListMergeSort();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedListSorting = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._021LinkedListMergeSort#sort(org.redquark.ramanujan.mustdos._021LinkedListMergeSort.Node)}.
	 */
	@Test
	void testSort() {
		Node headOfSortedList = linkedListSorting.sort(linkedListSorting.head);
		assertNull(headOfSortedList);
		
		linkedListSorting.add(1);
		linkedListSorting.add(2);
		linkedListSorting.add(3);
		linkedListSorting.add(4);
		linkedListSorting.add(5);
		linkedListSorting.add(6);
		linkedListSorting.add(7);
		
		headOfSortedList = linkedListSorting.sort(linkedListSorting.head);
		StringBuilder actual = new StringBuilder();
		while (headOfSortedList != null) {
			actual.append(headOfSortedList.data).append(" ");
			headOfSortedList = headOfSortedList.next;
		}
		assertEquals("1 2 3 4 5 6 7 ", actual.toString());
	}

}
