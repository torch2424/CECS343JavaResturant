package modalPopups;

import application.ResturantGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SeatPopupControl {

	// fx:id="tableName"
	@FXML
	private TextField seatName;

	// fx:id="tableSize"
	@FXML
	private TextField seatSize;

	//Submit button
	@FXML
	private Button submitButton;

	//Close button
	@FXML
	private Button closeButton;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		//Check Our values here
	    assert seatName != null : "No Textbox id seatName";
	}

	@FXML
	public void submitTable(ActionEvent event){

		//Get our values
		String inputName = seatName.getText();
		int inputSize = Integer.valueOf(seatSize.getText());

		//And create the table in our state
		ResturantGUI.addTable(inputName, inputSize);
	}

	@FXML
	public void closeModal(ActionEvent event){

		//Simply close the window
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
