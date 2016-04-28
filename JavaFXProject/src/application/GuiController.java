package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modalPopups.createOrEditControl;

public class GuiController {

	//Function to open modal to select from a list of created objects to edit/or create a new one
	@FXML
	private void createOrEdit(ActionEvent event) {

		Stage stage = new Stage();
	    Parent root;
		try {

			//Get our FXML Loader
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource("../modalPopups/createOrEdit.fxml"));

			root = loader.load();

		    stage.setScene(new Scene(root));
		    stage.setTitle("Resturant Edit");
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );

		    //Get our controller
		    createOrEditControl controller = loader.<createOrEditControl>getController();

		    //Call controller Function
		    controller.initController("Table");

		    //Finally show the stage
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
