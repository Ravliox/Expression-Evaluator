
public class Symbols {
	
	final static String[] symbols = new String[20];
	
	static public int indexOf (String str){
		symbols[0] = "+";
		symbols[1] = "*";
		symbols[2] = "==";
		symbols[3] = "<";
		symbols[4] = "if";
		symbols[5] = "for";
		symbols[6] = "assert";
		symbols[7] = "=";
		symbols[8] = "return";
		symbols[9] = ";";
		for (int i = 0; i < 10; i++){
			if (symbols[i].equals(str)){
				return i;
			}
		}
		return -1;
		
	}

}
