package guiElements;

import application.StaticModalManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TableController {

	//Main Edited table items
	@FXML
	private TitledPane tablePane;
	@FXML
	private Rectangle tableStatusColor;
	@FXML
	private SplitMenuButton tableOrders;

	//Our table index
	int tableIndex;

	//Function to init the table
	//Function called by user to set some values
	public void initController(String tableId, int index) {

		//Set the table name
		tablePane.setText(tableId);

		//Set the table index
		tableIndex = index;
	}


	//Add order to the table
	public void addTableOrder(ActionEvent event) {

		//Item Modal
		//Get our FXML Loader
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../modalPopups/itemDialog.fxml"));
		StaticModalManager.ItemModal(loader, event, tableIndex);
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





//	MenuItem newMenuItem = new MenuItem(newItemTextField.getText());
//	newMenuItem.setOnAction(e -> {
//		newMenuItem.setText(newMenuItem.getText() + " - SERVED");
//	});
//	currentMenuButton.getItems().addAll(newMenuItem);
//	newItemTextField.clear();
//	newItemTextField.setPromptText("New item...");
//	newItemTextField.setDisable(true);
//	newItemSaveButton.setDisable(true);

}
