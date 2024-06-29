// Adds various methods to the graph class to allow it to be displayed in a window.
public class WindowBasedDirectedGraph extends DirectedGraph<WindowNode>
{
	// Returns the node matching the specified name.
	public WindowNode getNode(String name)
	{
		for (WindowNode n : this.nodes)
			if (n.getName().equals(name))
				return n;
		return null;
	}

	public String toString()
	{
		String s = new String();
		// Enumerates through the nodes.
		for(WindowNode n : this.nodes)
		{
			// Prints the name of the node.
			s += n.getName() + " -> ";
			// Enumerates through the node's edges.
			for(WindowNode e : n)
				// Prints the edge
				s += e.getName() + ", ";
			// Creates a new line.
			s += "\n";
		}
		return s;
	}
}