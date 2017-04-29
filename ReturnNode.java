
public class ReturnNode extends Node {
	

	ReturnNode() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	public int accept (NodeVisitorWorker visitor){
//		if (arguments.get(0) instanceof ArgumentNode){
//			if (visitor.visit((ArgumentNode)arguments.get(0)).equals("e")){
//				visitor.flags[0] = 1;
//			}
//			else{
//				visitor.return_value = Integer.parseInt(visitor.visit((ArgumentNode)arguments.get(0)));
//			}
//		}
//		else{
//			AddNode t = (AddNode)arguments.get(0);
//			visitor.return_value = t.accept(visitor);
//		}
		if (visitor.flags[0] == 0){
			visitor.visit(this);
		}
		return -1;
			
	
	}

}
