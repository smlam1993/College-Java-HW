/* 
 *	Name:   	Lam, Simon
 *	Project:  	#3
 *	Due:        November 28, 2012 
 *	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This CruiseShip file is the subclass of Ship. This class has one special
 *  field that distinguish itself from all other ships, the maximum passenger
 *  allowed on the Cruise Ship. This is a more specific type of ship. It also has
 *  its own toString method that will override the toString method in the base class.
 */ 

public class CruiseShip extends Ship{

	private int maxPassenger;
	
	public CruiseShip() {
		super();
		maxPassenger = 1000; //default
	}
	
	public CruiseShip(String shipName, String yearBuilt) {
		super(shipName, yearBuilt);
		maxPassenger = 1000; //default
	}
	
	public CruiseShip(String shipName, String yearBuilt, int maxPassenger) {
		super(shipName, yearBuilt);
		this.maxPassenger = maxPassenger;
	}
		
	public int getMaxPassenger() {
		return maxPassenger;
	}
	
	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}
	
	public String toString() {
		return String.format("%-20s   Cruise:%d", getShipName(), maxPassenger);
	}
}
