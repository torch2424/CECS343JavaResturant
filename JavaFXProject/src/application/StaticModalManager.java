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
import modalPopups.SeatPopupControl;
import modalPopups.TablePopupControl;
import modalPopups.createOrEditControl.ResturantObject;

public class StaticModalManager {

	public static void ItemModal(FXMLLoader loader, ActionEvent event) {

	    //create the modal
	    Stage stage = new Stage();
	    Parent root;
	    //Group roots = new Group ();

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

		    controller.initController("tableIdTest");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			StaticModalManager.modalError();
		}
	}

	public static void tableModal(FXMLLoader loader, ActionEvent event) {

		//Get our controller
	    TablePopupControl controller = loader.<TablePopupControl>getController();

	    //Group roots = new Group();

	    //Call controller Function
	    //controller.initData(customer);

	    //Pass to the modal Creater
	    StaticModalManager.createModal(loader, event, "Table", ResturantObject.TABLE);
	}

	public static void seatModal(FXMLLoader loader, ActionEvent event) {

		//Table rectangle
//	    Rectangle r = new Rectangle(25,25,250,250);
//	    r.setFill(Color.BLUE);
//	    roots.getChildren().add(r);

	    //Get our controller
	    SeatPopupControl controller = loader.<SeatPopupControl>getController();

	    //Call controller Function
	    //controller.initData(customer);

	    //Pass to the modal Creater
	    StaticModalManager.createModal(loader, event, "Seats", ResturantObject.SEAT);
	}

	//Helper Fucntion to create the modal
	private static void createModal(FXMLLoader loader, ActionEvent event,
			String title, ResturantObject objectType) {

		Stage stage = new Stage();
	    Parent root;
	    //Group roots = new Group ();

	    try {

			//Get our FXML Loader
			root = loader.load();

		    stage.setScene(new Scene(root));
		    stage.setTitle(title);
		    stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(
		        ((Node)event.getSource()).getScene().getWindow() );

//		    Rectangle r = new Rectangle(25,25,250,250);
//		       r.setFill(Color.BLUE);
//		       roots.getChildren().add(r);


		    //Call controller Function
		    //controller.initData(customer);
		    //Finally show the stage
		    stage.show();

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
