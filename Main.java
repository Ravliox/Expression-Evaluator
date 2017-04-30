import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader (args[0]));
		PrintWriter out = new PrintWriter(args[1]);
		String linie = "";
		String token = " ";
		
		while (token != null){
			token = reader.readLine();
			linie = linie + token; 
		}
						
		Expression expresion_parser = new Expression(linie);
		expresion_parser.evaluate(out);
		out.close();
		
		
	}

}
