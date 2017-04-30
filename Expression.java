import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Expression {
	
	ArrayList<String> elements;
	String expression;
	Node tree;
	
	Expression (String line_read){
		System.out.println(line_read);
		Stack<Node> arguments = new Stack<Node>();
		
		String [] tokens = line_read.split("[\\s\\[\\]]+");
		int length = tokens.length;
		
		for (int i = 0; i < tokens.length - 1; i++){
			tokens[i] = tokens[i + 1];
		}
		length--;
		
		
		for (int i = length - 1; i >= 0; i--){
			if (Symbols.indexOf(tokens[i]) < 0){
				arguments.push(NodeFactory.createNode(tokens[i]));
				arguments.peek().value = tokens[i];
			}
			else{
				Node t = NodeFactory.createNode(tokens[i]);
				int k = t.nr_argument;
				while (k > 0){
					t.arguments.add(arguments.pop());
					k--;
				}
				arguments.push(t);
				arguments.peek().value = tokens[i];

			}
		}
		tree = arguments.pop();
		
	}
	
	void evaluate(PrintWriter out){
		NodeVisitorWorker visitor = NodeVisitorWorker.getInstance();
		tree.accept(visitor);
		if (visitor.flags[0] == 1){
			System.out.println("CHECK FAILED");
			out.print("Check failed");
		}
		else if (visitor.flags[2] == 0){
			System.out.println("MISSING RETURN");
			out.print("Missing return");
		}
		else if (visitor.flags[1] == 1){
			System.out.println ("Assert failed");
			out.print("Assert failed");
		}
		else{
			System.out.println(visitor.return_value);
			out.print(visitor.return_value);
		}
		
	}
	
	void printTree (){
		System.out.println(tree.value);
		for (Node t : tree.arguments){
			printTreeAux(t);
		}
	}
	
	void printTreeAux (Node t){
		if (t.arguments.size() == 0){
			System.out.print(t.value + " ");
			return;
		}
		else {
			System.out.println (t.value);
			for (Node tt : t.arguments){
				printTreeAux(tt);
			}
			System.out.println();
		}
		
	}
	


}
