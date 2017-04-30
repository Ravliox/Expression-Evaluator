/**
 * Node used for determining whether a value is less than another
 * @author magni
 *
 */

public class LessNode extends Node {
	
	LessNode() {
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
