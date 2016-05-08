package application;

import java.io.IOException;
import java.util.ArrayList;

import guiElements.TableController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modalPopups.createOrEditControl;
import modalPopups.createOrEditControl.ResturantObject;
import rAnalysis.RAnalysis;
import rModels.RItem;

public class GuiController {

	//Array of Table Controllers
	private ArrayList<TableController> tableControllers = new ArrayList<TableController>();

	public Scene mainScene;
	public void setMainScene(Scene pScene){
		mainScene = pScene;
	}

	//Our Table Accordian
	@FXML
	private Accordion tableAccordion;
	//Our anchorpane parenting the accordion
	@FXML
	private AnchorPane accordionParent;
	//Our table view from scene builder
	@FXML
	AnchorPane tableView;

	//Our Data Labels
	@FXML
	private Label dataRevenue;
	@FXML
	private Label dataBestSellers;
	@FXML
	private Label dataFlopSellers;

	//How much will our scroll view will grow on increase/decrease tabel size
	private final double scrollSizeRate = 50.0;

	//Add a table
	@FXML
	public void addNewTable(ActionEvent event) throws IOException {

		//Load a new Tables
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../guiElements/tableGui.fxml"));
		tableAccordion.getPanes().add(loader.load());

		//Get our table index
		int newTableIndex =  TasteMain.getTables().size();

		System.out.println(newTableIndex);

		//Add it to our main Controllers
		TasteMain.addTable("Table" + (newTableIndex + 1), 6);

		//Edit the table status
	    tableControllers.add(loader.<TableController>getController());
	    tableControllers.get(newTableIndex).initController(TasteMain.getTables().get(newTableIndex).getTableName(), newTableIndex);

	    //Increase the pane size
	    accordionParent.setMinHeight(accordionParent.getMinHeight() + scrollSizeRate);
	}

	//Add an item to a table
	public void addOrderToTable(ArrayList<RItem> orders, int index) {

		//Bubble the function call to the table
		tableControllers.get(index).addTableOrder(orders);
	}

	//Remove a table
	public void removeTable(int index) {

		//Remove the table from the Accordion
		tableAccordion.getPanes().remove(index);

		//Remove the table from the controller
		tableControllers.remove(index);

		//Decrease the index of all the tables
		for(int i = 0; i < tableControllers.size(); ++i) {

			//Decrease/set the index
			tableControllers.get(i).setTableIndex(i);
		}

		//Decrease the pane size
	    accordionParent.setMinHeight(accordionParent.getMinHeight() - scrollSizeRate);
	}

	//Update data view
	public void updateData(RAnalysis analyzer) {

		//Simply set text on the data fields
		dataRevenue.setText("$" + Double.valueOf(analyzer.getRevenue()));
		dataBestSellers.setText(analyzer.getBestSeller());
		dataFlopSellers.setText(analyzer.getFlopSeller());
	}

	//Close Window
	@FXML
	public void closeWindow(ActionEvent event){

		//Call the close modal static
		System.exit(0);
	}

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
