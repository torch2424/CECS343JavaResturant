package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GuiController {

	//Function to create a table
	@FXML
	private void createTable(ActionEvent event) {

		Stage stage = new Stage();
	    Parent root;
		try {
			root = FXMLLoader.load(
					ResturantGUI.class.getResource("../modalPopups/tableDialog.fxml"));

		    stage.setScene(new Scene(root));
		    stage.setTitle("My modal window");
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
