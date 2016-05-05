import java.util.ArrayList;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project Item class
 *
 */
public class Menu {

	//Appetizers
	ArrayList <Item> appetizers = new ArrayList <Item> ();
	Item smoked_Salmon = new Item ("Smoked Salmon", 9);
	Item spinach_Artichoke_Dip = new Item ("Spinach & Artichoke Dip", 10);
	Item escargot = new Item ("Escargot", 10);
	Item grilled_Octopus = new Item ("Grilled Octopus", 11);
	Item crab_Cakes = new Item ("Crab Cakes", 11);
	Item smoked_Beef_Croquettes = new Item ("Smoked Beef Croquettes", 13);
	Item calamari = new Item ("Calamari", 13);
	Item mussels_Marinieres = new Item ("Mussels Marinieres", 15);
	Item duck_Wings = new Item ("Duck Wings L'Orange", 15);
	Item beef_Bites = new Item ("Beef Bites Au Poivre", 15);
	Item walleye_Fingers = new Item ("Walleye Fingers", 15);


	//Pasta
	ArrayList <Item> pasta = new ArrayList <Item> ();
	Item fettuccine_Alfredo = new Item ("Fettuccine Alfredo", 14);
	Item chicken_Alfredo = new Item ("Chicken Fettuccine Alfredo", 18);
	Item shrimpAlfredo = new Item ("Shrimp Fettuccine Alfredo", 20);
	Item lobster_Spaghetti = new Item ("Lobster Spaghetti", 28);
	Item creole_Sausage_Penne = new Item ("Creole Sausage Penne", 18);

	//Specialties
	ArrayList <Item> specialties = new ArrayList <Item> ();
	Item panRoast_Half_Chicken = new Item ("Pan Roast Half Chicken", 20);
	Item chicken_Chardonnay = new Item ("Chicken Chardonnay", 15);
	Item chicken_Francaise = new Item ("Chicken Française", 24);
	Item pork_Chop = new Item ("Pork Chop", 20);
	Item duck = new Item ("Duck", 26);
	Item lambTBone = new Item ("Lamb T-Bone", 30);
	Item veal_Piccata = new Item ("Veal Piccata", 26);
	Item veal_Parmesan = new Item ("Veal Parmesan", 26);
	Item veal_Marsala = new Item ("Veal Marsala", 28);
	Item primeSteak = new Item ("Prime Top Sirloin Steak", 28);
	Item filet_Mignon = new Item ("Filet Mignon Steak", 38);
	Item ribeyeSteak = new Item ("Ribeye Steak", 38);

	//salads
	ArrayList <Item> salads = new ArrayList <Item> ();
	Item mixedGreens = new Item ("Mixed Greens Salad", 7);
	Item spinach = new Item ("Spinach Salad", 8);
	Item wedge = new Item ("Ribeye Steak", 9);
	Item beet = new Item ("Beet", 9);
	Item chickenCaesar = new Item ("Chicken Caesar Salad", 14);
	Item caesar = new Item ("Caesar Salad", 7);
	Item calamariCaesar = new Item ("Calamari Caesar Salad", 38);
	Item shrimpCaesar = new Item ("Shrimp Caesar Salad", 16);
	Item salmonCaesar = new Item ("Salmon Caesar Salad", 18);

	//Dressings
	ArrayList <Item> dressings = new ArrayList <Item> ();
	Item ranch = new Item ("Ranch", 0);
	Item italian = new Item ("Italian", 0);
	Item vinegret = new Item ("Vinegret", 0);
	Item lemon = new Item ("Lemon", 0);

	//Seafood
	ArrayList <Item> seafood = new ArrayList <Item> ();
	Item salmon = new Item ("Salmon", 26);
	Item walleye = new Item ("Walleye", 30);
	Item seabass = new Item ("Sea Bass", 36);
	Item scallops = new Item ("Seared Scallops", 28);
	Item prawns = new Item ("Blackened Prawns", 32);

	//Soups
	ArrayList <Item> soups = new ArrayList <Item> ();
	Item frenchOnion = new Item ("French Onion Soup", 7);
	Item scallopAndCucumber = new Item ("callop & Cucumber Soup", 9);

