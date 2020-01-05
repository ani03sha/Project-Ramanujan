package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.redquark.ramanujan.mustdos._016OverlappingRectangles.Point;

/**
 * @author Anirudh Sharma
 *
 */
class _016OverlappingRectanglesTest {

	private _016OverlappingRectangles overlappingRectangles = new _016OverlappingRectangles();

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.mustdos._016OverlappingRectangles#areOverlapping(org.redquark.ramanujan.mustdos._016OverlappingRectangles.Point, org.redquark.ramanujan.mustdos._016OverlappingRectangles.Point, org.redquark.ramanujan.mustdos._016OverlappingRectangles.Point, org.redquark.ramanujan.mustdos._016OverlappingRectangles.Point)}.
	 */
	@Test
	void testAreOverlapping() {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);
		assertTrue(overlappingRectangles.areOverlapping(l1, r1, l2, r2));
	}

}
