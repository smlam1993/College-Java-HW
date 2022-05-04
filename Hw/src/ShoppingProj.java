/*
 * 
 */

import java.io.*;
import java.util.*;

public class ShoppingProj{
	private String item;
	private int aisleNum;
	
	public String getItem() {
		return item;
	}
	
	public int getAisleNum() {
		return aisleNum;
	}
	
	public ShoppingProj(String item, int aisleNum) {
		this.item = item;
		this.aisleNum = aisleNum;
	}
	
	public static void end() {
		System.out.println("ShoppingProj (filename)");
		System.exit(0);
	}
	
	public static int count() throws IOException{
		int count = 0;
		Scanner file = new Scanner(new File("Shopping List.txt"));
		while(file.hasNext()){
			count++;
			file.nextLine();
		}
		return count;
	}
	
	public String toString() {
		return String.format("%-20s   %-20s", item, aisleNum);
	}
	
	public int compareTo(ShoppingProj sp) {
		if (this.aisleNum < sp.aisleNum)
		return -1;
		else if(this.aisleNum > sp.aisleNum)
		return 1;
		else
		return 0;
	}

	public static void main (String[] args) throws IOException{
		/*if(args.length < 1)
			ShoppingProj.end(); */
		Scanner file = new Scanner(new File("Shopping List.txt"));
		int i = 0;
		ShoppingProj[] list = new ShoppingProj[count()];
		while(file.hasNext()) {
			list[i] = new ShoppingProj(file.next(),file.nextInt());
			i++;
		}
		System.out.println(list[0].toString());
		System.out.printf("%-20s   %-20s\n", "Item", "Aisle Number");
		System.out.printf("%-20s   %-20s\n", "--------------------", "---------------");
		Arrays.sort(list);
		for(int j = 0; j < list.length; j++) {
			System.out.println(list[j]);
		}
	}
}
