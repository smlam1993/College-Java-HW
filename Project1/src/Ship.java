/* 
 *	Name:   	Lam, Simon
 *	Project:  	#3
 *	Due:        November 28, 2012 
 *	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This file is the base class for all the types of ships that were used
 *  during this project. This file contains private fields of ship name and the
 *  year the ship was built. We have the toString method that returns the ship name
 *  and the year that it was built in a string format.
 */ 

public class Ship {
	private String shipName;
	private String yearBuilt;

	public Ship() { //default
		shipName = "Unknown";
		yearBuilt = "Unknown";
	}
	
	public Ship(String shipName) {
		this.shipName = shipName;
		yearBuilt = "Unknown";
	}
	
	public Ship(String shipName, String yearBuilt) {
		this.shipName = shipName;
		this.yearBuilt = yearBuilt;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public String getYearBuilt() {
		return yearBuilt;
	}
	
	public String toString() {
		return String.format("%-20s   %-20s", shipName, yearBuilt);
	}
}
