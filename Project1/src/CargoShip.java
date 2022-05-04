/* 
 *	Name:   	Lam, Simon
 *	Project:  	#3
 *	Due:        November 28, 2012 
 *	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This CargoShip file is the subclass of Ship. This class has one special
 *  field that distinguish itself from all other ships, the Cargo Capacity that is
 *  allowed on the Cargo Ship. This is a more specific type of ship and different
 *  field compared to Cruise Ship. It also has its own toString method that will 
 *  override the toString method in the base class.
 */ 

public class CargoShip extends Ship{
	
	private int cargoCapacity;
	
	public CargoShip() {
		super();
		cargoCapacity = 1000; //default
	}
	
	public CargoShip(String shipName, String yearBuilt) {
		super(shipName, yearBuilt);
		cargoCapacity = 1000; //default
	}
	
	public CargoShip(String shipName, String yearBuilt, int cargoCapacity) {
		super(shipName, yearBuilt);
		this.cargoCapacity = cargoCapacity;
	}
		
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	
	public String toString() {
		return String.format("%-20s   Cargo:%d", getShipName(), cargoCapacity);
	}
}
