package application;

import com.firebase.client.Firebase;

/**
 *
 * @author Rich Cherngchaosil
 *
 * This class connects to the Firebase server and will handle the get and update to the server
 *
 */
public class ConnectFirebase {

	Firebase root;
	Thread thread;

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


		thread = new Thread(){
			public void run(){
				try {
		            System.out.println("Creating Table....");
		            newTableRef.setValue(table);
		            Thread.sleep(1000);
		        } catch(InterruptedException v) {
		            System.out.println(v);
		        }
			}
		};
		thread.start();

		return newTableRef;
	}

//	public static void main(String[] args){
//		ConnectFirebase f = new ConnectFirebase();
//		System.out.println(f.addTable());
//		System.out.println("check");
//
//
//	}


}
