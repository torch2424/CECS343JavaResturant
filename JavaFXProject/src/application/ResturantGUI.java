package application;

import java.util.ArrayList;

import fxtools.FxAlert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rModels.ROrder;
import rModels.RSeat;
import rModels.RTable;


public class ResturantGUI extends Application {

	//Our Stage
	Stage guiStage;

	//Our array of tables
	private static ArrayList<RTable> tables = new ArrayList<RTable>();
	RSeat currentSeats[];
	ROrder currentOrders[];

	//Fucntion to Simply Launch the app
	public static void main(String[] args) {
		launch(args);
	}

	//Function to instantiate the UI
	@Override
	public void start(Stage primaryStage) {

		try {

			guiStage = primaryStage;
			VBox page = (VBox) FXMLLoader.load(ResturantGUI.class.getResource("OrderGui.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Resturant Application");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void addTable(String name, int size) {

		//Add the table to the array
		tables.add(new RTable(name, size));

		FxAlert.alertInfo("Success!", "Table Created! Name: " + name + ", Size: " + size);
	}

}
