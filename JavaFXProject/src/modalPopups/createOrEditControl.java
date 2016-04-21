package modalPopups;

import application.StaticModalManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class createOrEditControl {

	// fx:id="orderList"
	@FXML
	ListView<String> ObjectList;

	//Edit button
	@FXML
	private Button editButto;

	//New button
	@FXML
	private Button newButton;

	//Close button
	@FXML
	private Button closeButton;

	//Our objectType id
	private String objectType;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		//Check Our values here
	    //assert seatName != null : "No Textbox id seatName";
	}

	//Function called by user to set some values
	public void initController(String inputType) {
		objectType = inputType;
	}

	@FXML
	public void createNewObject(ActionEvent event){

		//Get our FXML Loader
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../modalPopups/tableDialog.fxml"));

		StaticModalManager.tableModal(loader, event);
	}


	@FXML
	public void closeModal(ActionEvent event){

		//Simply close the window
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
