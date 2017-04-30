/**
 * Leaf used for the symbols and the value.
 * @author magni
 *
 */

public class ArgumentNode extends Node {
			
	public ArgumentNode() {
		super(1);
	}
	
	public int accept (NodeVisitorWorker visitor){
		return visitor.visit(this);
	}
	
}
