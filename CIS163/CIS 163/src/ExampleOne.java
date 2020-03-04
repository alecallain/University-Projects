import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExampleOne {
	
	public void readFile (String filename) {
		
		String readContents;
		
		try {
			// open the data file
			Scanner fileReader = new Scanner(new File(filename));
			
			// read one String in of data
			int hundreds = fileReader.nextInt();
			int fifties = fileReader.nextInt();
			int twenties = fileReader.nextInt();
			
			System.out.println("We got " + hundreds + " " + fifties +  " " + twenties);
		}
		
		// could not find file
		catch (Exception error) {
			System.out.println("File not found");
		}
		
	}
	
	public void writeFile(String filename, String fileContents) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		out.println(fileContents);
		out.close();
	}
	
	public static void main(String [] args) {
		
		ExampleOne go = new ExampleOne();
		
		String filename = "N:\\ourFile.txt";
		int hundreds = 100;
		int fifties = 23;
		int twenties = 3;
		
		String fileContents = hundreds + " " + fifties + " " + twenties;
		System.out.print(fileContents);
		
		go.writeFile(filename, fileContents);
		go.readFile(filename);
	}
}
