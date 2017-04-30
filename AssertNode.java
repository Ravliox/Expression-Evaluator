/**
 * Node used for assertion of a boolean expression
 * @author magni
 *
 */


public class AssertNode extends Node {
	

	AssertNode() {
		super(1);
	}
	
	public int accept (NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			boolean rez = visitor.visit(this);
			if (rez == true){
				return 1;
			}
			else {
				return -1;
			}
		}
		return -1;
	}


}
