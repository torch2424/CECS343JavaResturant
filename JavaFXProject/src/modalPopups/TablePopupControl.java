package modalPopups;

import application.ResturantGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TablePopupControl {

	// fx:id="tableName"
	@FXML
	private TextField tableName;

	// fx:id="tableSize"
	@FXML
	private TextField tableSize;

	//Submit button
	@FXML
	private Button myButton;

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
		ResturantGUI.addTable(inputName, inputSize);
	}
}
