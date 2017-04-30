import java.io.PrintWriter;
import java.util.Stack;

/**
 * Class used for parsing expressions and writing in files
 * @author magni
 *
 */

public class Expression {
	
	Node tree;													// Our Abstract Syntax Tree
	
	/**
	 * constructor and line parser. it creates our tree as it reads the line
	 * @param line_read line read from the file
	 */
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
	
	/**
	 * evaluation function
	 * @param out PrintWriter for our .out file
	 */
	void evaluate(PrintWriter out){
		NodeVisitorWorker visitor = NodeVisitorWorker.getInstance();
		tree.accept(visitor);
		
		if (visitor.flags[0] == 1){
			out.print("Check failed");
		}
		else if (visitor.flags[2] == 0){
			out.print("Missing return");
		}
		else if (visitor.flags[1] == 1){
			out.print("Assert failed");
		}
		else{
			out.print(visitor.return_value);
		}
		
	}
		
}
