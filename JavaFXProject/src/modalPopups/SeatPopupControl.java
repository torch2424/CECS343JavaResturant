package modalPopups;

import application.ResturantGUI;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SeatPopupControl {

	// fx:id="tableName"
	@FXML
	private TextField seatName;

	// fx:id="orderList"
	@FXML
	ListView<String> orderList;

	//Submit button
	@FXML
	private Button submitButton;

	//Close button
	@FXML
	private Button closeButton;

	//Our table id
	private String tableID;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		//Check Our values here
	    assert seatName != null : "No Textbox id seatName";
	}

	//Function called by user to set some values
	public void initController(String id) {
		tableID = id;
	}

	@FXML
	public void submitSeat(ActionEvent event){

		//Get our values
		String inputName = seatName.getText();
		ObservableList<String> inputOrders = orderList.getSelectionModel().getSelectedItems();

		//Check if an item was selected
		if(inputOrders.size() > 0) ResturantGUI.addSeat(tableID, inputName, inputOrders);

		//And create the table in our state
		ResturantGUI.addSeat(tableID, inputName);
	}

	@FXML
	public void closeModal(ActionEvent event){

		//Simply close the window
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
