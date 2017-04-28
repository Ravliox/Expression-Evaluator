
public abstract class Node {
	
	Node[] arguments;					// field for operation nodes
	String value;						// field for argument nodes
	
	Node (String[] args){
		this.arguments = new Node[args.length];
		
//		for (int i = 0; i < args.length; i++){
//			String[] argumentList = new String[args.length - i];
//			System.out.println(args[i]);
//			if (Symbols.indexOf(args[i]) < 0){
//				argumentList[0] = args[i];
//			}
//			else{
//				int j = 0;
//				while (argumentList[j].charAt(argumentList[j].length() - 1) != ']'){
//					System.out.println(j);
//					argumentList[j] = args[i + j + 1];
//					j += 1;
//				}
//			}
//			arguments[i] = NodeFactory.createNode(args[i], argumentList);
//			i += argumentList.length + 2;
//		}
	}
	
	void setParameters(String[] args){
		for (int i = 0; i < args.length; i++){
			String[] argumentList = new String[args.length - i];
			System.out.println(args[i]);
			if (Symbols.indexOf(args[i]) < 0){
				argumentList[0] = args[i];
				arguments[i] = new ArgumentNode(argumentList);
				arguments[i].value = argumentList[0];
			}
			else{
				int j = 0;
				System.out.println(j);
				while (argumentList[j].charAt(argumentList[j].length() - 1) != ']'){
					System.out.println(j);
					argumentList[j] = args[i + j + 1];
					j += 1;
				}
				arguments[i] = NodeFactory.createNode(args[i], argumentList);
				i += argumentList.length + 2;
			}
		}
	}
	// [+ 1 [* 3 2] 3]
		
	abstract void accept (NodeVisitor visitor);
}
