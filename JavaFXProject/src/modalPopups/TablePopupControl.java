package modalPopups;

import application.TasteMain;
import application.StaticModalManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TablePopupControl {

	// fx:id="tableName"
	@FXML
	private TextField tableName;

	// fx:id="tableSize"
	@FXML
	private TextField tableSize;

	//Submit button
	@FXML
	private Button submitButton;

	//Close button
	@FXML
	private Button closeButton;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		//Check Our values here
	    assert tableName != null : "No Textbox id tableName";
	}

	@FXML
	public void submitTable(ActionEvent event){

		//Get our values
		String inputName = tableName.getText();
		int inputSize = Integer.valueOf(tableSize.getText());

		//And create the table in our state
		TasteMain.addTable(inputName, inputSize);
	}

	@FXML
	public void closeModal(ActionEvent event){

		//Call the close modal static
		StaticModalManager.closeModal(event);
	}
}
