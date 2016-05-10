package rModels;

import java.util.ArrayList;

import com.firebase.client.Firebase;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Table class
 *
 */
public class RTable {

	//Static id generator for tables
	public static int tableID;

	/** number of table **/
	private String tableNum;

	/** name of the table **/
	private String tableName;

	/** check condition of table (clean or dirty) */
	private boolean tableClean;

	/** check status of table (if available, in use) */
	private boolean tableStatus;

	//Our backend key
	private Firebase firebaseKey;

	//Orders at the table
	private ArrayList<RItem> tableItems;

	//Overloading Constructors
	public RTable() {
		this("", 0, true,  true);
	}

	public RTable(String name) {
		this(name, 0, true, true);
	}
	public RTable(String name, int number) {
		this(name, number, true,  true);
	}
	public RTable(String name, int number, boolean condition) {
		this(name, number, condition,  true);
	}

	public RTable(String name, int number, boolean condition, boolean status) {

		tableName = name;

		tableID++;
		tableNum = tableName + "" + tableID;

		tableClean = condition;
		tableStatus = status;

		//Instantiate our table items
		tableItems = new ArrayList<RItem>();
	}



	public String getTableNum() {
		return tableNum;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean getCondition() {
		return tableClean;
	}

	public void setCondition(boolean condition) {

		tableClean = condition;
	}

	public boolean getStatus() {
		return tableStatus;
	}

	public void setStatus(boolean status) {

		tableStatus = status;
	}

	/** add the order to the table**/
	public void addOrder(RItem theItem) {

		//Add the item to the array
		tableItems.add(theItem);
	}

	//Get/Set the firebase key
	public Firebase getFirebaseKey() {
		return firebaseKey;
	}
	public void setFirebaseKey(Firebase key) {
		firebaseKey = key;
	}
}