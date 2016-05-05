package modalPopups;

import java.util.ArrayList;

import application.TasteMain;
import application.StaticModalManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import rModels.RTable;

public class createOrEditControl {

	public enum ResturantObject {
		SEAT, TABLE
	}

	// fx:id="orderList"
	@FXML
	ListView<String> ObjectList;

	//Edit button
	@FXML
	private Button editButton;

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

			ArrayList<RTable> tableList = TasteMain.getTables();
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

		//NEED to close a modal before creating a new one, all child stages
		//Would be closed with it
		closeModal(event);

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

	//Function to close the modal
	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
