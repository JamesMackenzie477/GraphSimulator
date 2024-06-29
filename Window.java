// Used to create a window and display graphs.
public class Window extends GameArena
{
	// The node size constant.
	final int nodeSize = 20;
	// The line size constant.
	final int lineSize = 1;
	// The line colour constant.
	final String lineColour = "#FF0000";

	// Creates a new window.
	public Window(int width, int height)
	{
		// Passes the arguments to the parent.
		super(width, height);
	}

	// Displays the given undirected graph.
	public void displayGraph(Graph<WindowNode> graph)
	{
		// Iterates through the graph nodes.
		for (WindowNode n : graph)
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
					if (graph instanceof DirectedGraph)
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
		for (WindowNode n : graph)
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

	// Displays the given traversal
	public void displayTraversal(java.util.LinkedList<WindowNode> traversal)
	{
		int index = 0;
		for (WindowNode n : traversal)
		{
			// Gets the positions.
			double nPosX = n.getXPos();
			double nPosY = n.getYPos();

			addText(new Text(Integer.toString(index), nPosX - nodeSize, nPosY - nodeSize, nodeSize, "#FFFFFF"));

			index += 1;
		}
		// Updates the window.
		update();
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