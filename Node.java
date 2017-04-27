
public abstract class Node {
	
	Node[] arguments;
	
	Node (String[] args){
		this.arguments = new Node[args.length];
		setArguments (args);
	}
	// [+ 1 [* 3 2] ]
	void setArguments (String[] args){
		for (int i = 0; i < args.length; i++){
			if (Symbols.indexOf(args[i]) < 0){
				arguments[i] = new ArgumentNode(args[i]);
			}
		}
	}
		
	abstract void accept (NodeVisitor visitor);
}
