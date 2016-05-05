package guiElements;

import application.StaticModalManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class TableController {

	@FXML
	private Rectangle tableOneRectangle;
	@FXML
	private SplitMenuButton menuButtonOne;

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

	public void readyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.GREEN);
	}
	public void occupyButtonTableOneClicked() {
		tableOneRectangle.setFill(Color.RED);
	}
	public void dirtyButtonTableOneClick() {
		tableOneRectangle.setFill(Color.YELLOW);
	}

	public void clearTable() {
		tableOneRectangle.setFill(Color.GREEN);
		menuButtonOne.getItems().clear();
	}

}
