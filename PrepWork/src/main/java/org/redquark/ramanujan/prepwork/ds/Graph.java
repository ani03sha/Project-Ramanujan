package org.redquark.ramanujan.prepwork.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class Graph<T> {

	// List of nodes in the Graph
	@SuppressWarnings("rawtypes")
	protected List<Node> nodes = new ArrayList<>();
	// Number of nodes in the Graph
	private int numberOfNodes;

	/**
	 * This method checks if there are more than 1 node. If there aren’t any more
	 * than 1 node, then a connection cannot be made as a node cannot have an edge
	 * towards itself. It has to have a connection with another node.
	 */
	public boolean checkForAvailability() {
		return this.numberOfNodes > 1;
	}

	/**
	 * This method takes an argument of type Node and adds that node to the nodes
	 * List. After the node has been added, the current graph increments the number
	 * of nodes by 1. That way, we can evaluate the checkForAvailability() method to
	 * true at some point.
	 * 
	 * @param <T>
	 */
	public void createNode(T data) {
		// Create an instance of the Node
		Node<T> node = new Node<>(data);
		// Add the new node to the list of nodes
		this.nodes.add(node);
		// Increment the number of nodes in the Graph by 1
		this.numberOfNodes++;
	}

	/**
	 * This method returns the number of nodes in the Graph
	 */
	public int getNumberOfNodes() {
		return this.numberOfNodes;
	}

	/**
	 * This method adds a neighbor as per the start and end node passed
	 */
	public void addNeighbors(Node<T> start, Node<T> end, double weight) {
		// Creating an instance of the edge
		Edge<T> e = new Edge<>(start, end, weight);
		// Adding end node as the neighbor of start node
		start.addNeighbor(e);
	}

	/**
	 * This method returns the neighbors of the given node
	 */
	public String getNeighbors(Node<T> node) {
		return node.getNeighbors();
	}

	/**
	 * This method deletes the all the nodes in the graph
	 */
	public void clear() {
		this.nodes.clear();
		this.numberOfNodes = 0;
	}

	private static class Edge<T> {

		// Start node (From which the edge starts)
		private Node<T> start;
		// End node (Where the edge ends)
		private Node<T> end;
		// Weight of the edge
		private double weight;

		public Edge(Node<T> start, Node<T> end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		/**
		 * @return the data at the start node
		 */
		public T getStart() {
			return this.start.getData();
		}

		/**
		 * @return the data at the end node
		 */
		public T getEnd() {
			return this.end.getData();
		}

		/**
		 * @return the weight
		 */
		public double getWeight() {
			return this.weight;
		}

	}

	protected static class Node<T> {

		// Data to be stored in the Node
		private T data;
		// Neighbors of this node (connected via edges)
		private List<Edge<T>> neighbors = new ArrayList<>();

		/**
		 * Default constructor
		 */
		Node(T data) {
			this.data = data;
		}

		/**
		 * @return the data
		 */
		public T getData() {
			return this.data;
		}

		/**
		 * This method creates a connection via an edge which is passed as a parameter
		 * to another node. It is done by adding the specified edge to the List of edges
		 * in the Node class.
		 */
		public void addNeighbor(Edge<T> e) {
			// If not, then we can add the edge to the neighbors list
			this.neighbors.add(e);

		}

		/**
		 * This method returns the neighbors of the current node
		 */
		public String getNeighbors() {
			// This will store the String representation of the adjacency list of the
			// current node. Each edge will be appended with its respective weight.
			StringBuilder nodes = new StringBuilder();
			// Loop through the adjacency list of this node
			for (int i = 0; i < this.neighbors.size(); i++) {
				// Appended the node's end data along with the weight of the edge
				nodes.append(neighbors.get(i).getStart() + "=" + "(" + neighbors.get(i).getWeight() + ")=>"
						+ neighbors.get(i).getEnd()).append(" ");
			}
			return nodes.toString();
		}
	}
}
