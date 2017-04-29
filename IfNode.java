
public class IfNode extends Node {
	
	IfNode() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	int accept(NodeVisitorWorker visitor) {
		// TODO Auto-generated method stub
		if (visitor.flags[0] == 0){
			return visitor.visit(this);
		}
		return 0;
	}




}
