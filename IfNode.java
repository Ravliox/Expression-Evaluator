/**
 * Node used for the if implementation
 * @author magni
 *
 */
public class IfNode extends Node {
	
	IfNode() {
		super(3);
	}

	@Override
	int accept(NodeVisitorWorker visitor) {
		if (visitor.flags[0] == 0){
			return visitor.visit(this);
		}
		return 0;
	}




}
