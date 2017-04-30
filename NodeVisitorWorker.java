import java.util.HashMap;

public class NodeVisitorWorker implements NodeVisitor {
	HashMap<String, String> valueTable = new HashMap<String, String>();
	private static NodeVisitorWorker worker;
	int[] flags = new int[3];
	int return_value;
	
	public static NodeVisitorWorker getInstance() {
		if (worker == null){
			worker = new NodeVisitorWorker();
		}
		return worker;
	}

	@Override
	public int visit(AddNode addNode) {
		if (flags[0] == 0){
			int x1 = addNode.arguments.get(0).accept(this);
			int x2 = addNode.arguments.get(1).accept(this);
			return x1 + x2;
		}
		return -1;
	}

	@Override
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
	public void visit(AssignNode assignNode) {
		ArgumentNode sym = (ArgumentNode)assignNode.arguments.get(0);
		int value = assignNode.arguments.get(1).accept(this);
		String valueToString = "" + value;
		valueTable.put(sym.value, valueToString);
		

	}
	
	@Override
	public boolean visit(AssertNode assertNode) {
		if (assertNode.arguments.get(0).accept(this) > 0){
			return true;
		}
		flags[1] = 1;
		return false;
	}

	@Override
	public boolean visit(EqualsNode eqNode) {
		// TODO Auto-generated method stub
		int arg1 = eqNode.arguments.get(0).accept(this);
		int arg2 = eqNode.arguments.get(1).accept(this);
		
		if (arg1 == arg2){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean visit(LessNode lessNode) {
		int arg1 = lessNode.arguments.get(0).accept(this);
		int arg2 = lessNode.arguments.get(1).accept(this);
		
		if (arg1 < arg2){
			return true;
		}
		
		return false;
	}

	@Override
	public int visit(ForNode forNode) {
		// TODO Auto-generated method stub
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
	public int visit(IfNode ifNode) {
		// TODO Auto-generated method stub
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
	public int visit(MultiplyNode mulNode) {
		// TODO Auto-generated method stub
		if (flags[0] == 0){
			int x1 = mulNode.arguments.get(0).accept(this);
			int x2 = mulNode.arguments.get(1).accept(this);
			return x1 * x2;
		}
		return 0;
	}

	@Override
	public int visit(NothingNode nothNode) {
		// TODO Auto-generated method stub
		
		return 0;

	}

	@Override
	public int visit(ReturnNode retNode) {
		flags[2] = 1;
		return_value = retNode.arguments.get(0).accept(this);
		return 0;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int i = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
