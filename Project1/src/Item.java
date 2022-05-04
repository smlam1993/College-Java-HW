/*
 *		Name:		Lam, Simon 
 *		Project:	#1 
 *		Due:		01/23/2013
 *		Course: 	CS-240-02-W13 
 *
 *		Description: 
 *		This class holds the characteristics of Item. This class consists of the aisle number
 *		where the item is located and the item name. This also has methods to get the value of
 *		the itemName and aisle. There is also a toString method that has a formatted way of displaying
 *		the Item.
 */

public class Item{
	
		private int aisle;
		private String itemName;
		
		public Item(String itemName, int aisle) {
			this.itemName = itemName;
			this.aisle = aisle;
		}
		
		public String getItemName() {
			return itemName;
		}
		
		public int getAisle() {
			return aisle;
		}
		
		public String toString() {
			return String.format("%-15s   %-15s", itemName, aisle);
		}
	}