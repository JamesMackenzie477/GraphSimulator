// Used to create a window and display graphs.
public class GraphDisplay extends GameArena
{
	// The node size constant.
	final static int nodeSize = 20;
	// The line size constant.
	final static int lineSize = 1;
	// The line colour constant.
	final static String lineColour = "#FF0000";

	// Stores the graph that is being displayed.
	private Graph<WindowNode> graph;

	// Creates a new window.
	public GraphDisplay(Graph<WindowNode> graph)
	{
		// Calculates the window width and height and calls our parent, GameArena.
		super((int)getGraphWidth(graph) + (int)getGraphLeft(graph), (int)getGraphHeight(graph) + (int)getGraphTop(graph));
		// Sets the current graph to the graph given by the user.
		this.graph = graph;
		// Displays the graph.
		// show();
	}

	// Displays the given undirected graph.
	public void show()
	{
		// Iterates through the graph nodes.
		for (WindowNode n : this.graph)
		{
			// Gets the positions.
			double nPosX = n.getXPos();
			double nPosY = n.getYPos();
			// Iterates through the nodes edges.
			for (WindowNode e : n)
			{
				// Gets the positions.
				double ePosX = e.getXPos();
				double ePosY = e.getYPos();
				// if node is connected to itself then do something else.
				if (e == n)
				{
					// Creates a circle outline to represent a self arc.
					addBall(new Ball(nPosX - (nodeSize / 2), nPosY - (nodeSize / 2), nodeSize, lineColour));
					addBall(new Ball(nPosX - (nodeSize / 2), nPosY - (nodeSize / 2), nodeSize - lineSize, "#000000"));
				}
				else
				{
					// Calculates the edge offsets.
					int offX = /*((n.getXPos() < e.getXPos()) ? -nodeSize : ((n.getXPos() == e.getXPos()) ? 0 : nodeSize));*/ 0;
					int offY = /*((n.getYPos() < e.getYPos()) ? -nodeSize : ((n.getYPos() == e.getYPos()) ? 0 : nodeSize));*/ 0;
					// Checks the type of graph we are using.
					if (this.graph instanceof DirectedGraph)
					{
						// Adds the edge to the screen.
						new Arrow(nPosX - offX, nPosY - offY, ePosX + offX, ePosY + offY, lineSize, lineColour, this);
					}
					else
					{
						// Adds the edge to the screen.
						addLine(new Line(nPosX - offX, nPosY - offY, ePosX + offX, ePosY + offY, lineSize, lineColour));
					}
				}
			}
		}
		// Iterates through the graph nodes.
		for (WindowNode n : this.graph)
		{
			// Gets the positions.
			double nPosX = n.getXPos();
			double nPosY = n.getYPos();
			// Calculates the text offset (this just works...).
			double textOffset = ((nodeSize / 2) - (nodeSize / 5));
			// Adds the node to the screen.
			addBall(new Ball(nPosX, n.getYPos(), nodeSize, n.getColour()));
			addText(new Text(n.getName(), nPosX - textOffset, nPosY + textOffset, nodeSize, "#FFFFFF"));
		}
		// Updates the window.
		update();
	}

	// Displays the depth traversal for the given node.
	public void showDepthTraversal(WindowNode node)
	{
		// Shows the traversal.
		showTraversal(this.graph.depthFirstTraversal(node));
	}

	// Displays the depbreadth traversal for the given node.
	public void showBreadthTraversal(WindowNode node)
	{
		// Shows the traversal.
		showTraversal(this.graph.breadthFirstTraversal(node));
	}

	// Displays the traversal.
	public void showTraversal(java.util.LinkedList<WindowNode> traversal)
	{
		// Iterates through the traversal list of nodes.
		for (int i = 0; i < traversal.size(); i++)
		{
			// Gets the node.
			WindowNode n = traversal.get(i);
			// Gets the positions.
			double nPosX = n.getXPos();
			double nPosY = n.getYPos();
			// Adds text displaying the index of the node.
			addText(new Text(Integer.toString(i), nPosX - nodeSize, nPosY - nodeSize, nodeSize, "#FFFFFF"));
		}
		// Updates the window.
		update();
	}

	// Internal functions used by the class to find certain information about the given graph ADT
	// in order to construct a valid window and graph.

