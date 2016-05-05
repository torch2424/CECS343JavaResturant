package rModels;
/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Item class
 *
 */
public class RItem {

	private double price;
	private String itemName;
	private double avgCookTime;
	private String description;

	public RItem (String name, int cost) {
		price=cost;
		itemName = name;
	}

}
