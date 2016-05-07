package application;

import java.util.ArrayList;
import java.util.Map;

import com.firebase.client.Firebase;

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
	private Firebase ref;
	ArrayList<String> order;

	public Table(){
		state = 0;
		order = new ArrayList<String>();

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

	public void setRef(Firebase r){
		ref = r;
	}

	public Firebase getRef(){
		return ref;
	}

	public void clearTable(){
		state = 0;
	}

	/** Ordering functions **/

	public ArrayList<String> getOrder(){
		return order;
	}

	public void addOrder(String food){
		order.add(food);
	}
}
