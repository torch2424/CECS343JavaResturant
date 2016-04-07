package rModels;

import java.util.ArrayList;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Table class
 *
 */
public class RTable {

	/** number of table **/
	private int tableNum;
	/** name of the table **/
	private String tableName;
	/** check condition of table (clean or dirty) */
	private String condition; // should condition be set to a boolean?
	/** check status of table (if available, in use, or waiting to be cleaned) */
	private String status;
	/** number of seats in a table **/
	private ArrayList<RSeat> tableSize;

	private RSeat seat;

	public RTable() {
		tableNum = 0;
		condition = " ";
		tableName = " ";
		status = " ";
		seat = new RSeat();
		tableSize = new ArrayList<RSeat>();

	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition() {
		//if (thisbuttonispressed){
		condition = "clean";
		//} else if (thisbuttonispressed){
		condition = "dirty";
		//}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus() {
		if (condition.equals("dirty")) {
			status = "awaiting cleaning";
		} else if (condition.equals("clean")) {
			status = "available";
		}
		status = "in use";
	}

	public int getTableSize() {

		return tableSize.size();
	}

	/** add seat to the table**/
	public void addSeat() {
		if (tableSize.size() < 4) {
			RSeat chair = new RSeat();
			tableSize.add(chair);
			chair.setSeatNum(getTableSize());
			chair.setSeatName("Seat " + chair.getSeatNum());

		} else {
			System.out.println("Table is full");
		}

	}

}