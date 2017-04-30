
public class AddNode extends Node{
	
	AddNode() {
		super(2);
	}
	
	public int accept (NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			return visitor.visit(this);
		}
		return -1;

	}
		

}


