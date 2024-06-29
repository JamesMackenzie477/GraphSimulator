// Java implementation of a graph ADT.
// This is a template class that accepts any type of T to represent a node in the graph,
// this allows for generic arbitrary data to be stored at each node.
public class Graph<T extends Node<T>> implements java.lang.Iterable<T>
{
	// The set of nodes within the graph.
	public java.util.LinkedList<T> nodes = new java.util.LinkedList<T>();

	// Adds a node to the graph.
	public boolean addNode(T node)
	{
		// Adds the node and returns the result.
		return this.nodes.add(node);
	}

	// Removes a node from the graph.
	public boolean removeNode(T node)
	{
		// Enumerates through the exisiting nodes to remove any edges connecting to this node.
		for(T n : this.nodes) n.removeEdge(node);
		// Removes the node.
		return this.nodes.remove(node);
	}

	// Adds an edge to the specified node.
	public boolean addEdge(T node, T edge)
	{
		// Adds the edge to the target node.
		for(T n : this.nodes) if (n == edge) n.addEdge(node);
		// Adds the edge to the target node.
		return node.addEdge(edge);
	}

	// Removes an edge from the specified node.
	public boolean removeEdge(T node, T edge)
	{
		// Removes the edge from the target node.
		for(T n : this.nodes) if (n == edge) n.removeEdge(node);
		// Removes the edeg to the target node.
		return node.removeEdge(edge);
	}

	// Returns the node at the given index.
	public T getNode(int index)
	{
		return this.nodes.get(index);
	}

	// Returns an iterator fo our list of nodes.
	// Allows this class to be used in a foreach loop.
	public java.util.Iterator<T> iterator()
	{
		// Returns the graph iterator.
		return nodes.iterator();
	}

	// Recursive methods used for depth first traversal.
	private void depthFirstTraversalRecursive(T node, java.util.LinkedList<T> traversed)
	{
		// Adds the nodes to the traversed set.
		traversed.add(node);
		// Iterates through the node's edges.
		for(T n : node)
		{
			// If the node has not yet been visited.
			if (!traversed.contains(n))
			{
				// Visit the node.
				depthFirstTraversalRecursive(n, traversed);
			}
		}
	}

	// Traverses the graph in terms of depth.
	public java.util.LinkedList<T> depthFirstTraversal(T node)
	{
		// Stores the traversed nodes.
		java.util.LinkedList<T> traversed = new java.util.LinkedList<T>();
		// Calls the recursive traversal method.
		depthFirstTraversalRecursive(node, traversed);
		// Returns the traversed nodes.
		return traversed;

	}

	// Traverses the graph in terms of breadth.
	public java.util.LinkedList<T> breadthFirstTraversal(T node)
	{
		// Stores the traversed nodes.
		java.util.LinkedList<T> traversed = new java.util.LinkedList<T>();
		// Creates a queue to only store visited nodes.
		java.util.LinkedList<T> queue = new java.util.LinkedList<T>();
		// Adds the node as the first item in the queue.
		queue.add(node);
		// Adds it to the traversed list, so it will not be traversed again.
		traversed.add(node);
		// Traverses while the queue isn't empty.
		while (queue.size() > 0)
		{
			// Gets the next node from the queue and traverses it.
			T n = queue.poll();
			// Iterates through the node's edges.
			for(T e : n)
			{
				// If the node has not yet been visited.
				if (!traversed.contains(e))
				{
					// Add it to the queue.
					queue.add(e);
					// Ensures it is not traversed again.
					traversed.add(e);
				}
			}

		}
		// Returns the order of traversal.
		return traversed;
	}
}