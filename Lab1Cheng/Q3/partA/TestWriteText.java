
import java.io.*;

public class TestWriteText {
	public static void main(String[] args){
		try {
			FileWriter outputFile = new FileWriter(args[0]);
			PrintWriter out = new PrintWriter(outputFile);

			// Write text to file
			out.println("line 1");
			out.println("line 2");
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
