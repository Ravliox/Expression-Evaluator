
public class NodeFactory {
	
	static Node createNode (String type){
		int typeToInt = Symbols.indexOf(type);
		switch (typeToInt){
			case 0:
				return new AddNode();
			case 1:
				return new MultiplyNode();
			case 2:
				return new EqualsNode();
			case 3:
				return new LessNode();
			case 4:
				return new IfNode();
			case 5:
				return new ForNode();
			case 6:
				return new AssertNode();
			case 7:
				return new AssignNode();
			case 8:
				return new ReturnNode();
			case 9:
				return new NothingNode();
			default:
				return new ArgumentNode();
		}

	}
	
}
