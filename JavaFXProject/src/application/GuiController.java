package application;

import java.io.IOException;
import java.util.ArrayList;

import appAnalysis.RAnalysis;
import appElements.TableController;
import backend.ConnectFirebase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import rModels.RItem;

public class GuiController {

	//Array of Table Controllers
	private ArrayList<TableController> tableControllers = new ArrayList<TableController>();

	//Our Scene
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

	//No Tables Label
	@FXML
	private Label noTables;

	//How much will our scroll view will grow on increase/decrease table size
	private final double scrollSizeRate = 75.0;

	//Add a table
	@FXML
	public void addNewTable(ActionEvent event) throws IOException {

		//Remove not tables
		noTables.setVisible(false);

		//Load a new Tables
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource("../appElements/tableGui.fxml"));
		tableAccordion.getPanes().add(loader.load());

		//Get our table index
		int newTableIndex =  TasteMain.getTables().size();

		//Add it to our main Controllers
		TasteMain.addTable("Table" + (newTableIndex + 1));

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

		//Remove the table from the backend
		new Thread(new Runnable() {
		    public void run() {
		    	TasteMain.backend.deleteTable(TasteMain.getTables().get(index).getFirebaseKey());
		    }
		}).start();

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

	    //Check if we can show no tables
	    if(tableControllers.size() == 0) noTables.setVisible(true);
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
}
