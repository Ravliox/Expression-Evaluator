/**
 * Node used for setting the return value of the program
 * If it doesn't exist the flag for it will be 0
 * @author magni
 *
 */


public class ReturnNode extends Node {
	

	ReturnNode() {
		super(1);
	}

	public int accept (NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			visitor.visit(this);
		}
		return -1;
			
	
	}

}
