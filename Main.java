import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Main class
 * @author magni
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader (args[0]));			// file in
		PrintWriter out = new PrintWriter(args[1]);										// file out
		String linie = "";
		String token = " ";
		
		while (token != null){
			token = reader.readLine();
			linie = linie + token; 
		}
						
		Expression expresion_parser = new Expression(linie);							// parse expression 
		expresion_parser.evaluate(out);													// evaluate it
		out.close();
		reader.close();
		
	}

}
