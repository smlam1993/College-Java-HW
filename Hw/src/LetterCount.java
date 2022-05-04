/*
 *		Name:		Lam, Simon 
 *		Homework:	#4 
 *		Due:		11/9/2012
 *		Course: 	CS-141-01-f12 
 *
 *		Description: 
 *		This program counts all the letters in a file and records the number
 *		of letters found within that file. This program stores and displays the
 *		number of letters within that program as well as writing a text file that
 *		would show a record of how many letters were found within that file.
 */

import java.io.*;
import java.util.Scanner;

public class LetterCount {
	private char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z'};
	private String fileName;
	static int[] letterCount = new int[26];
	
	public void setCounter(char letter) {
		for (int i = 0; i < this.letter.length; i++) {
			if (this.letter[i] == letter) {
				letterCount[i]++;
			}
		}
	}
	
	public void displayCounter() {
		for (int i = 0; i < letterCount.length; i++) {
			System.out.println(letter[i] + ": " + letterCount[i]);
		}
	}
	
	public void writeFile() throws IOException {
		PrintWriter outputFile = new PrintWriter("LetterCount.txt");
		outputFile.println("Input File Name: " + fileName);
		outputFile.println();
		for (int i = 0; i < letterCount.length; i++) {
			outputFile.println(letter[i] + ": " + letterCount[i]);
		}
		outputFile.close();
	}
	
	public void scanFile() throws IOException {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the file name:  ");
		fileName = kb.next();
		File file = new File (fileName);
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()) {
			String string = inputFile.next();
			for (int i = 0; i < string.length(); i++) {
				setCounter(string.toUpperCase().charAt(i));
			}
		}
		inputFile.close();
	}
	
	public static void main(String[] args) throws IOException {
		LetterCount lc = new LetterCount();
		System.out.println("Lam, Simon - CS141 Homework #4");
		lc.scanFile();
		System.out.println();
		lc.displayCounter();
		lc.writeFile();
	}
}