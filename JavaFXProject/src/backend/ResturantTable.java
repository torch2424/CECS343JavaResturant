package backend;

import java.util.HashMap;
import java.util.Map.Entry;

import com.firebase.client.Firebase;

/**
 *
 * @author Rich Cherngchaosil
 *
 *         Object to store in the database
 *
 */
public class ResturantTable {

	/**
	 * state: 0 - Ready 1 - Occ'd 2 - Dirty
	 */
	private int state;
	private Firebase ref;
	HashMap<String, Boolean> order;

	public ResturantTable() {
		state = 0;
		order = new HashMap<String, Boolean>();

	}

	public int getTableState() {
		return state;
	}

	public void updateTableState(int s) {
		if (s < 0 || s > 2) {
			System.out.println("Unknown State, cannot update the state of the table");
		}

		state = s;
	}

	public void setRef(Firebase r) {
		ref = r;
	}

	public Firebase getRef() {
		return ref;
	}

	public void clearTable() {
		state = 0;
	}

	/** Ordering functions **/

	public HashMap<String, Boolean> getOrder() {
		return order;
	}

	public void addOrder(String food) {
		food = food.replaceAll(" ", "_");
		order.put(food, false);
	}

	public void served(String food) {
		food = food.replaceAll(" ", "_");
		order.put(food, true);
	}

	public void updateOrder(HashMap<String, Boolean> newOrder) {
		order = newOrder;
	}

	//Clear orders from a table
	public void clearOrders() {
		order.clear();
	}

	public void listFood() {
		for (Entry<String, Boolean> entry : order.entrySet()) {
			//System.out.println(entry.getKey());
		}
	}
}
