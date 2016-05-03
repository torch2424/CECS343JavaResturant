package rModels;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Seat class
 *
 */
public class RSeat {

	//Static id generator for seats
	public static int seatID;

	//Our attributes
	private String seatNum;
	private String seatName;
	ROrder order;

	//Overloading Constructors
	public RSeat () {

		this("");
	}

	public RSeat(String name) {

		//Initialize our Seat
		seatName = name;
		seatID++;
		seatNum = seatName + "" + seatID;
	}

	public String getSeatNum() {
		return seatNum;
	}


	public String getSeatName() {
		return seatName;
	}

	//Function to set an order to the seat
	public void addOrderToSeat(ROrder input) {
		order = input;
	}

}