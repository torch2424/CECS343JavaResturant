package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 *
 * @author Rich Cherngchaosil
 *
 * This class connects to the Firebase server and will handle the get and update to the server
 *
 */
public class ConnectFirebase {

	Firebase root;
	HashMap<String, Table> tableList;
//	Thread thread;

	public ConnectFirebase(){
		root = new Firebase("https://cecs343javaproject.firebaseio.com");
		tableList = new HashMap<String, Table>();
	}

	/**
	 * Create an object Table in the database
	 * @param empty reference for table ("pointer") to the table object
	 * @return Firebase object with the reference to the newly created table
	 */
	public Firebase addTable(){
		Firebase tableRef = root.child("Table");

		Table table = new Table();
		Firebase newTableRef = tableRef.push();

		System.out.println("Creating Table...");
		newTableRef.setValue(table, new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				System.out.println("Table created");

			}
		});

		sleep(2);
		table.setRef(newTableRef);
		tableList.put(newTableRef.toString(), table);
		return newTableRef;
	}

	public void updateTable(Table table){

		System.out.println("Updating Table...");
		Firebase tableRef = table.getRef();
		HashMap<String, Boolean> order = table.getOrder();
		for(Entry<String, Boolean> entry: order.entrySet()){
			String food = entry.getKey();
			tableRef.child("order").child(food).child("served").setValue(entry.getValue());
		}
		tableRef.child("tableState").setValue(table.getTableState());
		sleep(2);
		System.out.println("Table Updated");

	}

//	/**
//	 * Update specific table's values
//	 * @param table Table's key
//	 * @param update HashMap with the updated keys
//	 */
//	public void updateTableState(Table table, Map<String, Object> update){
//
//		Firebase tableRef = table.getRef();
//		System.out.println("Updating Table's state...");
//		tableRef.updateChildren(update, new Firebase.CompletionListener() {
//
//			@Override
//			public void onComplete(FirebaseError arg0, Firebase arg1) {
//				System.out.println("Table's state updated");
//
//			}
//		});
//		sleep(1);
//
//	}

	/**
	 *
	 * Set the specific table to the inital state
	 * @param table Firebase ref to that table object.
	 */
	public void clearTable(Firebase table){
		System.out.println("Clearing Table...");
		table.setValue(new Table(), new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				System.out.println("Table cleared");

			}
		});
		sleep(2);
	}

	/**
	 * Turn all table into state 0, which is ready state
	 */
	public void clearAllTable(){
		System.out.println("Clearing all tables...");
		Firebase tableRef = root.child("Table");
		tableRef.addListenerForSingleValueEvent(new ValueEventListener(){

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDataChange(DataSnapshot arg0) {

				for(DataSnapshot tables: arg0.getChildren()){
					clearTable(tableRef.child(tables.getKey()));
				}

			}

		});

	}

	/**
	 * Delete specific table from the database
	 * @param table
	 */
	public void deleteTable(Firebase table){
		table.removeValue(new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				System.out.println("Table deleted");

			}
		});
	}

	/**
	 * Set the Value at node "Table" to null
	 * All the values at node "Table" will be deleted
	 */
	public void deleteAllTable(){
		System.out.println("Deleting all tables");
		root.child("Table").removeValue();
		sleep(4);
	}

	/**
	 * Tell Thread to go to sleep
	 * @param second amount of second thread is going to sleep
	 */
	public void sleep(int second){
		try {
			Thread.sleep(1000 * second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args){
//		ConnectFirebase f = new ConnectFirebase();
//		Firebase table = f.addTable();
//		System.out.println(table);
//
//
//		/** Ordering of the table **/
//		Table t = f.tableList.get(table.toString());
//
//		t.addOrder("Chicken");
//		t.addOrder("Rice");
//		t.addOrder("Something");
//		f.updateTable(t);
////		Map<String, Object> order = new HashMap<String, Object>();
////		HashMap<String, Boolean> order = t.getOrder();
////		for(Entry<String, Boolean> entry: order.entrySet()){
////			String food = entry.getKey();
////			table.child("order").child(food).child("served").setValue(entry.getValue());
////		}
//
////		for(int i = 0; i < orders.size(); i++){
//////			order.put(i+"", orders.get(i));
////			table.child("order").child(orders.get(i)).child("served").setValue(false);
////		}
////		table.child("order").setValue(order);
//
//		/*****************/
//
//		/**
//		 * Update table
//		 */
////		Map<String, Object> update = new HashMap<String, Object>();
////		update.put("tableState", 1);
////		f.updateTableState(t, update);
//
////		f.clearAllTable();
////		f.clearTable(table);
////		f.deleteAllTable();
////		f.deleteTable(table);
//
//		/**
//		 * Needed:
//		 * 	EventListener that update list of table
//		 * 	Table with orders
//		 * 	Request all table and convert it to the list of all table object
//		 */
//
//	}


}
