package guiElements;

import application.StaticModalManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import rModels.Menu;


public class TableController {

	//Main Edited table items
	@FXML
	private TitledPane tablePane;
	@FXML
	private Rectangle tableStatusColor;
	@FXML
	private SplitMenuButton tableOrders;

	//Function to init the table
	//Function called by user to set some values
	public void initController(String tableId) {

		//Set the table name
		tablePane.setText(tableId);
	}


	//Add order to the table
	public void addTableOrder(ActionEvent event) {

		//Item Modal
		//Get our FXML Loader
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../modalPopups/itemDialog.fxml"));
		StaticModalManager.ItemModal(loader, event);

//		currentMenuButton = menuButtonOne;
//		newItemTextField.setDisable(false);
//		newItemSaveButton.setDisable(false);
	}


	//Table Status
	public void readyTable() {
		tableStatusColor.setFill(Color.GREEN);
	}
	public void occupyTable() {
		tableStatusColor.setFill(Color.RED);
	}
	public void dirtyTable() {
		tableStatusColor.setFill(Color.YELLOW);
	}

	//Completely clear the table
	public void clearTable() {
		tableStatusColor.setFill(Color.GREEN);
		tableOrders.getItems().clear();
	}

}
