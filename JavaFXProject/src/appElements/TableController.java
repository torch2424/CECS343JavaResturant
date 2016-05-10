package appElements;

import java.util.ArrayList;

import application.StaticModalManager;
import application.TasteMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import rModels.RItem;


public class TableController {

	//Main Edited table items
	@FXML
	private TitledPane tablePane;
	@FXML
	private Rectangle tableStatusColor;
	@FXML
	private SplitMenuButton tableOrders;
	@FXML
	private TextField tableName;

	//Our table index
	int tableIndex;
	//Our ordr index
	int orderIndex;

	//Function to init the table
	//Function called by user to set some values
	public void initController(String tableId, int index) {

		//Set the table name
		tablePane.setText(tableId);

		//Set the table index
		tableIndex = index;
	}


	//Add order to the table
	public void addTableOrder(ArrayList<RItem> orders) {

		//Reset our order index
		orderIndex = 0;

		//Loop through the orders and add
		for(int i = 0; i < orders.size(); ++i) {

			//set our order index
			orderIndex = i;

			//Create the menuItem and add it
			MenuItem newMenuItem = new MenuItem(orders.get(i).getName());
			newMenuItem.setOnAction(e -> {
				if(newMenuItem.getText().contains(" - SERVED") != true){

					//Save the item name for the backend
					String itemName = newMenuItem.getText();

					//Add the served text
					newMenuItem.setText(newMenuItem.getText() + " - SERVED");

					//Change the status in the backend
					//Add to the backend
					new Thread(new Runnable() {
					    public void run() {
					    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).served(itemName);
					    }
					}).start();

					//Update the backend
					TasteMain.updateBackendTable(tableIndex);

				}
			});

			//Add to the backend
			new Thread(new Runnable() {
			    public void run() {
			    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).addOrder(orders.get(orderIndex).getName());
			    }
			}).start();

			//Add to the table orders clientside
			tableOrders.getItems().add(newMenuItem);

			//Update the backend
			TasteMain.updateBackendTable(tableIndex);
		}
	}

	//Bring Up the item dialog
	public void itemDialog(ActionEvent event) {

		//Item Modal
		//Get our FXML Loader
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../appElements/itemDialog.fxml"));
		StaticModalManager.ItemModal(loader, event, tableIndex);
	}

	//Set the table name from the input box
	public void setTableName(KeyEvent event) {

		//Get the text from the input
		String input = tableName.getText();

		//Set the text
		tablePane.setText(input);

		//Set the name in the Main
		TasteMain.getTables().get(tableIndex).setTableName(input);
	}


	//Table Status
	public void readyTable() {
		tableStatusColor.setFill(Color.GREEN);

		//Add to the backend
		new Thread(new Runnable() {
		    public void run() {
		    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).updateTableState(0);
		    }
		}).start();

		//Update the backend
		TasteMain.updateBackendTable(tableIndex);
	}
	public void occupyTable() {
		tableStatusColor.setFill(Color.RED);

		//Add to the backend
				new Thread(new Runnable() {
				    public void run() {
				    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).updateTableState(1);
				    }
				}).start();

				//Update the backend
				TasteMain.updateBackendTable(tableIndex);
	}
	public void dirtyTable() {
		tableStatusColor.setFill(Color.YELLOW);

		//Add to the backend
		new Thread(new Runnable() {
		    public void run() {
		    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).updateTableState(2);
		    }
		}).start();

		//Update the backend
		TasteMain.updateBackendTable(tableIndex);
	}

	//Completely clear the table
	public void clearTable() {
		tableStatusColor.setFill(Color.GREEN);
		tableOrders.getItems().clear();

		//Add to the backend
		new Thread(new Runnable() {
		    public void run() {
		    	TasteMain.backend.tableList.get(TasteMain.getTables().get(tableIndex).getFirebaseKey().getKey()).clearTable();;
		    }
		}).start();

		//Update the backend
		TasteMain.updateBackendTable(tableIndex);
	}

	//Get/Set Table Index
	public int getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(int index) {
		tableIndex = index;
	}

	//Delete the table entirely
	public void deleteTable() {

		//Remove from the static state manager
		System.out.println(tableIndex);
		TasteMain.removeTable(tableIndex);
	}

}
