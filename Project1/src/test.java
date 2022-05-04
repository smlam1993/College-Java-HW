import java.io.*;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("myShips.txt"));
		String companyName;
		String str = input.nextLine().replace(":", " ");
		String[] token = str.split(" ");
		if(token[0] == "Company_name")
			companyName = token[1].replace("_", " ");
		else
			companyName = token[1].replace("_", " ");
		System.out.println("Company Name: " + companyName);
	}
}
