package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modalPopups.createOrEditControl;
import modalPopups.createOrEditControl.ResturantObject;

public class GuiController {

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


}
