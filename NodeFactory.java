
public class NodeFactory {
	
	static Node createNode (String type, String[] listOfArguments){
		for (String str : listOfArguments){
			System.out.print(str + " ");
		}
		System.out.println();
		int typeToInt = Symbols.indexOf(type);
		Node t;
		switch (typeToInt){
			case 0:
				t =  new AddNode(listOfArguments);
				break;
			case 1:
				t = new MultiplyNode(listOfArguments);
				break;
			case 2:
				t = new EqualsNode(listOfArguments);
			case 3:
				t = new LessNode(listOfArguments);
				break;
			case 4:
				t = new IfNode(listOfArguments);
				break;
			case 5:
				t = new ForNode(listOfArguments);
				break;
			case 6:
				t = new AssertNode(listOfArguments);
				break;
			case 7:
				t = new AssignNode(listOfArguments);
				break;
			case 8:
				t = new ReturnNode(listOfArguments);
				break;
			case 9:
				t = new NothingNode(listOfArguments);
				break;
			default:
				t = null;
				return t;
		}
		t.setParameters(listOfArguments);
		return t;

	}
	
}
