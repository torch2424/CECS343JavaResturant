package application;

import java.util.HashMap;
import java.util.Map;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 *
 * @author Rich Cherngchaosil
 *
 * This class connects to the Firebase server and will handle the get and update to the server
 *
 */
public class ConnectFirebase {

	Firebase root;
//	Thread thread;

	public ConnectFirebase(){
		root = new Firebase("https://cecs343javaproject.firebaseio.com");
	}

	/**
	 * Create an object Table in the database
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
				System.out.println("Table created...");

			}
		});

		sleep(3);
		return newTableRef;
	}

	public void updateTable(Firebase table, Map<String, Object> update){

		System.out.println("Updating Table...");
		table.updateChildren(update, new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				System.out.println("Table updated...");

			}
		});
		sleep(1);

	}

	/**
	 * Delete specific table from the database
	 * @param table
	 */
	public void deleteTable(Firebase table){
		table.removeValue(new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				System.out.println("Table deleted....");

			}
		});
	}

	/**
	 * Set the Value at node "Table" to null
	 * All the values at node "Table" will be deleted
	 */
	public void clearAllTable(){
		System.out.println("Deleting all tables");
		root.child("Table").removeValue();
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

	public static void main(String[] args){
		ConnectFirebase f = new ConnectFirebase();
		Firebase table = f.addTable();
		System.out.println(table);
		System.out.println("check");

		/**
		 * Update table
		 */
		Map<String, Object> update = new HashMap<String, Object>();
		update.put("tableState", 1);
		f.updateTable(table, update);


//		f.clearAllTable();
		f.deleteTable(table);

	}


}
