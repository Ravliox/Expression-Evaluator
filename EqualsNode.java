/**
 * Node used for determining whether two values are equal
 * @author magni
 *
 */
public class EqualsNode extends Node {
	
	EqualsNode() {
		super(2);
	}


	public int accept (NodeVisitorWorker visitor){
		if (visitor.flags[0] == 0){
			boolean rez = visitor.visit(this);
			if (rez == true){
				return 1;
			}
			else {
				return 0;
			}
		}
		return -1;
			
	}

}
