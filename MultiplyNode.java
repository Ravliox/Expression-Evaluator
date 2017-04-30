/**
 * Node used for multiplication of two values
 * @author magni
 * 
 */


public class MultiplyNode extends Node {
	
	MultiplyNode() {
		super(2);
	}

	public int accept (NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			return visitor.visit(this);
		}
		return -1;

	}

}
