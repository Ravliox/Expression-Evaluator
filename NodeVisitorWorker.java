import java.util.HashMap;

/**
 * Visitor class for our Nodes
 * @author magni
 *
 */

public class NodeVisitorWorker implements NodeVisitor {
	HashMap<String, String> valueTable = new HashMap<String, String>();		// holds the values of the assigned symbols
	private static NodeVisitorWorker worker;
	int[] flags = new int[3];							// error flags
	int return_value;														// value to be returned if we have a return
	
	public static NodeVisitorWorker getInstance() {
		if (worker == null){
			worker = new NodeVisitorWorker();
		}
		return worker;
	}

	@Override
	/**
	 * @return sum of the two values returned by accept on the two children
	 */
	public int visit(AddNode addNode) {
		if (flags[0] == 0){
			int x1 = addNode.arguments.get(0).accept(this);
			int x2 = addNode.arguments.get(1).accept(this);
			return x1 + x2;
		}
		return -1;
	}

	@Override
	/**
	 * returns the value held by the Argument node
	 * if at time of query of the value of a symbol it is not defined in the value table
	 * set the check failed flag to 1
	 */
	public int visit(ArgumentNode argNode) {
		if (isNumeric(argNode.value)){
			return Integer.parseInt(argNode.value);
		}
		else if (valueTable.containsKey(argNode.value)){
			return Integer.parseInt(valueTable.get(argNode.value));
		}
		
		flags[0] = 1;
		
		return 0;
		
	}

	@Override
	/**
	 * makes a new entry in the value table with the key the symbol given and the value
	 * the return value of accept on the second child of the node
	 */
	public void visit(AssignNode assignNode) {
		ArgumentNode sym = (ArgumentNode)assignNode.arguments.get(0);
		int value = assignNode.arguments.get(1).accept(this);
		
		String valueToString = "" + value;
		
		valueTable.put(sym.value, valueToString);
		

	}
	
	@Override
	/**
	 * return true if accept on the child is not 0.
	 * If it is set the assert failed flag to 1.
	 */
	public boolean visit(AssertNode assertNode) {
		if (assertNode.arguments.get(0).accept(this) > 0){
			return true;
		}
		
		flags[1] = 1;
		
		return false;
	}

	@Override
	/**
	 *	takes the values given by accept on the two children
	 *	returns the value of them being equal
	 */
	public boolean visit(EqualsNode eqNode) {
		int arg1 = eqNode.arguments.get(0).accept(this);
		int arg2 = eqNode.arguments.get(1).accept(this);
		
		if (arg1 == arg2){
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * same as above just with less than
	 */
	public boolean visit(LessNode lessNode) {
		int arg1 = lessNode.arguments.get(0).accept(this);
		int arg2 = lessNode.arguments.get(1).accept(this);
		
		if (arg1 < arg2){
			return true;
		}
		
		return false;
	}

	@Override
	/**
	 * manually constructs a for using while
	 * first, it calls accept on the initialization, which should be an assignement
	 * then, as long as the accept call on the condition is higher than 0
	 * call accept on the program and the incrementation
	 */
	public int visit(ForNode forNode) {
		Node init = forNode.arguments.get(0);
		Node condition = forNode.arguments.get(1);
		Node increment = forNode.arguments.get(2);
		Node program = forNode.arguments.get(3);
		
		init.accept(this);
		while (condition.accept(this) > 0){
			increment.accept(this);
			program.accept(this);
		}
		
		return 0;
	}

	@Override
	/**
	 * checks the accept value of the condition
	 * does the program needed for it
	 */
	public int visit(IfNode ifNode) {
		Node condition = ifNode.arguments.get(0);
		Node program1 = ifNode.arguments.get(1);
		Node program2 = ifNode.arguments.get(2);
		
		
		if (condition.accept(this) > 0){
			program1.accept(this);
		}
		else{
			program2.accept(this);
		}
		return 0;
	}

	@Override
	/**
	 * same as add
	 */
	public int visit(MultiplyNode mulNode) {
		if (flags[0] == 0){
			int x1 = mulNode.arguments.get(0).accept(this);
			int x2 = mulNode.arguments.get(1).accept(this);
			
			return x1 * x2;
		}
		
		return 0;
	}

	@Override
	/**
	 * does nothing
	 */
	public int visit(NothingNode nothNode) {
		
		return 0;

	}

	@Override
	/**
	 * sets the return_value of the visitor and the flag for return to 1
	 */
	public int visit(ReturnNode retNode) {
		flags[2] = 1;
		return_value = retNode.arguments.get(0).accept(this);
		
		return 0;
	}
	/**
	 * function used for checking whether a value of argument node is symbol of value
	 * @param str will be the value of the ArgumentNode
	 * @return boolean, whether value is number or a symbol
	 */
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
