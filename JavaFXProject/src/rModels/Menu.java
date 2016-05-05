package rModels;

import java.util.ArrayList;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project RItem class
 *
 */
public class Menu {

	//Appetizers
	ArrayList <RItem> appetizers = new ArrayList <RItem> ();
	RItem smoked_Salmon = new RItem ("Smoked Salmon", 9);
	RItem spinach_Artichoke_Dip = new RItem ("Spinach & Artichoke Dip", 10);
	RItem escargot = new RItem ("Escargot", 10);
	RItem grilled_Octopus = new RItem ("Grilled Octopus", 11);
	RItem crab_Cakes = new RItem ("Crab Cakes", 11);
	RItem smoked_Beef_Croquettes = new RItem ("Smoked Beef Croquettes", 13);
	RItem calamari = new RItem ("Calamari", 13);
	RItem mussels_Marinieres = new RItem ("Mussels Marinieres", 15);
	RItem duck_Wings = new RItem ("Duck Wings L'Orange", 15);
	RItem beef_Bites = new RItem ("Beef Bites Au Poivre", 15);
	RItem walleye_Fingers = new RItem ("Walleye Fingers", 15);


	//Pasta
	ArrayList <RItem> pasta = new ArrayList <RItem> ();
	RItem fettuccine_Alfredo = new RItem ("Fettuccine Alfredo", 14);
	RItem chicken_Alfredo = new RItem ("Chicken Fettuccine Alfredo", 18);
	RItem shrimpAlfredo = new RItem ("Shrimp Fettuccine Alfredo", 20);
	RItem lobster_Spaghetti = new RItem ("Lobster Spaghetti", 28);
	RItem creole_Sausage_Penne = new RItem ("Creole Sausage Penne", 18);

	//Specialties
	ArrayList <RItem> specialties = new ArrayList <RItem> ();
	RItem panRoast_Half_Chicken = new RItem ("Pan Roast Half Chicken", 20);
	RItem chicken_Chardonnay = new RItem ("Chicken Chardonnay", 15);
	RItem chicken_Francaise = new RItem ("Chicken Française", 24);
	RItem pork_Chop = new RItem ("Pork Chop", 20);
	RItem duck = new RItem ("Duck", 26);
	RItem lambTBone = new RItem ("Lamb T-Bone", 30);
	RItem veal_Piccata = new RItem ("Veal Piccata", 26);
	RItem veal_Parmesan = new RItem ("Veal Parmesan", 26);
	RItem veal_Marsala = new RItem ("Veal Marsala", 28);
	RItem primeSteak = new RItem ("Prime Top Sirloin Steak", 28);
	RItem filet_Mignon = new RItem ("Filet Mignon Steak", 38);
	RItem ribeyeSteak = new RItem ("Ribeye Steak", 38);

	//salads
	ArrayList <RItem> salads = new ArrayList <RItem> ();
	RItem mixedGreens = new RItem ("Mixed Greens Salad", 7);
	RItem spinach = new RItem ("Spinach Salad", 8);
	RItem wedge = new RItem ("Ribeye Steak", 9);
	RItem beet = new RItem ("Beet", 9);
	RItem chickenCaesar = new RItem ("Chicken Caesar Salad", 14);
	RItem caesar = new RItem ("Caesar Salad", 7);
	RItem calamariCaesar = new RItem ("Calamari Caesar Salad", 38);
	RItem shrimpCaesar = new RItem ("Shrimp Caesar Salad", 16);
	RItem salmonCaesar = new RItem ("Salmon Caesar Salad", 18);

	//Dressings
	ArrayList <RItem> dressings = new ArrayList <RItem> ();
	RItem ranch = new RItem ("Ranch", 0);
	RItem italian = new RItem ("Italian", 0);
	RItem vinegret = new RItem ("Vinegret", 0);
	RItem lemon = new RItem ("Lemon", 0);

	//Seafood
	ArrayList <RItem> seafood = new ArrayList <RItem> ();
	RItem salmon = new RItem ("Salmon", 26);
	RItem walleye = new RItem ("Walleye", 30);
	RItem seabass = new RItem ("Sea Bass", 36);
	RItem scallops = new RItem ("Seared Scallops", 28);
	RItem prawns = new RItem ("Blackened Prawns", 32);

