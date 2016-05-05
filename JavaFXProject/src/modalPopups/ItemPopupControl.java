package modalPopups;

import application.StaticModalManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import rModels.Menu;
import rModels.RItem;

public class ItemPopupControl {

	//Our item lists
	@FXML
	ListView<String> appListView;
	@FXML
	ListView<String> entreeListView;
	@FXML
	ListView<String> dessertListView;

	//Our menu
	Menu foodMenu;

	//Submit button
	@FXML
	private Button submitButton;

	//Close button
	@FXML
	private Button closeButton;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
	}

	//Function called by user to set some values
	public void initController(String tableId) {

		//Initialize our Menu
		foodMenu = new Menu();

		//Initialize our lists

		ObservableList<String> appList = FXCollections.observableArrayList();
		ObservableList<String> entreeList= FXCollections.observableArrayList();
		ObservableList<String> dessertList= FXCollections.observableArrayList();

		//Fill our views
		for(int i = 0; i < foodMenu.getAppetizers().size(); ++i){
			appList.add(foodMenu.getAppetizers().get(i).getName());
		}

		appListView.setItems(appList);
	}

	@FXML
	public void addItem(ActionEvent event){

		//Get our selected items
	}

	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
