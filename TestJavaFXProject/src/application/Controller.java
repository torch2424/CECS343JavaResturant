package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
	
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
	@FXML

	public void readyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableOneClick() {
		tableOneRectangle.setFill(Color.YELLOW);
	}
	
	
	public void addMenuOne() {
		currentMenuButton = menuButtonOne;
		newItemTextField.setDisable(false);
		newItemSaveButton.setDisable(false);
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
