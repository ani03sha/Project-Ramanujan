package org.redquark.ramanujan.prepwork.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class GraphTest {

	private Graph<Integer> graph = new Graph<>();

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
 		// Add some nodes in the graph
		graph.createNode(23);
		graph.createNode(47);
		graph.createNode(19);
		graph.createNode(64);
		graph.addNeighbors(graph.nodes.get(0), graph.nodes.get(1), 49.8);
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Graph#checkForAvailability()}.
	 */
	@Test
	void testCheckForAvailability() {
		assertTrue(graph.checkForAvailability());
		graph.clear();
		assertFalse(graph.checkForAvailability());
		graph.createNode(5);
		assertFalse(graph.checkForAvailability());
		graph.createNode(6);
		assertTrue(graph.checkForAvailability());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Graph#createNode(java.lang.Object)}.
	 */
	@Test
	void testCreateNode() {
		graph.clear();
		assertFalse(graph.checkForAvailability());
		assertEquals(0, graph.getNumberOfNodes());
		graph.createNode(21);
		assertEquals(1, graph.getNumberOfNodes());
		graph.createNode(39);
		assertTrue(graph.checkForAvailability());
		assertEquals(2, graph.getNumberOfNodes());
		graph.createNode(43);
		assertEquals(3, graph.getNumberOfNodes());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Graph#getNumberOfNodes()}.
	 */
	@Test
	void testGetNumberOfNodes() {
		assertEquals(4, graph.getNumberOfNodes());
		graph.clear();
		assertEquals(0, graph.getNumberOfNodes());
		graph.createNode(88);
		assertEquals(1, graph.getNumberOfNodes());
		graph.createNode(42);
		graph.createNode(76);
		assertEquals(3, graph.getNumberOfNodes());
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Graph#addNeighbors(org.redquark.ramanujan.prepwork.ds.Graph.Node, org.redquark.ramanujan.prepwork.ds.Graph.Node, double, java.lang.Object)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testAddNeighbors() {
		graph.addNeighbors(graph.nodes.get(2), graph.nodes.get(3), 23.4);
		graph.addNeighbors(graph.nodes.get(2), graph.nodes.get(1), 21.9);
		assertEquals("19=(23.4)=>64 19=(21.9)=>47 ", graph.getNeighbors(graph.nodes.get(2)));
	}

	/**
	 * Test method for
	 * {@link org.redquark.ramanujan.prepwork.ds.Graph#getNeighbors(org.redquark.ramanujan.prepwork.ds.Graph.Node)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetNeighbors() {
		assertEquals("23=(49.8)=>47 ", graph.getNeighbors(graph.nodes.get(0)));
		graph.addNeighbors(graph.nodes.get(0), graph.nodes.get(3), 76.8);
		assertEquals("23=(49.8)=>47 23=(76.8)=>64 ", graph.getNeighbors(graph.nodes.get(0)));
	}

	/**
	 * Test method for {@link org.redquark.ramanujan.prepwork.ds.Graph#clear()}.
	 */
	@Test
	void testClear() {
		assertEquals(4, graph.getNumberOfNodes());
		assertTrue(graph.checkForAvailability());
		graph.clear();
		assertEquals(0, graph.getNumberOfNodes());
		assertFalse(graph.checkForAvailability());
	}

}
