import java.util.ArrayList;
import java.util.Stack;

public abstract class Node {
	
	ArrayList<Node> arguments;					// field for operation nodes
	int nr_argument;						// field for argument nodes
	String value;
	Stack<Node> t = new Stack<Node>();
	
	Node (int no_arguments){
		this.arguments = new ArrayList<Node>(no_arguments);
		this.nr_argument = no_arguments;
	}
	
	abstract int accept (NodeVisitorWorker visitor);
	
//	void setParameters(String[] args){
//		for (int i = 0; i < args.length; i++){
//			String[] argumentList = new String[args.length - i];
//			System.out.println(args[i]);
//			
//			if (Symbols.indexOf(args[i]) < 0){
//				argumentList[0] = args[i];
//				arguments[i] = new ArgumentNode();
//				arguments[i].value = argumentList[0];
//			}
//			else{
//				int j = 0;
//				System.out.println(j);
//				
//				while (argumentList[j].charAt(argumentList[j].length() - 1) != ']'){
//					System.out.println(j);
//					argumentList[j] = args[i + j + 1];
//					j += 1;
//				}
//				
//				arguments[i] = NodeFactory.createNode(args[i], argumentList);
//				i += argumentList.length + 2;
//			}
//		}
//	}
	// [+ 1 [* 3 2] ]
	// [+ 1 [+ 1 [+ 3 2]]]
}






