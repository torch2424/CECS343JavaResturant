package fxtools;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FxAlert {

	//General Fucntion for alerting
	public static void alertInfo(String header, String body) {

		//Show an alert
		Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Resturant Application");
        a.setHeaderText(header);
        a.setResizable(true);
        a.setContentText(body);
        a.showAndWait();

        //Also print to the console, with spacing
        System.out.println(header);
        System.out.println(body);
        System.out.println();
	}
}
