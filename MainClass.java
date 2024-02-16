import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MainClass {

	private static ArrayList<BagItemSuperclass> items = new ArrayList<BagItemSuperclass>();

	public static void main(String[] args) {
		// STEP 0:
		// setting up the required local variables
		int numDraws = 0;
		int currBustValue = 0;
		int bustAmount = 6;
		int totalItems = 0;
		String input = "";
		Scanner scan = new Scanner(System.in);

		System.out.println(
				"Welcome to the Mystery Bag Game! Your aim is to draw all the items in the bag without going bust!");
		System.out.println("[E]asy");
		System.out.println("[M]edium");
		System.out.println("[D]ifficult");
		input = scan.next();
		// STEP 1:
		// responding to difficulty based on the user input and filling the bag.

		if (input.equalsIgnoreCase("E")) {
			totalItems = 5;
			System.out.println("Easy! Adding five items....\n" + "Done!");

			// adding items to the bag in the easy difficulty.
			for (int i = 0; i < totalItems; i++)
				items.add(GenerateNewBagItem());

		}

		else if (input.equalsIgnoreCase("M")) {
			totalItems = 7;
			System.out.println("Medium! Adding seven items...\nDone!");
			// adding items to the bag in the medium difficulty.
			for (int i = 0; i < totalItems; i++)
				items.add(GenerateNewBagItem(0.3));
		}

		else if (input.equalsIgnoreCase("D")) {
			totalItems = 9;
			System.out.println("Difficult! Adding nine items...\nDone!");
			// adding items to the bag in the difficult difficulty.
			for (int i = 0; i < totalItems; i++)
				items.add(GenerateNewBagItem(0.2, 0.4));
		}

		else {
			System.out.println("Invalid Option Selected.");
		}

		while (numDraws < items.size() && currBustValue < bustAmount) {
			// STEP 2:
			// drawing repeatedly here until the player has emptied the bag
			// or until they've gone bust.
			System.out.println("Time to draw!You are on draw " + (numDraws + 1) + " of " + items.size());
			System.out.println("Your current bust value is " + currBustValue + " of 6.");
			System.out.println("Type anything to draw...");
			input = scan.next();
			currBustValue += items.get(numDraws).ItemDrawn();

			numDraws++;

		}

		// STEP 3:
		// Telling the players how they've done.
		if (currBustValue >= 6) {
			System.out.println("Game Over! You went bust on draw " + numDraws + " of" + totalItems);
		} else {
			System.out.println("Game Over! You drew all the items! Well done!");
		}

		// closing streams.
		scan.close();

	}

	public static BagItemSuperclass GenerateNewBagItem() {

		return new BlankItem();

	}

	public static BagItemSuperclass GenerateNewBagItem(double diceChance) {
		double val = Math.random(); // Returns a double type number greater than or equal to 0.0 and less than 1.0

		/*
		 * comparing val with the parameter diceChance to decide if a DiceItem object or
		 * a BlankItem object should be returned.
		 */
		if (val < diceChance) {
			return new DiceItem();
		}

		return new BlankItem();
	}

	public static BagItemSuperclass GenerateNewBagItem(double diceChance, double coinChance) {

		double val = Math.random();
		if (val < diceChance) {
			return new DiceItem();
		} else if (val > diceChance && val < (coinChance + diceChance))
		// the chance of picking a coin item is 40%. It gets picked if val is between
		// 0.2 and 0.6.
		{
			return new CoinItem();
		}

		else {
			return new BlankItem();
		}

	}

}
