import java.util.ArrayList;

public class Expression {
	
	ArrayList<String> elements;
	String expression;
	Node tree;
	
	
	Expression (String line_read){
		this.elements = new ArrayList<String>();
		this.expression = line_read;
		String[] arguments = this.expression.split(" ");
		String type = arguments[0];
		//System.out.println(type);
		for (int i = 0; i < arguments.length - 1; i++){
			arguments [i] = arguments[i + 1]; 	
			//System.out.println(arguments[i]);

		}
		
		tree = NodeFactory.createNode(type, arguments);		
	}
	
	void add (String string){
		elements.add(string);
	}

}