	//Sides
	ArrayList <Item> sides = new ArrayList <Item> ();
	Item sauteed_Vegetable_Medley = new Item ("Sautéed Vegetable Medley", 4);
	Item green_Beans = new Item ("Green Beans", 4);
	Item sauteed_Mushrooms = new Item ("Sautéed Mushrooms", 6);
	Item asparagus = new Item ("Asparagus with Hollandaise", 9);
	Item sauteed_Potatoes = new Item ("Sautéed Fingerling Potatoes", 4);
	Item mashed_Potatoes = new Item ("Boursin Mashed Potatoes", 4);
	Item parmesan_Potatoes = new Item ("Parmesan Leek Potatoes", 4);
	Item house_Cut_Fries = new Item ("House Cut Fries with Béarnaise", 5);
	Item mushroom_Risotto = new Item ("Wild Mushroom Risotto", 5);
	Item mac_Cheese = new Item ("Baked Mac & Cheese", 8);

	//dessert
	ArrayList <Item> dessert = new ArrayList <Item> ();
	Item chomeur_Pudding = new Item ("Signature Chomeur Pudding", 9);
	Item creme_Brulee = new Item ("Maple Crème Brûlée", 5);
	Item choc_custard_Cake = new Item ("Chocolate Ganache Custard Cake", 5);
	Item frenchTart = new Item ("French Silk Tart", 5);
	Item vanilla_Cheesecake = new Item ("Vanilla Cheesecake", 6);
	Item choc_Lava_Cake = new Item ("Chocolate Molten Lava Cake", 6);
	Item house_Ice_Cream = new Item ("House Made Ice Cream & Sorbet", 6);

	//Drinks
	ArrayList <Item> drinks = new ArrayList <Item> ();
	Item stellaArtois = new Item ("Stella Artois", 7);
	Item budweiser = new Item ("Budweiser", 5);
	Item coors_Light = new Item ("Coors Light", 5);
	Item oDouls = new Item ("O'Doul's", 5);
	Item bards_Gluten_Free = new Item ("Bard's Gluten Free", 6);
	Item sam_Adams = new Item ("Sam Adams", 6);
	Item lift_Bridge = new Item ("Lift Bridge Farm Girl", 4);
	Item fulton_IPA = new Item ("Fulton IPA", 6);
	Item amstel_Light = new Item ("Amstel Light", 6);
	Item guinness = new Item ("Guinness", 8);
	Item french_Martini = new Item ("French Martini", 10);
	Item redSangria = new Item ("Red Sangria", 10);
	Item jameson_Ginger = new Item ("Jameson & Ginger", 10);
	Item whiteWine = new Item ("White Wine", 7);
	Item redWine = new Item ("Red Wine", 5);
	Item coke = new Item ("Coke", 4);
	Item sprite = new Item ("Sprite", 4);
	Item lemonade = new Item ("Lemonade", 4);
	Item drPepper = new Item ("Dr. Pepper", 4);
	Item orangejuice = new Item ("Orange Juice", 5);
	Item cranberryJuice = new Item ("Cranberry Juice", 5);
	Item iceTea = new Item ("ice Tea", 5);
	Item water = new Item ("water", 0);
	private String category;

	public Menu () {
		ArrayList <Item> list = new ArrayList <Item> ();

		//appetizers arrayList
		appetizers.add(smoked_Salmon);
		appetizers.add(spinach_Artichoke_Dip);
		appetizers.add(escargot);
		appetizers.add(grilled_Octopus);
		appetizers.add(crab_Cakes);
		appetizers.add(smoked_Beef_Croquettes);
		appetizers.add(calamari);
		appetizers.add(mussels_Marinieres);
		appetizers.add(duck_Wings);
		appetizers.add(beef_Bites);
		appetizers.add(walleye_Fingers);

		pasta.add(fettuccine_Alfredo);
		pasta.add(chicken_Alfredo);
		pasta.add(shrimpAlfredo);
		pasta.add(lobster_Spaghetti);
		pasta.add(creole_Sausage_Penne);
		
		//specialties
		specialties.add(panRoast_Half_Chicken);


	}

}