package modalPopups;

import java.util.ArrayList;

import application.StaticModalManager;
import application.TasteMain;
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
	ObservableList<String> appList;
	ObservableList<String> entreeList;
	ObservableList<String> dessertList;

	//Our table Index
	int tableIndex;


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
	public void initController(int index) {

		//Save our table index
		tableIndex = index;

		//Initialize our Menu
		foodMenu = new Menu();

		//Initialize our lists

		appList = FXCollections.observableArrayList();
		entreeList= FXCollections.observableArrayList();
		dessertList= FXCollections.observableArrayList();

		//Fill our views
		for(int i = 0; i < foodMenu.getAppetizers().size(); ++i){
			appList.add(foodMenu.getAppetizers().get(i).getName());
		}

		appListView.setItems(appList);
	}

	@FXML
	public void addItem(ActionEvent event){

		//Get our selected items
		int index = appListView.getSelectionModel().getSelectedIndex();

		//Add the item to the main state
		ArrayList<RItem> listOrders = new ArrayList<RItem>();
		listOrders.add(foodMenu.getAppetizers().get(index));
		TasteMain.addItem(listOrders, tableIndex);

	}

	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
