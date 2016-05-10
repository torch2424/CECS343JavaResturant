package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
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
 * To start up, call function start()
 * -Start will listen for update and update the HashMap containing all the table and it's data
 * -Each table upon created will have it own hash value created by firebase function push()
 * -ConnectFirebase class has tableList HashMap<String, Table>
 *
 */
public class ConnectFirebase {

	Firebase root;
	public HashMap<String, ResturantTable> tableList;
//	Thread thread;

	public ConnectFirebase(){
		root = new Firebase("https://cecs343javaproject.firebaseio.com");
		tableList = new HashMap<String, ResturantTable>();
	}

	/**
	 *	This is eventListener function, it will constantly update the value of the table
	 *	It will create new instance of Table each time amd update it to the HashMap.
	 *	Always update Table class reference
	 */
	public void start(){

		Firebase tableRootRef = root.child("Table");
		tableRootRef.addValueEventListener(new ValueEventListener() {

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDataChange(DataSnapshot arg0) {
				for(DataSnapshot tables: arg0.getChildren()){
					ResturantTable updateTable = new ResturantTable();

					Firebase tableRef = tableRootRef.child(tables.getKey());
					updateTable.setRef(tableRef);
					Firebase orderRef = tableRef.child("order");

					try {
						int tableState = Integer.parseInt(get(tableRef.child("tableState")+".json"));
						updateTable.updateTableState(tableState);

						/*** getting all the food orders **/
						String orderJson = get(orderRef+".json");
						HashMap<String, Boolean> orderList = new HashMap<String, Boolean>();
						if(orderJson.equals("null")){
							// Do nothing
						}else{
							String[] foods = orderJson.split(",");

							for(String i:foods){
								String[] foodState = i.replaceAll("[^a-zA-Z]", " ").split("\\s+");
								orderList.put(foodState[1], Boolean.valueOf(foodState[2]));
							}
						}

						updateTable.updateOrder(orderList);
						tableList.put(tables.getKey(), updateTable);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		});
		sleep(3);
	}

	/**
	 * Create an object Table in the database
	 * @param empty reference for table ("pointer") to the table object
	 * @return Firebase object with the reference to the newly created table
	 */
	public Firebase addTable(){

		Firebase tableRef = root.child("Table");

		ResturantTable table = new ResturantTable();
		Firebase newTableRef = tableRef.push();

		//System.out.println("Creating Table...");
		newTableRef.setValue(table, new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				//System.out.println("Table created");

			}
		});

		sleep(2);
		table.setRef(newTableRef);
		tableList.put(newTableRef.toString(), table);
		return newTableRef;
	}

	/**
	 * Update all the content of the table to the server
	 * @param table	Ref to the Table object
	 */
	public void updateTable(ResturantTable table){

		//System.out.println("Updating Table...");
		Firebase tableRef = table.getRef();
		HashMap<String, Boolean> order = table.getOrder();

		//To fix order updating
		tableRef.child("order").setValue(null);

		for(Entry<String, Boolean> entry: order.entrySet()){
			String food = entry.getKey();
			tableRef.child("order").child(food).setValue(entry.getValue());
		}
		tableRef.child("tableState").setValue(table.getTableState());
		sleep(2);
		System.out.println("Table Updated");

	}

	/**
	 *
	 * Set the specific table to the inital state
	 * @param table Firebase ref to that table object.
	 */
	public void clearTable(Firebase table){
		//System.out.println("Clearing Table...");
		table.setValue(new ResturantTable(), new Firebase.CompletionListener() {

			@Override
			public void onComplete(FirebaseError arg0, Firebase arg1) {
				//System.out.println("Table cleared");

			}
		});
		sleep(2);
	}

	/**
	 * Turn all table into state 0, which is ready state
	 */
	public void clearAllTable(){
		//System.out.println("Clearing all tables...");
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
				//System.out.println("Table deleted");

			}
		});
	}

	/**
	 * Set the Value at node "Table" to null
	 * All the values at node "Table" will be deleted
	 */
	public void deleteAllTable(){
		//System.out.println("Deleting all tables");
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

	private static String get(String url) throws Exception{

		URL website = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) website.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(false);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("content-type", "application/json");
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("User-Agent", "ClassJavaBot");

		connection.connect();

//		System.out.println(connection.getResponseMessage());
		BufferedReader in = new BufferedReader(
								new InputStreamReader(
										connection.getInputStream()));



		StringBuilder response = new StringBuilder();
		String inputLine;

		while ( (inputLine = in.readLine()) != null){
			response.append(inputLine);
		}

		in.close();

		return response.toString();
	}

//	public static void main(String[] args){
//		ConnectFirebase f = new ConnectFirebase();
//
//		f.start();
////		f.sleep(4);
////		System.out.println(f.tableList.size());
//
////		for(Entry<String, Table> entry: f.tableList.entrySet()){
////			Table table = entry.getValue();
////			System.out.println(table.getRef());
////			table.listFood();
////		}
//
//
////		Firebase table = f.addTable();
////		System.out.println(table);
////
////
////		/** Ordering of the table **/
////		Table t = f.tableList.get(table.toString());
//////
////		t.addOrder("Chicken");
////		t.addOrder("Rice");
////		t.addOrder("Something");
////		f.updateTable(t);
//
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
