package org.redquark.ramanujan.mustdos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh
 *
 */
class _028StringPermutationsTest {
	
	private _028StringPermutations sp = new _028StringPermutations();

	@Test
	void test() {
		List<String> expected = Arrays.asList("123", "132", "213", "231", "312", "321");
		List<String> actual = sp.findPermutations("123");
		assertTrue(expected.equals(actual));
	}

}
