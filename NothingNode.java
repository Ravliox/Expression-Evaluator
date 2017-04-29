
public class NothingNode extends Node {
	
	


	NothingNode() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	public int accept (NodeVisitorWorker visitor){
		for (Node t : arguments){
//		if (t instanceof AssertNode){
//			AssertNode t_aux = new AssertNode();
//			t_aux = (AssertNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof AddNode){
//			AddNode t_aux = new AddNode();
//			t_aux = (AddNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof LessNode){
//			LessNode t_aux = new LessNode();
//			t_aux = (LessNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof MultiplyNode){
//			MultiplyNode t_aux = new MultiplyNode();
//			t_aux = (MultiplyNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof AssignNode){
//			AssignNode t_aux = new AssignNode();
//			t_aux = (AssignNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof EqualsNode){
//			EqualsNode t_aux = new EqualsNode();
//			t_aux = (EqualsNode)t;
//			t_aux.accept(visitor);;
//		}
//		else if (t instanceof ForNode){
//			ForNode t_aux = new ForNode();
//			t_aux = (ForNode)t;
//			t_aux.accept (visitor);
//		}
//		else if (t instanceof IfNode){
//			IfNode t_aux = new IfNode();
//			t_aux = (IfNode)t;
//			t_aux.accept (visitor);
//		}
//		else if (t instanceof NothingNode){
//			NothingNode t_aux = new NothingNode();
//			t_aux = (NothingNode)t;
//			t_aux.accept(visitor);
//		}
//		else if (t instanceof ReturnNode){
//			ReturnNode t_aux = new ReturnNode();
//			t_aux = (ReturnNode)t;
//			t_aux.accept(visitor);
//			
//		}
			if (visitor.flags[0] == 0)
				t.accept(visitor);
		}
		return -1;
	}


}
