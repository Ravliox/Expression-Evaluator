
public class ArgumentNode extends Node {
		
	String value;										// keep it as a string in case it's a variable ex 'x'
	
	public void accept(NodeVisitor visitor) {
		// does nothing, it's a leaf
		
	}

	public ArgumentNode(String value) {
		super (null);
		this.value = value;
	}
}
