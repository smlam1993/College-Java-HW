/*
* Name:  	Lam, Simon
* Project: 	2
* Due:		February 1, 2013    
* Course: 	CS-240
*
* Description:
* This is the main method class to test the program and obtain the output for the RPN. 
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class RPN {
	public static void exit() {
		System.out.println("Format: java RPN (filename)");
		System.exit(0);
	}
	
	public static void main(String[] args) throws IOException{
		if (args.length == 0) 
			exit();
		Scanner file = new Scanner(new File(args[0]));
		MyStack<Double> ms = new MyStack<>();
		double temp1, temp2;
		
		while(file.hasNext()){
			String temp = file.next();
			try {
				ms.push(Double.parseDouble(temp));
			} catch (NumberFormatException e) {
				temp1 = ms.peek();
				ms.pop();
				temp2 = ms.peek();
				ms.pop();
				if(temp.equals("*") || temp.equals("x"))
					ms.push(temp1 * temp2);
				else if (temp.equals("/"))
					ms.push(temp1 / temp2);
				else if (temp.equals("+"))
					ms.push(temp1 + temp2);
				else if (temp.equals("-"))
					ms.push(temp1 - temp2);
				else
					System.out.println("Operator unknown");
			}
			System.out.println(ms.toString());
		}
		if(ms.size() != 1)
			System.out.print("Too much operators and not enough operands or too much operands and not enough operators.");
	}
}