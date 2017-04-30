/**
 * Program sequence Node
 * @author magni
 *
 */


public class NothingNode extends Node {
	
	


	NothingNode() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public int accept (NodeVisitorWorker visitor){
		for (Node t : arguments){
			if (visitor.flags[0] == 0)
				t.accept(visitor);
		}
		return -1;
	}


}
