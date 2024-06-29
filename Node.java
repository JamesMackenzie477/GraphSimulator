// Java implementation of a graph node.
public class Node<T extends Node<T>> implements java.lang.Iterable<T>
{
	// A set of nodes that this node instance is connected to.
	public java.util.LinkedList<T> edges = new java.util.LinkedList<T>();

	// Adds a connection to the specified node.
	public boolean addEdge(T node) { return this.edges.add(node); }

	// Removes the connection to the specified node.
	public boolean removeEdge(T node) { return this.edges.remove(node); }

	// Returns an iterator fo our list of edges.
	// Allows this class to be used in a foreach loop.
	public java.util.Iterator<T> iterator()
	{
		// Returns the node iterator.
		return edges.iterator();
	}
}