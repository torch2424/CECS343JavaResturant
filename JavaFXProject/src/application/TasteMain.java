package application;

import java.util.ArrayList;
import java.util.Map.Entry;

import appAnalysis.RAnalysis;
import appElements.FxAlert;
import backend.ConnectFirebase;
import backend.ResturantTable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rModels.RItem;
import rModels.RTable;


public class TasteMain extends Application {

	//Our Stage
	Stage guiStage;

	//Our Gui Controller
	private static GuiController guiControl;

	//Our array of tables
	private static ArrayList<RTable> tables = new ArrayList<RTable>();

	//Our anaylysis Object
	private static RAnalysis analyzer;

	//Our backend connection
	public static ConnectFirebase backend;

	//Fucntion to Simply Launch the app
	public static void main(String[] args) {
		launch(args);
	}

	//Function to instantiate the UI
	@Override
	public void start(Stage primaryStage) {

		//instantiate our analyzer
		analyzer = new RAnalysis();

		//Connect to our database
		new Thread(new Runnable() {
		    public void run() {
				backend = new ConnectFirebase();
				backend.start();
		    }
		}).start();

		//Grab our FXML
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../application/OrderGui.fxml"));

		try {

			//Set up our stage
			guiStage = primaryStage;
			VBox page = (VBox) loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Resturant Application");
			primaryStage.show();

			//Get the controller
			guiControl = loader.getController();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Getter setters for arrays
	public static ArrayList<RTable> getTables() {
		return tables;
	}

	public static void addTable(String name) {

		//Check if the name exists
		for(int i = 0; i < tables.size(); i++) {

			if(tables.get(i).getTableName().contentEquals(name)) {

				//Decrease the index to check the index once more
				--i;

				//Append "-new" to signify a new table
				name = name + " - New";
			}
		}

		//Add the table to the array
		tables.add(new RTable(name));

		//Throw it at the backend
		new Thread(new Runnable() {
		    public void run() {
		    	tables.get(tables.size() - 1).setFirebaseKey(backend.addTable());
		    }
		}).start();
	}

	//Delete a table
	public static void removeTable(int index) {

		//Get the table name
		String tableName = tables.get(index).getTableName();

		//Remove the table from the backend
		new Thread(new Runnable() {
		    public void run() {
		    	backend.deleteTable(tables.get(index).getFirebaseKey());
		    }
		}).start();

		//Remove the table
		tables.remove(index);

		//Remove from the accordian as well from the controller
		guiControl.removeTable(index);

		//Alert The user
		FxAlert.alertInfo("Success!", tableName + " Deleted!");
	}

	public static void addItem(ArrayList<RItem> orders, int index) {

		//First, run through the analyzer
		analyzer.recordItems(orders);
		//Update the data view
		guiControl.updateData(analyzer);

		//Add the table to the array
		for(int i = 0; i < orders.size(); ++i) tables.get(index).addOrder(orders.get(i));

		//Add it to the table view
		guiControl.addOrderToTable(orders, index);

		//Create a string to alert of item names
		String orderString = "";
		for(int i = 0; i < orders.size(); ++i) orderString = orderString + orders.get(i).getName() + ", ";
		FxAlert.alertInfo("Success!", "Order Added! Item Name(s): " + orderString.substring(0, orderString.length() - 2));
	}

}
