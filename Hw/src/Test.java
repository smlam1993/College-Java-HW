import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		StringBuilder result = new StringBuilder();
		Scanner file = new Scanner(new File("RPN.txt"));
		ArrayList<String> list = new ArrayList<>();
		while(file.hasNext()) {
			list.add(file.next());
		}
		for(int i = 0; i < list.size(); i++) {
			result.append(list.get(i) + "");
		}
		System.out.print(result.toString());
	}
}