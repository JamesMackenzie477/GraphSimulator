// Java implementation of a directed graph ADT.
public class DirectedGraph<T extends Node<T>> extends Graph<T>
{
	// Adds an edge to the specified node.
	public boolean addEdge(T node, T edge) { return node.addEdge(edge);  }

	// Removes an edge from the specified node.
	public boolean removeEdge(T node, T edge) { return node.removeEdge(edge); }
}