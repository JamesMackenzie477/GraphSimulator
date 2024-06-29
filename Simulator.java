// The front end of the graph simulator.
// This will display the graph in a window.
public class Simulator
{
	// Stores the game window.
	private static Window window;

	// The main entry point of the program.
	public static void main(String[] args)
	{
		// Stores the graph.
		Graph<WindowNode> graph;
		// Gets the graph type to display.
		String graphType = args[0];
		// Creates the graph.
		switch (graphType)
		{
			default: graph = CreateFirstGraph(); break;
			case "2": graph = CreateSecondGraph(); break;
			case "3": graph = CreateThirdGraph(); break;
			case "4": graph = CreateFourthGraph(); break;
			case "5": graph = CreateFifthGraph(); break;
		}
		// Creates the graph display.
		GraphDisplay display = new GraphDisplay(graph);
		// Shows the graph to the user.
		display.show();
		// Gets input from the user.
		java.util.Scanner reader = new java.util.Scanner(System.in);
		// Prints the graph state.
		System.out.println("\nGraph State:"); printGraphState(graph);
		// Stores the graph traversal.
		java.util.LinkedList<WindowNode> t;
		// Prompts the user.
		System.out.print("\n1. Display depth first traversal.\n\n2. Display breadth first traversal.\n\nPlease select an option: ");
		// Gets the user's option.
		String userOption = reader.nextLine();
		// Prompts the user for the node.
		System.out.print("\nPlease enter the starting node: ");
		// Gets the starting node.
		WindowNode node = getNode(graph, reader.nextLine());
		// Gets the first node if no node was found.
		if (node == null) node = graph.getNode(0);
		// Parses the user's option.
		switch (userOption)
		{
			default: t = graph.breadthFirstTraversal(node); break;
			case "2": t = graph.depthFirstTraversal(node); break;
		}
		display.showTraversal(t);
		printGraphTraversal(t);
	}

	// Prints the state of the given Graph.
	private static void printGraphState(Graph<WindowNode> g)
	{
		/* 
		 * This function was going to originally use the toString() method for the Graph class.
		 * This toString() method was to be overrided to return a formatted string of the Graph nodes and their edges.
		 * However, as I made the decision for the class type of a node to be decided by the programmer,
		 * this way they can have their own attributes associated with each node, means that these attributes are abstracted to the Graph class.
		 * Thus, the Graph class cannot create a formatted string of node names, as the names of the nodes do not exist to the Graph class.
		 */

		// Enumerates through the nodes.
		for(WindowNode n : g)
		{
			// Prints the name of the node.
			System.out.print(n.getName() + " -> ");
			// Enumerates through the node's edges.
			for(WindowNode e : n)
				// Prints the edge
				System.out.print(e.getName() + ", ");
			// Creates a new line.
			System.out.println();
		}
	}

	// Prints the given graph traversal.
	private static void printGraphTraversal(java.util.LinkedList<WindowNode> t)
	{
		// Enumerates through the nodes.
		for(WindowNode n : t)
		{
			// Prints the name of the node.
			System.out.print(n.getName() + ", ");
		}
	}

	// Gets a node from the given graph.
	private static WindowNode getNode(Graph<WindowNode> g, String name)
	{
		// Iterates through the graph nodes.
		for (WindowNode n : g)
			// If the node's name is equal to the given name.
			if (n.getName().equals(name))
				// Return the node.
				return n;
		// No node was found.
		return null;
	}

