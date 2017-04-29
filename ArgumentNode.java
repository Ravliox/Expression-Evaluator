public class ArgumentNode extends Node {
		
	String[] arguments;										// keep it as a string in case it's a variable ex 'x'
	
	public ArgumentNode() {
		super(1);
	}
	
	public int accept (NodeVisitorWorker visitor){
		return visitor.visit(this);
	}
	
}
