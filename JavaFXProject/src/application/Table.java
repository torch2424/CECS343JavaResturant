package application;

/**
 *
 * @author Rich Cherngchaosil
 *
 * Object to store in the database
 *
 */
public class Table {

	/**
	 * state:
	 * 	0 - Ready
	 * 	1 - Occ'd
	 *  2 - Dirty
	 */
	private int state;

	public Table(){
		state = 0;
	}

	public int getTableState(){
		return state;
	}

	public void updateTableState(int s){
		if(s < 0 || s > 2){
			System.out.println("Unknown State, cannot update the state of the table");
		}

		state = s;
	}

	public void clearTable(){

	}
}