	// Creates the first graph example.
	private static Graph<WindowNode> CreateFirstGraph()
	{
		// Creates the graph.
		Graph<WindowNode> g = new Graph<WindowNode>();
		// Creates the nodes.
		WindowNode a = new WindowNode("A", "#0000FF", 50, 50);
		WindowNode b = new WindowNode("B", "#0000FF", 200, 50);
		WindowNode c = new WindowNode("C", "#0000FF", 50, 200);
		WindowNode d = new WindowNode("D", "#0000FF", 200, 200);
		// Adds the nodes.
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);
		// Adds the edges.
		g.addEdge(a, b);
		g.addEdge(b, d);
		g.addEdge(d, c);
		g.addEdge(c, a);
		// Returns the graph.
		return g;
	}

	// Creates the second graph example.
	private static Graph<WindowNode> CreateSecondGraph()
	{
		// Creates the graph.
		Graph<WindowNode> g = new Graph<WindowNode>();
		// Creates the nodes.
		WindowNode e = new WindowNode("E", "#0000FF", 125, 50);
		WindowNode f = new WindowNode("F", "#0000FF", 200, 125);
		WindowNode g_n = new WindowNode("G", "#0000FF", 175, 200);
		WindowNode h = new WindowNode("H", "#0000FF", 75, 200);
		WindowNode i = new WindowNode("I", "#0000FF", 50, 125);
		// Adds the nodes.
		g.addNode(e);
		g.addNode(f);
		g.addNode(g_n);
		g.addNode(h);
		g.addNode(i);
		// Adds the edges.
		g.addEdge(e, f);
		g.addEdge(e, g_n);
		g.addEdge(e, h);
		g.addEdge(e, i);
		g.addEdge(f, g_n);
		g.addEdge(f, h);
		g.addEdge(f, i);
		g.addEdge(g_n, h);
		g.addEdge(g_n, i);
		g.addEdge(h, i);
		// Returns the graph.
		return g;
	}

	// Creates the third graph example.
	private static DirectedGraph<WindowNode> CreateThirdGraph()
	{
		// Creates the graph.
		DirectedGraph<WindowNode> g = new DirectedGraph<WindowNode>();
		// Creates the nodes.
		WindowNode j = new WindowNode("J", "#0000FF", 225, 50);
		WindowNode m = new WindowNode("M", "#0000FF", 400, 225);
		WindowNode l = new WindowNode("L", "#0000FF", 225, 400);
		WindowNode k = new WindowNode("K", "#0000FF", 50, 225);
		// Adds the nodes.
		g.addNode(j);
		g.addNode(m);
		g.addNode(l);
		g.addNode(k);
		// Adds the edges.
		g.addEdge(j, k);
		g.addEdge(k, l);
		g.addEdge(l, m);
		g.addEdge(m, j);
		// Returns the graph.
		return g;
	}

	// Creates the fourth graph example.
	private static DirectedGraph<WindowNode> CreateFourthGraph()
	{
		// Creates the graph.
		DirectedGraph<WindowNode> g = new DirectedGraph<WindowNode>();
		// Creates the nodes.
		WindowNode j = new WindowNode("J", "#0000FF", 225, 50);
		WindowNode m = new WindowNode("M", "#0000FF", 400, 225);
		WindowNode l = new WindowNode("L", "#0000FF", 225, 400);
		WindowNode k = new WindowNode("K", "#0000FF", 50, 225);
		// Adds the nodes.
		g.addNode(j);
		g.addNode(m);
		g.addNode(l);
		g.addNode(k);
		// Adds the edges.
		g.addEdge(j, m);
		g.addEdge(m, l);
		g.addEdge(l, k);
		g.addEdge(k, j);
		g.addEdge(m, j);
		g.addEdge(k, k);
		g.addEdge(m, m);
		// Returns the graph.
		return g;
	}

	// Creates the fifth graph example.
	private static DirectedGraph<WindowNode> CreateFifthGraph()
	{
		// Creates the graph.
		DirectedGraph<WindowNode> g = new DirectedGraph<WindowNode>();
		// Creates the nodes.
		WindowNode a = new WindowNode("0", "#0000FF", 210, 50);
		WindowNode b = new WindowNode("1", "#0000FF", 50, 75);
		WindowNode c = new WindowNode("2", "#0000FF", 400, 80);
		WindowNode d = new WindowNode("3", "#0000FF", 55, 400);
		WindowNode e = new WindowNode("4", "#0000FF", 200, 350);
		WindowNode f = new WindowNode("5", "#0000FF", 400, 400);
		// Adds the nodes.
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);
		g.addNode(e);
		g.addNode(f);
		// Adds the edges.
		g.addEdge(a, b);
		g.addEdge(a, c);
		g.addEdge(b, d);
		g.addEdge(c, a);
		g.addEdge(c, e);
		g.addEdge(e, b);
		g.addEdge(e, d);
		g.addEdge(e, f);
		g.addEdge(f, f);
		// Returns the graph.
		return g;
	}
}