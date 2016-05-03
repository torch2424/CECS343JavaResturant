package modalPopups;

import java.util.ArrayList;

import application.ResturantGUI;
import application.StaticModalManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import rModels.RTable;

public class createOrEditControl {

	public enum ResturantObject {
		SEAT, TABLE
	}

	// fx:id="orderList"
	@FXML
	ListView<String> ObjectList;

	//Our list of items
	ObservableList<String> currentItems;

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
	private ResturantObject objectType;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
	}

	//Function called by user to set some values
	public void initController(ResturantObject inputType) {


		objectType = inputType;

		//Fill the view with objects of the type
		ObservableList<String> currentItems = FXCollections.observableArrayList();

		if(objectType == ResturantObject.TABLE) {

			ArrayList<RTable> tableList = ResturantGUI.getTables();
			for(int i = 0; i < tableList.size(); i++) {
				currentItems.add(tableList.get(i).getTableName());
			}
		}

		//Set the items if not empty
		if(currentItems.size() > 0) ObjectList.setItems(currentItems);
	}

	//Function to open our modal
	@FXML
	public void createNewObject(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();

		if(objectType == ResturantObject.TABLE) {

			//Get our FXML Loader
			loader = new FXMLLoader(
				    getClass().getResource("../modalPopups/tableDialog.fxml"));

			//Load the modal
			StaticModalManager.tableModal(loader, event);
		}
		else if(objectType == ResturantObject.SEAT) {

			//Get our FXML Loader
			loader = new FXMLLoader(
				    getClass().getResource("../modalPopups/seatDialog.fxml"));

			//Load the modal
			StaticModalManager.seatModal(loader, event);
		}
	}


	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
