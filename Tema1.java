
public class Tema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "[return , [+ [* [return [assert [; [== x";
		String[] tokens = t.split(" ");
		
		String string = "[+ 1 [* 3 2] ]";
		
		for (String str : tokens){
			System.out.println(Symbols.indexOf(str));
		}
	}

}