	//Soups
	ArrayList <RItem> soups = new ArrayList <RItem> ();
	RItem frenchOnion = new RItem ("French Onion Soup", 7);
	RItem scallopAndCucumber = new RItem ("callop & Cucumber Soup", 9);

	//Sides
	ArrayList <RItem> sides = new ArrayList <RItem> ();
	RItem sauteed_Vegetable_Medley = new RItem ("Sautéed Vegetable Medley", 4);
	RItem green_Beans = new RItem ("Green Beans", 4);
	RItem sauteed_Mushrooms = new RItem ("Sautéed Mushrooms", 6);
	RItem asparagus = new RItem ("Asparagus with Hollandaise", 9);
	RItem sauteed_Potatoes = new RItem ("Sautéed Fingerling Potatoes", 4);
	RItem mashed_Potatoes = new RItem ("Boursin Mashed Potatoes", 4);
	RItem parmesan_Potatoes = new RItem ("Parmesan Leek Potatoes", 4);
	RItem house_Cut_Fries = new RItem ("House Cut Fries with Béarnaise", 5);
	RItem mushroom_Risotto = new RItem ("Wild Mushroom Risotto", 5);
	RItem mac_Cheese = new RItem ("Baked Mac & Cheese", 8);

	//dessert
	ArrayList <RItem> dessert = new ArrayList <RItem> ();
	RItem chomeur_Pudding = new RItem ("Signature Chomeur Pudding", 9);
	RItem creme_Brulee = new RItem ("Maple Crème Brûlée", 5);
	RItem choc_custard_Cake = new RItem ("Chocolate Ganache Custard Cake", 5);
	RItem frenchTart = new RItem ("French Silk Tart", 5);
	RItem vanilla_Cheesecake = new RItem ("Vanilla Cheesecake", 6);
	RItem choc_Lava_Cake = new RItem ("Chocolate Molten Lava Cake", 6);
	RItem house_Ice_Cream = new RItem ("House Made Ice Cream & Sorbet", 6);

	//Drinks
	ArrayList <RItem> drinks = new ArrayList <RItem> ();
	RItem stellaArtois = new RItem ("Stella Artois", 7);
	RItem budweiser = new RItem ("Budweiser", 5);
	RItem coors_Light = new RItem ("Coors Light", 5);
	RItem oDouls = new RItem ("O'Doul's", 5);
	RItem bards_Gluten_Free = new RItem ("Bard's Gluten Free", 6);
	RItem sam_Adams = new RItem ("Sam Adams", 6);
	RItem lift_Bridge = new RItem ("Lift Bridge Farm Girl", 4);
	RItem fulton_IPA = new RItem ("Fulton IPA", 6);
	RItem amstel_Light = new RItem ("Amstel Light", 6);
	RItem guinness = new RItem ("Guinness", 8);
	RItem french_Martini = new RItem ("French Martini", 10);
	RItem redSangria = new RItem ("Red Sangria", 10);
	RItem jameson_Ginger = new RItem ("Jameson & Ginger", 10);
	RItem whiteWine = new RItem ("White Wine", 7);
	RItem redWine = new RItem ("Red Wine", 5);
	RItem coke = new RItem ("Coke", 4);
	RItem sprite = new RItem ("Sprite", 4);
	RItem lemonade = new RItem ("Lemonade", 4);
	RItem drPepper = new RItem ("Dr. Pepper", 4);
	RItem orangejuice = new RItem ("Orange Juice", 5);
	RItem cranberryJuice = new RItem ("Cranberry Juice", 5);
	RItem iceTea = new RItem ("ice Tea", 5);
	RItem water = new RItem ("water", 0);
	private String category;

	public Menu () {
		ArrayList <RItem> list = new ArrayList <RItem> ();

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

	//Getters for arrays
	public ArrayList<RItem> getAppetizers() {

		//Return the appetizers
		return appetizers;
	}

}