 
public class AssignNode extends Node {

	AssignNode() {
		super(2);
	}

	public int accept(NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			visitor.visit(this);
		}
		return -1;
	}


}
