public class LessNode extends Node {
	
	LessNode() {
		super(2);
		// TODO Auto-generated constructor stub
	}	
	
	public int accept (NodeVisitorWorker visitor){

		if (visitor.flags[0] == 0){
//			if (visitor.visit((ArgumentNode)arguments.get(0)).equals("e") ||
//					visitor.visit((ArgumentNode)arguments.get(1)).equals("e")){
//				visitor.flags[0] = 1;
//				return false;
//			}
//			
//			int x1 = Integer.parseInt(visitor.visit((ArgumentNode)arguments.get(0)));
//			int x2 = Integer.parseInt(visitor.visit((ArgumentNode)arguments.get(1)));
//			
//			return x1 < x2;
//		}
		
			boolean rez = visitor.visit(this);
			if (rez == true){
				return 1;
			}
			else {
				return 0;
			}
		}
		return -1;

			
	}

}
