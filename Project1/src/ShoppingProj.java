/*
 *		Name:		Lam, Simon 
 *		Project:	#1 
 *		Due:		01/23/2013
 *		Course: 	CS-240-02-W13 
 *
 *		Description: 
 *		This is the main class with the main method that runs the program. The main method
 *		locates the data file and takes the data from the file while organizing to make the
 *		data look more apparent and organized.
 */

import java.util.*;
import java.io.*;

public class ShoppingProj {
	
	public static void end() {
		System.out.println("Usage: java ShoppingProj (filename)");
		System.exit(0);
	}
	
	public static void end2() {
		
	}
	
	public static void main(String[] args) throws IOException{
		if(args.length < 1)
			end();
		ArrayList<Item> list = new ArrayList<>();
		Scanner file = new Scanner(new File(args[0]));
		while(file.hasNext()) {
			list.add(new Item(file.next(), file.nextInt()));
		}
		System.out.println("\nCopyright (C) Simon Lam 2013.\n");
		System.out.printf("%-15s   %-15s\n", "Item", "Aisle Number");
		System.out.printf("%-15s   %-15s\n", "---------------", "---------------");
		for(int i = 1; i <= 16; i++) {
			for(int j = 0; j < list.size(); j++) {
				Item item = list.get(j);
				if(item.getAisle() == i)
					System.out.println(item);
			}
		}
	}
}
