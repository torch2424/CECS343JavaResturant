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
import modalPopups.TablePopupControl;

public class GuiController {

	//Function to create/edit Tables
	@FXML
	private void createTable(ActionEvent event) {

		Stage stage = new Stage();
	    Parent root;
		try {

			//Get our FXML Loader
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource("../modalPopups/tableDialog.fxml"));

			root = loader.load();

		    stage.setScene(new Scene(root));
		    stage.setTitle("My modal window");
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );

		    //Get our controller
		    TablePopupControl controller = loader.<TablePopupControl>getController();

		    //Call constroller Function
		    //controller.initData(customer);

		    	  //Finally show the stage
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
