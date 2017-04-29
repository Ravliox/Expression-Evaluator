 
public class AssignNode extends Node {

	AssignNode() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	public int accept(NodeVisitorWorker visitor){
//		if (visitor.flags[0] == 0){
//			if (visitor.visit((ArgumentNode)arguments.get(0)).equals("e") ||
//					visitor.visit((ArgumentNode)arguments.get(1)).equals("e")){
//				visitor.flags[0] = 1;
//			}
//			else {
//				ArgumentNode arg1 = (ArgumentNode)arguments.get(0);
//				ArgumentNode arg2 = (ArgumentNode)arguments.get(1);
//				visitor.valueTable.put(arg1.value, arg2.value);
//			}
//		}
		if (visitor.flags[0] == 0){
			visitor.visit(this);
		}
		return -1;
	}


}
