import java.util.ArrayList;

/**
 * Abstract class for the Nodes in our Abstract Syntax Trees
 * @author magni
 *
 */

public abstract class Node {
	
	ArrayList<Node> arguments;					// List of children
	int nr_argument;							// Number of children
	String value;								// Used for the argument leaves
	
	
	/**
	 * Constructor
	 * @param no_arguments sets the number of children in the arguments list
	 */
	Node (int no_arguments){
		this.arguments = new ArrayList<Node>(no_arguments);
		this.nr_argument = no_arguments;
	}
	
	/**
	 * Abstract acceptor for visitor
	 * @param visitor
	 * @return the value of the visitor.visit(), codified as an int
	 */
	abstract int accept (NodeVisitorWorker visitor);
	
}






