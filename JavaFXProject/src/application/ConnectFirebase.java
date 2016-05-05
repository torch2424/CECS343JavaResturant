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

	public Firebase addTable(){
		Firebase tableRef = root.child("Table");

		Table table = new Table();
		Firebase newTableRef = tableRef.push();
		newTableRef.setValue(table);

		thread = new Thread(){
			public void run(){
				try {
		            System.out.println("Creating Table....");
		            Thread.sleep(1000);
		        } catch(InterruptedException v) {
		            System.out.println(v);
		        }
			}
		};
		thread.start();

		return newTableRef;
	}

	public static void main(String[] args){
		ConnectFirebase f = new ConnectFirebase();
		System.out.println(f.addTable());
		System.out.println("check");


	}


}
