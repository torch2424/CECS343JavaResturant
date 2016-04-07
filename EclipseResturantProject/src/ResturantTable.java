import java.util.ArrayList;

/**
 * 
 * @author Thomas Hernandez
 * CECS 343 Final Project
 * Table class
 *
 */
public class ResturantTable {

	/**number of table**/
	private int tableNum;
	/**name of the table**/
	private String tableName;
	/**check condition of table (clean or dirty)*/
	private String condition;		//should condition be set to a boolean?
	/**check status of table (if available, in use, or waiting to be cleaned)*/
	private String status;
	/**number of seats in a table**/
	private ArrayList <TableSeat> tableSize;
	
	public ResturantTable () {
		tableNum = 0;
		condition= " ";
		tableName = " ";
		status = " ";
		tableSize = new ArrayList <TableSeat> ();

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

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getTableSize () {
		
		return tableSize.size(); 
	}
	
	
	
	
	
	
}