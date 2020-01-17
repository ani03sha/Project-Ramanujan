/**
 * 
 */
package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh
 *
 */
class _029StringRotationTest {
	
	private _029StringRotation rotation = new _029StringRotation();

	/**
	 * Test method for {@link org.redquark.ramanujan.mustdos._029StringRotation#isRotation(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testIsRotation() {
		String original = "IndiaVsAustralia";
		String rotated = "AustraliaVsIndia";
		assertFalse(rotation.isRotation(original, rotated));
		
		original = "IndiaVsEngland";
		rotated = "EnglandIndiaVs";
		assertTrue(rotation.isRotation(original, rotated));
	}

}
