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
	ListView<String> entreeListView;
	@FXML
	ListView<String> appDesListView;
	@FXML
	ListView<String> drinkListView;
	ObservableList<String> entreeList;
	ObservableList<String> appDesList;
	ObservableList<String> drinkList;

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
		entreeList= FXCollections.observableArrayList();
		appDesList = FXCollections.observableArrayList();
		drinkList= FXCollections.observableArrayList();

		//Fill our views

		//Entrees
		for(int i = 0; i < Menu.pasta.size(); ++i) {
			entreeList.add(Menu.pasta.get(i).getName());
		}
		for(int i = 0; i < Menu.specialties.size(); ++i) {
			entreeList.add(Menu.specialties.get(i).getName());
		}
		for(int i = 0; i < Menu.salads.size(); ++i) {
			entreeList.add(Menu.salads.get(i).getName());
		}
		for(int i = 0; i < Menu.seafood.size(); ++i) {
			entreeList.add(Menu.seafood.get(i).getName());
		}
		for(int i = 0; i < Menu.pasta.size(); ++i) {
			entreeList.add(Menu.pasta.get(i).getName());
		}

		//Sides/desserts/appetizers/etc...
		for(int i = 0; i < Menu.appetizers.size(); ++i) {
			appDesList.add(Menu.appetizers.get(i).getName());
		}
		for(int i = 0; i < Menu.dressings.size(); ++i) {
			appDesList.add(Menu.dressings.get(i).getName());
		}
		for(int i = 0; i < Menu.soups.size(); ++i) {
			appDesList.add(Menu.soups.get(i).getName());
		}
		for(int i = 0; i < Menu.sides.size(); ++i) {
			appDesList.add(Menu.sides.get(i).getName());
		}

		//Drinks
		for(int i = 0; i < Menu.drinks.size(); ++i) {
			drinkList.add(Menu.drinks.get(i).getName());
		}

		//Place into view
		entreeListView.setItems(entreeList);
		appDesListView.setItems(appDesList);
		drinkListView.setItems(drinkList);
	}

	@FXML
	public void addItem(ActionEvent event){

		//Create an arraylist for our items
		ArrayList<RItem> listOrders = new ArrayList<RItem>();

		//Get our selected items, first check if they are null
		if(entreeListView.getSelectionModel().getSelectedItem() != null) {
			listOrders.add(findItemInMenu(entreeListView.getSelectionModel().getSelectedItem()));
		}
		if(appDesListView.getSelectionModel().getSelectedItem() != null) {
			listOrders.add(findItemInMenu(appDesListView.getSelectionModel().getSelectedItem()));
		}
		if(drinkListView.getSelectionModel().getSelectedItem() != null) {
			listOrders.add(findItemInMenu(drinkListView.getSelectionModel().getSelectedItem()));
		}

		//Finally send to the main
		TasteMain.addItem(listOrders, tableIndex);
	}

	//Helper function to get item
	private RItem findItemInMenu(String itemName) {

		//Get our menu
		ArrayList<RItem> menu = Menu.getAllItems();

		for(int i = 0; i < menu.size(); ++i) {
			if(menu.get(i).getName().contentEquals(itemName)) {
				return menu.get(i);
			}
		}

		return new RItem("Item Not Found", 0);
	}

	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
