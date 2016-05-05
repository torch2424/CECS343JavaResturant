package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modalPopups.createOrEditControl;
import modalPopups.createOrEditControl.ResturantObject;

public class GuiController {

	public Scene mainScene;
	public void setMainScene(Scene pScene){
		mainScene = pScene;
	}

	@FXML
	private Rectangle tableOneRectangle;
	@FXML
	private SplitMenuButton menuButtonOne;
	@FXML
	private TextField newItemTextField;
	@FXML
	private Button newItemSaveButton;
	@FXML
	private Rectangle tableTwoRectangle;
	@FXML
	private SplitMenuButton menuButtonTwo;
	@FXML
	private Rectangle tableThreeRectangle;
	@FXML
	private Rectangle tableFourRectangle;
	@FXML
	private SplitMenuButton currentMenuButton;
	@FXML
	private SplitMenuButton menuButtonThree;
	@FXML
	private SplitMenuButton menuButtonFour;

	//Our table view from scene builder
	@FXML
	AnchorPane tableView;

	//Table Editor
	@FXML
	private void tableManage(ActionEvent event) {

		//Call the helper function
		createOrEdit(event, ResturantObject.TABLE);
	}

	//Seat Editor
	@FXML
	private void seatManage(ActionEvent event) {

		//Call the helper function
		createOrEdit(event, ResturantObject.SEAT);
	}

	//Helper Function to open modal to select from a list of created objects to edit/or create a new one
	private void createOrEdit(ActionEvent event, ResturantObject objectType) {

		Stage stage = new Stage();
	    Parent root;
		try {

			//Get our FXML Loader
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource("../modalPopups/createOrEdit.fxml"));

			root = loader.load();

		    stage.setScene(new Scene(root));
		    stage.setTitle("Resturant Edit - " + objectType.toString());
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );

		    //Get our controller
		    createOrEditControl controller = loader.<createOrEditControl>getController();

		    //Call controller Function
		    if(objectType == ResturantObject.TABLE)
		    	controller.initController(createOrEditControl.ResturantObject.TABLE);
		    else if(objectType == ResturantObject.SEAT)
		    	controller.initController(createOrEditControl.ResturantObject.SEAT);

		    //Finally show the stage
		    stage.show();

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			StaticModalManager.modalError();
		}
	}

	public void readyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableOneClick() {
		tableOneRectangle.setFill(Color.YELLOW);
	}


	public void addMenuOne(ActionEvent event) {

		//Item Modal
		//Get our FXML Loader
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../modalPopups/itemDialog.fxml"));
		StaticModalManager.ItemModal(loader, event);

//		currentMenuButton = menuButtonOne;
//		newItemTextField.setDisable(false);
//		newItemSaveButton.setDisable(false);
	}

	public void addMenuTwo() {
		currentMenuButton = menuButtonTwo;
		newItemTextField.setDisable(false);
		newItemSaveButton.setDisable(false);
	}

	public void addMenuThree() {
		currentMenuButton = menuButtonThree;
		newItemTextField.setDisable(false);
		newItemSaveButton.setDisable(false);
	}

	public void addMenuFour() {
		currentMenuButton = menuButtonFour;
		newItemTextField.setDisable(false);
		newItemSaveButton.setDisable(false);
	}

	public void saveNewItem() {
		MenuItem newMenuItem = new MenuItem(newItemTextField.getText());
		newMenuItem.setOnAction(e -> {
			newMenuItem.setText(newMenuItem.getText() + " - SERVED");
		});
		currentMenuButton.getItems().addAll(newMenuItem);
		newItemTextField.clear();
		newItemTextField.setPromptText("New item...");
		newItemTextField.setDisable(true);
		newItemSaveButton.setDisable(true);
	}
	public void clearTable() {
		tableOneRectangle.setFill(Color.GREEN);
		menuButtonOne.getItems().clear();
	}
	public void clearTableTwo() {
		tableTwoRectangle.setFill(Color.GREEN);
		menuButtonTwo.getItems().clear();
	}
	public void clearTableThree() {
		tableThreeRectangle.setFill(Color.GREEN);
		menuButtonThree.getItems().clear();
	}
	public void clearTableFour() {
		tableFourRectangle.setFill(Color.GREEN);
		menuButtonFour.getItems().clear();
	}


	public void readyButtonTableTwoClicked() {
		tableTwoRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableTwoClicked() {
		tableTwoRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableTwoClick() {
		tableTwoRectangle.setFill(Color.YELLOW);
	}

	public void readyButtonTableThreeClicked() {
		tableThreeRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableThreeClicked() {
		tableThreeRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableThreeClick() {
		tableThreeRectangle.setFill(Color.YELLOW);
	}

	public void readyButtonTableFourClicked() {
		tableFourRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableFourClicked() {
		tableFourRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableFourClick() {
		tableFourRectangle.setFill(Color.YELLOW);
	}


}
