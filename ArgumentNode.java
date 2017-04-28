
public class ArgumentNode extends Node {
		
	String[] arguments;										// keep it as a string in case it's a variable ex 'x'
	
	public void accept(NodeVisitor visitor) {
		// does nothing, it's a leaf
		
	}

	public ArgumentNode(String[] value) {
		super(value);
	}
}
