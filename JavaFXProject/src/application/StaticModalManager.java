package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modalPopups.ItemPopupControl;

public class StaticModalManager {

	public static void ItemModal(FXMLLoader loader, ActionEvent event, int index) {

	    //create the modal
	    Stage stage = new Stage();
	    Parent root;

	    try {

			//Get our FXML Loader
			root = loader.load();

		    stage.setScene(new Scene(root));
		    stage.setTitle("New Item");
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );

		    //Finally show the stage
		    stage.show();

		    //Get our controller
		    ItemPopupControl controller = loader.<ItemPopupControl>getController();

		    controller.initController(index);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			StaticModalManager.modalError();
		}
	}


	//Helper function to easily close modals
	public static void closeModal(ActionEvent event) {

		//Simply close the modal
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	//Function to catch modal Errors
	public static void modalError() {

		System.out.println("JavaFX had an error");
	}
}
