package rModels;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Seat class
 *
 */
public class RSeat {

	private int seatNum;
	private String seatName;
	ROrder order;

	public RSeat () {

		seatNum= 0;
		seatName= " ";
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

}