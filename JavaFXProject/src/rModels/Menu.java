package rModels;

import java.util.ArrayList;

/**
 *
 * @author Thomas Hernandez CECS 343 Final Project RItem class
 *
 */
public class Menu {

	//Appetizers
	public static ArrayList <RItem> appetizers = new ArrayList <RItem> ();
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
	public static ArrayList <RItem> pasta = new ArrayList <RItem> ();
	RItem fettuccine_Alfredo = new RItem ("Fettuccine Alfredo", 14);
	RItem chicken_Alfredo = new RItem ("Chicken Fettuccine Alfredo", 18);
	RItem shrimpAlfredo = new RItem ("Shrimp Fettuccine Alfredo", 20);
	RItem lobster_Spaghetti = new RItem ("Lobster Spaghetti", 28);
	RItem creole_Sausage_Penne = new RItem ("Creole Sausage Penne", 18);

	//Specialties
	public static ArrayList <RItem> specialties = new ArrayList <RItem> ();
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
	public static ArrayList <RItem> salads = new ArrayList <RItem> ();
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
	public static ArrayList <RItem> dressings = new ArrayList <RItem> ();
	RItem ranch = new RItem ("Ranch", 0);
	RItem italian = new RItem ("Italian", 0);
	RItem vinegret = new RItem ("Vinegret", 0);
	RItem lemon = new RItem ("Lemon", 0);

	//Seafood
	public static ArrayList <RItem> seafood = new ArrayList <RItem> ();
	RItem salmon = new RItem ("Salmon", 26);
	RItem walleye = new RItem ("Walleye", 30);
	RItem seabass = new RItem ("Sea Bass", 36);
	RItem scallops = new RItem ("Seared Scallops", 28);
	RItem prawns = new RItem ("Blackened Prawns", 32);

	//Soups
	public static ArrayList <RItem> soups = new ArrayList <RItem> ();
	RItem frenchOnion = new RItem ("French Onion Soup", 7);
	RItem scallopAndCucumber = new RItem ("callop & Cucumber Soup", 9);

	//Sides
	public static ArrayList <RItem> sides = new ArrayList <RItem> ();
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
	public static ArrayList <RItem> dessert = new ArrayList <RItem> ();
	RItem chomeur_Pudding = new RItem ("Signature Chomeur Pudding", 9);
	RItem creme_Brulee = new RItem ("Maple Crème Brûlée", 5);
	RItem choc_custard_Cake = new RItem ("Chocolate Ganache Custard Cake", 5);
	RItem frenchTart = new RItem ("French Silk Tart", 5);
	RItem vanilla_Cheesecake = new RItem ("Vanilla Cheesecake", 6);
	RItem choc_Lava_Cake = new RItem ("Chocolate Molten Lava Cake", 6);
	RItem house_Ice_Cream = new RItem ("House Made Ice Cream & Sorbet", 6);

	//Drinks
	public static ArrayList <RItem> drinks = new ArrayList <RItem> ();
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
		specialties.add(chicken_Chardonnay);
		specialties.add(chicken_Francaise);
		specialties.add(pork_Chop);
		specialties.add(duck);
		specialties.add(lambTBone);
		specialties.add(veal_Piccata);
		specialties.add(veal_Parmesan);
		specialties.add(veal_Marsala);
		specialties.add(primeSteak);
		specialties.add(filet_Mignon);
		specialties.add(ribeyeSteak);

		//salads
		salads.add(mixedGreens);
		salads.add(spinach);
		salads.add(beet);
		salads.add(wedge);
		salads.add(caesar);
		salads.add(chickenCaesar);
		salads.add(calamariCaesar);
		salads.add(shrimpCaesar);
		salads.add(salmonCaesar);

		//dressings
		dressings.add(ranch);
		dressings.add(italian);
		dressings.add(vinegret);
		dressings.add(lemon);

		//seafood
		seafood.add(salmon);
		seafood.add(walleye);
		seafood.add(seabass);
		seafood.add(scallops);
		seafood.add(prawns);

		//soups
		soups.add(frenchOnion);
		soups.add(scallopAndCucumber);

		//sides
		sides.add(sauteed_Vegetable_Medley);
		sides.add(sauteed_Mushrooms);
		sides.add(asparagus);
		sides.add(sauteed_Potatoes);
		sides.add(mashed_Potatoes);
		sides.add(parmesan_Potatoes);
		sides.add(house_Cut_Fries);
		sides.add(mushroom_Risotto);
		sides.add(mac_Cheese);

		//dessert
		dessert.add(chomeur_Pudding);
		dessert.add(creme_Brulee);
		dessert.add(choc_custard_Cake);
		dessert.add(frenchTart);
		dessert.add(vanilla_Cheesecake);
		dessert.add(choc_Lava_Cake);
		dessert.add(house_Ice_Cream);

		//drinks
		drinks.add(stellaArtois);
		drinks.add(coors_Light);
		drinks.add(budweiser);
		drinks.add(oDouls);
		drinks.add(bards_Gluten_Free);
		drinks.add(sam_Adams);
		drinks.add(lift_Bridge);
		drinks.add(fulton_IPA);
		drinks.add(amstel_Light);
		drinks.add(guinness);
		drinks.add(french_Martini);
		drinks.add(redSangria);
		drinks.add(jameson_Ginger);
		drinks.add(whiteWine);
		drinks.add(redWine);
		drinks.add(coke);
		drinks.add(sprite);
		drinks.add(lemonade);
		drinks.add(drPepper);
		drinks.add(orangejuice);
		drinks.add(cranberryJuice);
		drinks.add(iceTea);
		drinks.add(water);
	}

	//Getter to return all items for lookup
	public static ArrayList<RItem> getAllItems() {

		//Initialize the items
		ArrayList<RItem> allItems = new ArrayList<RItem>();

		allItems.addAll(appetizers);
		allItems.addAll(pasta);
		allItems.addAll(specialties);
		allItems.addAll(salads);
		allItems.addAll(dressings);
		allItems.addAll(seafood);
		allItems.addAll(soups);
		allItems.addAll(sides);
		allItems.addAll(dessert);
		allItems.addAll(drinks);

		//Return the items
		return allItems;
	}

}