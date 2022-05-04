/* 
 *	Name:   	Lam, Simon
 *	Project:  	#3
 *	Due:        November 28, 2012 
 *	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This is the main program where all the computation and printing as well as
 *  creating the Array of Ship objects. This main program reads the file and inputs
 *  the information from the file onto the screen and displaying the inventory of ships
 *  within that company. The main program also calculates the total tonnage, passengers
 *  and ships within that company. There is the try-catch method that catches the
 *  FileNotFoundException. 
 */ 

import java.util.Scanner;
import java.io.*;

public class ShipDemo {
	public static void main(String[] args) throws IOException{
		Scanner input = null;
		Scanner kb = new Scanner(System.in);
				
		Ship[] ships;
		String companyName;
		int totalShip, count = 0, totalPassenger = 0, totalTonnage = 0;
		
		try{
			if(args.length > 0)
				input = new Scanner(new File(args[0]));
			else
				input = new Scanner(new File("myShips.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please enter input file name.");
			boolean ok = false;
			while(!ok) {
				try {
					String fileName = kb.nextLine();
					input = new Scanner(new File(fileName));
					ok = true;
				} catch (FileNotFoundException er) {
					System.out.println("File not found. Please re-enter input file name.");
				}
			}
		}
		
		String str = input.nextLine().replaceAll(":", " ");
		String[] token = str.split(" ");
		companyName = token[1].replace("_", " ");
		
		str = input.nextLine().replaceAll(":", " ");
		token = str.split(" ");
		totalShip = Integer.parseInt(token[1]);
		ships = new Ship[totalShip];
		while(input.hasNextLine()){
			str = input.nextLine().replaceAll(":", " ");
			token = str.split(" ");
			if (token[1].equals("c")) {
				ships[count] = new CruiseShip(token[3].replace("_", " "), token[5], Integer.parseInt(token[7]));
				totalPassenger += Integer.parseInt(token[7]);
			}
			else if (token[1].equals("C")){
				ships[count] = new CargoShip(token[3].replace("_", " "), token[5], Integer.parseInt(token[7]));
				totalTonnage += Integer.parseInt(token[7]);
			}
			else 
				ships[count] = new Ship(token[3].replace("_", " "), token[5]);
			count++;
		}
		
		System.out.println();
		System.out.println("Welcome to " + companyName + " version 0.1");
		System.out.println("Copyright (C) Simon Lam 2012. All rights reserved. ");
		System.out.println();
		
		System.out.printf("%-20s   %-20s\n", "Ship Name", "Type");
		System.out.printf("%-20s   %-20s\n", "--------------------", "---------------");
		for(int i = 0; i < ships.length; i++)
			System.out.println(ships[i]);
		System.out.println();
		System.out.println("Total Ships - " + totalShip);
		System.out.println("Total Passengers - " + totalPassenger);
		System.out.println("Total Tonnage - " + totalTonnage);
	}
}
