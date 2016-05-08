package rAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

import rModels.RItem;

public class RAnalysis {

	//Create some analysis variables
	private static double dayRevenue;

	//Treemap to keep track of what is ordered, and how many times
	TreeMap<String, Integer> orderedItems;

	//Constructor
	public RAnalysis() {

		//Simply initialize our variables
		dayRevenue = 0;
		orderedItems = new TreeMap<String, Integer>();
	}

	//Add an Item to analysis
	public void recordItems(ArrayList<RItem> orders) {

		//Add to the revenue, and to our item tracking
		for(int i = 0; i < orders.size(); ++i) {
			dayRevenue += orders.get(i).getPrice();

			//Add to our tree
			addItemToTree(orders.get(i).getName());
		}
	}

	//Return the name of the best item
	public String getBestSeller () {

		//Initialize the item name
		String itemName = "";

		//Get max value
		int maxValue = (Collections.max(orderedItems.values()));

		//Loop through the tree to find the key
        for (Entry<String, Integer> entry : orderedItems.entrySet()) {
            if (entry.getValue() == maxValue) {

            	//Set the items names
                itemName = itemName + entry.getKey() + ", ";
            }
        }

        //Remove the trailing comma
        itemName = itemName.substring(0, itemName.length() - 2);

        //Return the item name
		return itemName;
	}

	//Return the name of the best item
	public String getFlopSeller () {

		//Initialize the item name
		String itemName = "";

		//Get max value
		int minValue = (Collections.min(orderedItems.values()));

		//Loop through the tree to find the key
        for (Entry<String, Integer> entry : orderedItems.entrySet()) {
            if (entry.getValue() == minValue) {

            	//Set the items names
                itemName = itemName + entry.getKey() + " ";
            }
        }

        //Remove the trailing comma
        itemName = itemName.substring(0, itemName.length() - 2);

        //Return the item name
		return itemName;
	}

	//Return our revenue
	public double getRevenue() {
		return dayRevenue;
	}

	//Add an item to our tree
	private void addItemToTree(String itemName) {

		//Check if the item exists in the tree
		//Else add it to the tree
		if(orderedItems.containsKey(itemName)) {
			orderedItems.put(itemName, orderedItems.get(itemName) + 1);
		}
		else {
			orderedItems.put(itemName, 1);
		}
	}
}