	// Gets the left most point of the graph.
	private static double getGraphLeft(Graph<WindowNode> graph)
	{
		// Stores the left most point.
		double left = 0;
		// Intialises the left most point with the X value of the first node.
		for (WindowNode n : graph) { left = n.getXPos() - nodeSize; break; }
		// Enumerates through the nodes.
		for (WindowNode n : graph)
		{
			// Gets the node's position.
			double xPos = n.getXPos() - nodeSize;
			// If it's less than the current left most point then we update the value.
			if (xPos < left) left = xPos;
		}
		// Returns the left most point.
		return left;
	}

	// Gets the top most point of the graph.
	private static double getGraphTop(Graph<WindowNode> graph)
	{
		// Stores the top most point.
		double top = 0;
		// Intialises the top most point with the Y value of the first node.
		for (WindowNode n : graph) { top = n.getYPos() - nodeSize; break; }
		// Enumerates through the nodes.
		for (WindowNode n : graph)
		{
			// Gets the node's position.
			double xPos = n.getYPos() - nodeSize;
			// If it's less than the current top most point then we update the value.
			if (xPos < top) top = xPos;
		}
		// Returns the top most point.
		return top;
	}

	// Gets the width of the graph.
	private static double getGraphWidth(Graph<WindowNode> graph)
	{
		// Stores the graph width.
		double width = 0;
		// Enumerates through the nodes.
		for (WindowNode n : graph)
		{
			// Gets the node's position.
			double xPos = n.getXPos() + nodeSize;
			// If it's greater than the current width then we update the width.
			if (xPos > width) width = xPos;
		}
		// Returns the width.
		return width;
	}

	// Gets the height of the graph.
	private static double getGraphHeight(Graph<WindowNode> graph)
	{
		// Stores the graph height.
		double height = 0;
		// Enumerates through the nodes.
		for (WindowNode n : graph)
		{
			// Gets the node's position.
			double yPos = n.getYPos() + nodeSize;
			// If it's greater than the current height then we update the height.
			if (yPos > height) height = yPos;
		}
		// Returns the height.
		return height;
	}

	// Displays the given directed graph.
	// This uses parameter overloading to achieve a different result depending on the graph type.
	// Removed for code reuse as it was basically a complete copy of the DisplayGraph(Graph<WindowNode> graph) method with few changes.
	// Functionality has been added to DisplayGraph(Graph<WindowNode> graph) to achieve the same result, but with less code.
	// public void DisplayGraph(DirectedGraph<WindowNode> graph)
	// {
	// 	// Iterates through the graph nodes.
	// 	for (WindowNode n : graph)
	// 	{
	// 		// Gets the positions.
	// 		double nPosX = n.getXPos();
	// 		double nPosY = n.getYPos();
	// 		// Iterates through the nodes edges.
	// 		for (WindowNode e : n)
	// 		{
	// 			// Gets the positions.
	// 			double ePosX = e.getXPos();
	// 			double ePosY = e.getYPos();
	// 			// if node is connected to itself then do something else.
	// 			if (e == n)
	// 			{
	// 				// Creates a circle outline to represent a self arc.
	// 				addBall(new Ball(nPosX - (nodeSize / 2), nPosY - (nodeSize / 2), nodeSize, lineColour));
	// 				addBall(new Ball(nPosX - (nodeSize / 2), nPosY - (nodeSize / 2), nodeSize - lineSize, "#000000"));
	// 			}
	// 			else
	// 			{
	// 				// Calculates the arrow offsets.
	// 				int offX = /*((n.getXPos() < e.getXPos()) ? -nodeSize : ((n.getXPos() == e.getXPos()) ? 0 : nodeSize));*/ 0;
	// 				int offY = /*((n.getYPos() < e.getYPos()) ? -nodeSize : ((n.getYPos() == e.getYPos()) ? 0 : nodeSize));*/ 0;
	// 				// Adds the edge to the screen.
	// 				new Arrow(nPosX - offX, nPosY - offY, ePosX + offX, ePosY + offY, lineSize, lineColour, this);
	// 			}
	// 		}
	// 	}
	// 	// Iterates through the graph nodes.
	// 	for (WindowNode n : graph)
	// 	{
	// 		// Gets the positions.
	// 		double nPosX = n.getXPos();
	// 		double nPosY = n.getYPos();
	// 		// Calculates the text offset (this just works...).
	// 		double textOffset = ((nodeSize / 2) - (nodeSize / 5));
	// 		// Adds the node to the screen.
	// 		addBall(new Ball(nPosX, nPosY, nodeSize, n.getColour()));
	// 		addText(new Text(n.getName(), nPosX - textOffset, nPosY + textOffset, nodeSize, "#FFFFFF"));
	// 	}
	// 	// Updates the window.
	// 	update();
	// }
}