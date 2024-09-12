package culverT01.cardgameplayer;

import java.util.ArrayList;

public class KeyFunction {

	// Constructor
	public KeyFunction() {
	}

	// Behaviours
	//Display a player's frontline
	public static void displayFrontline(Player player, String cardType) {
		// Loop for integer i is less than the length of the player's frontline array,
		// increasing i by 1 for each loop
		for (int i = 0; i < player.getFrontline().length; i++) {
			// If item at position i in player's frontline array is equal to null, then:
			if (player.getFrontline()[i] == null) {
				// Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			// If item at position i in player's frontline array's card type is equal to
			// cardType parameter, then:
			else if (player.getFrontline()[i].getCardType() == cardType) {
				// Output the name, health, attack, skill and position in the array of the Creature
				// stored there.
				System.out.print(player.getFrontline()[i].getName() + "\n" 
						+ player.getFrontline()[i].getHealth() + "\n"
						+ player.getFrontline()[i].getAttack() + "\n" 
						+ player.getFrontline()[i].getSkill() + "\n position: " + i);
				System.out.print("|\n|\n|\n|\t");
			}
			// Else, then:
			else {
				// Output whitespace
				System.out.print("");
			}
		}
	}
	//Display a player's wasteland
	public static void displayWasteland(Player player, String cardType) {
		// If cardType equals:
		switch (cardType) {
		// Magic Creature, then:
		case "Magic Creature":
			// Melee Creature, then:
		case "Melee Creature":
			// Loop for integer i is less than the length of the player's wasteland array
			// list, increasing i by 1 for each loop
			for (int i = 0; i < player.getWasteland().size(); i++) {
				// If item at position i in player's wasteland array's card type is equal to
				// cardType parameter, then:
				if (player.getWasteland().get(i).getCardType() == cardType) {
					// Output the name, health, attack, skill and position in the array of the Creature
					// stored there.
					System.out.print(player.getWasteland().get(i).getName() + "\n"
							+ ((CreatureCard) player.getWasteland().get(i)).getHealth() + "\n"
							+ ((CreatureCard) player.getWasteland().get(i)).getAttack()
							+ player.getWasteland().get(i).getSkill() + "\n" + "\n position: " + i);
					System.out.println("|\n|\n|\n|\t");
				}
				// Else, then:
				else {
					// Output whitespace
					System.out.print("");
				}
			}
			// Prevent other cases running
			break;
		// Item Support, then:
		case "Item Support":
			// Magic Support, then:
		case "Magic Support":
			// Loop for integer i is less than the length of the player's wasteland array
			// list, increasing i by 1 for each loop
			for (int i = 0; i < player.getWasteland().size(); i++) {
				// If item at position i in player's wasteland array's card type is equal to
				// cardType parameter, then:
				if (player.getWasteland().get(i).getCardType() == cardType) {
					// Output the name, skill, effect description and position in the array of the
					// Support Card stored there.
					System.out.print(player.getWasteland().get(i).getName() + "\n"
							+ player.getWasteland().get(i).getSkill() + "\n"
							+ ((SupportCard) player.getWasteland().get(i)).getEffectDesc() + "\n position: " + i);
					System.out.println("|\n|\n|\n|\t");
				}
				// Else, then:
				else {
					// Output whitespace
					System.out.print("");
				}
			}
			// Prevent other cases running
			break;
		// Else, then:
		default:
			// Output 'Invalid card type'
			System.out.println("Invalid card type");
		}
	}

	//Display a player's deck
	public static void displayDeck(Player player, String cardType) {
		// If cardType equals:
		switch (cardType) {
		// Magic Creature, then:
		case "Magic Creature":
			// Melee Creature, then:
		case "Melee Creature":
			// Loop for integer i is less than the length of the player's deck array
			// list, increasing i by 1 for each loop
			for (int i = 0; i < player.getDeck().size(); i++) {
				// If item at position i in player's deck array's card type is equal to
				// cardType parameter, then:
				if (player.getDeck().get(i).getCardType() == cardType) {
					// Output the name, health, attack, skill and position in the array of the Creature
					// stored there.
					System.out.print(player.getDeck().get(i).getName() + "\n"
							+ ((CreatureCard) player.getDeck().get(i)).getHealth() + "\n"
							+ ((CreatureCard) player.getDeck().get(i)).getAttack() + "\n"
							+ player.getDeck().get(i).getSkill() + "\n position: " + i);
					System.out.println("|\n|\n|\n|\n|\t");
				}
				// Else, then:
				else {
					// Output whitespace
					System.out.print("");
				}
			}
			// Prevent other cases running
			break;
		// Item Support, then:
		case "Item Support":
			// Magic Support, then:
		case "Magic Support":
			// Loop for integer i is less than the length of the player's deck array
			// list, increasing i by 1 for each loop
			for (int i = 0; i < player.getDeck().size(); i++) {
				// If item at position i in player's deck array's card type is equal to
				// 'Magic Creature', then:
				if (player.getDeck().get(i).getCardType() == cardType) {
					// Output the name, skill, effect description and position in the array of the
					// Support Card stored there.
					System.out.print(player.getDeck().get(i).getName() + "\n" + player.getDeck().get(i).getSkill()
							+ "\n" + ((SupportCard) player.getDeck().get(i)).getEffectDesc() + "\n position: " + i);
					System.out.println("|\n|\n|\t");
				}
				// Else, then:
				else {
					// Output whitespace
					System.out.print("");
				}
			}
			// Prevent other cases running
			break;
		// Else, then:
		default:
			// Output 'Invalid card type'
			System.out.println("Invalid card type");
		}
	}
	
	//Display a player's hand
	public static void displayHand(Player player) {
		// Loop for integer i is less than the size of the hand array, increasing i by 1
		// each loop
		for (int i = 0; i < player.getHand().size(); i++) {
			// If the card type at position i of hand is 'Melee Creature' or 'Magic
			// Creature', then:
			if (player.getHand().get(i).getCardType() == "Melee Creature"
					|| player.getHand().get(i).getCardType() == "Magic Creature") {
				// Output the name, skill, health, attack and position in hand array of the card
				System.out.print(player.getHand().get(i).getName() + "\n" + player.getHand().get(i).getCardType() + "\n"
						+ ((CreatureCard) player.getHand().get(i)).getHealth() + "\n"
						+ ((CreatureCard) player.getHand().get(i)).getAttack() + "\n"
						+ player.getHand().get(i).getSkill() + "\n position: " + i);
				System.out.print("|\n|\n|\n|\n|\n|\t");
			} else {
				// Output the name, skill, description of effect and position in hand array of
				// the card
				System.out.print(player.getHand().get(i).getName() + "\n" + player.getHand().get(i).getCardType() + "\n"
						+ player.getHand().get(i).getSkill() + "\n"
						+ ((SupportCard) player.getHand().get(i)).getEffectDesc() + "\n position: " + i);
				System.out.print("|\n|\n|\t");
			}
		}
	}
	//Display the player's field
	public static void displayField(Player player) {
		System.out.println(player.getPlayerName() + "'s Frontline:");
		for(int i = 0; i < player.getFrontline().length; i++) {
			// If item at position i in player's frontline array is equal to null, then:
			if (player.getFrontline()[i] == null) {
				// Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			// Output the name, health, attack, skill and position in the array of the Creature
			// stored there.
			System.out.print(player.getFrontline()[i].getName() + "\n" 
					+ player.getFrontline()[i].getHealth() + "\n"
					+ player.getFrontline()[i].getAttack() + "\n" 
					+ player.getFrontline()[i].getSkill() + "\n position: " + i);
			System.out.print("|\n|\n|\n|\t");
		}
		System.out.println(player.getPlayerName() + "'s Wasteland:");
		if( player.getWasteland().size() > 0) {
			for(Card ca : player.getWasteland()) {
				System.out.print(ca.getName() + "\n" + ca.getCardType() + "\n" + ca.getSkill() + "\n position: "
						+ player.getWasteland().indexOf(ca));
				System.out.print("|\n|\n|\n|\t");
			}
		}
		
	}
	//Check a player's wasteland
	public static boolean checkWasteland(Player player, String cardType) {
		//Set integer cardCount to 0
		int cardCount = 0;
		//Loop for Card ca is in a player's wasteland
		for(Card ca : player.getWasteland()) {
			//If the cardType of ca is equal to cardType, then:
			if(ca.getCardType() == cardType) {
				//Increase cardCount by 1
				cardCount += 1;
			}
		}
		//If cardCount is more than 0, then:
		if (cardCount > 0) {
			//Return the value true
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}
	//Check a player's deck
	public static boolean checkDeck(Player player, String cardType) {
		//Set integer cardCount to 0
		int cardCount = 0;
		//Loop for Card ca is in a player's deck
		for(Card ca : player.getDeck()) {
			//If the cardType of ca is equal to cardType, then:
			if(ca.getCardType() == cardType) {
				//Increase cardCount by 1
				cardCount += 1;
			}
		}
		//If cardCount is more than 0, then:
		if (cardCount > 0) {
			//Return the value true
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}
	//Check a player's hand
	public static boolean checkHand(Player player, String cardType) {
		//Set integer cardCount to 0
		int cardCount = 0;
		//Loop for Card ca is in a player's deck
		for(Card ca : player.getHand()) {
			//If the cardType of ca is equal to cardType, then:
			if(ca.getCardType() == cardType) {
				//Increase cardCount by 1
				cardCount += 1;
			}
		}
		//If cardCount is more than 0, then:
		if (cardCount > 0) {
			//Return the value true
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}
	//Shuffle a player's deck method
	public static void shuffleDeck(Player player) {
		// Create an ArrayList that stores the Card Object called temp
		ArrayList<Card> temp = new ArrayList<Card>();
		// Loop for integer j is less than size of the player's deck array, increasing j
		// by each loop
		for (int j = 0; j < player.getDeck().size(); j++) {
			// Add the item at position j to the temp array
			temp.add(player.getDeck().get(j));
		}
		// Remove all items from the player's deck array
		player.getDeck().clear();
		// While the size of the temp array is not 0:
		while (temp.size() != 0) {
			/* Set integer randomNum to equal a random number between 0 and the size of the
				 temp array */
			int randomNum = (int) (Math.random() * temp.size());
			// Add to the player's deck the item at position randomNum in the temp array
			player.getDeck().add(temp.get(randomNum));
			// Remove item at position randomNum in the temp array
			temp.remove(randomNum);
		}
	}
	//draw Four Cards method
	public static void drawFourCards(Player player) {
		//Loop for integer i is less than 4, incrementing i by 1 each loop
		for(int i = 0; i < 4; i++) {
			//Call player's draw method
			player.draw();
		}
	}
	//shuffle Four Cards method
	public static void shuffleFourCards(Player player) {
		//Loop for k is less than 4, incrementing k by 1 each loop
		for(int k = 0; k < 4; k++) {
			//Add the Card in position 0 of player's hand to player's deck
			player.getDeck().add(player.getHand().get(0));
			//Remove the Card in position 0 of player's hand
			player.getHand().remove(0);
		}
		//Call the class KeyFunction's shuffleDeck method, passing player as an argument
		KeyFunction.shuffleDeck(player);
	}
}
