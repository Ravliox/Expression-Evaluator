import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Tema {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new FileReader (args[0]));
		PrintWriter out = new PrintWriter(args[1]);
		
		Expression expresion_parser = new Expression(reader.readLine());
		expresion_parser.evaluate(out);
		
		
	}

}
