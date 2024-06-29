// Represents a 2D node in the window space.
public class WindowNode extends Node<WindowNode>
{
	// Stores the name of the node.
	private String name;
	// Stores the colour of the node.
	private String colour;
	// Stores the location of the node.
	private double x, y;

	// Creates a new node.
	WindowNode(String name, String colour, double x, double y)
	{
		this.name = name;
		this.colour = colour;
		this.x = x; this.y = y;
	}

	// Getter for the attributes of the node.
	public String getName() { return this.name; }
	public String getColour() { return this.colour; }
	public double getXPos() { return this.x; }
	public double getYPos() { return this.y; }
}