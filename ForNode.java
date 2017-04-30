/**
 * Node used for the implementation of the for operation
 * @author magni
 *
 */
public class ForNode extends Node {
	
	ForNode() {
		super(4);
	}

	@Override
	int accept(NodeVisitorWorker visitor) {
		if (visitor.flags[0] == 0){
			return visitor.visit(this);
		}
		return 0;
	}




}
