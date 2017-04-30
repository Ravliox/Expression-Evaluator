/**
 * Visitor interface
 * @author magni
 *
 */
public interface NodeVisitor {
	public abstract int visit (AddNode addNode);
	public abstract int visit (ArgumentNode argNode);
	public abstract boolean visit (AssertNode assertNode);
	public abstract void visit (AssignNode assignNode);
	public abstract boolean visit (EqualsNode eqNode);
	public abstract int visit (ForNode forNode);
	public abstract int visit (IfNode ifNode);
	public abstract int visit (MultiplyNode mulNode);
	public abstract int visit (NothingNode nothNode);
	public abstract int visit (ReturnNode retNode);
	public abstract boolean visit (LessNode lessNode);
}
