package culverT01.cardgameplayer;

import java.util.ArrayList;

public class KeyFunction {

	// Constructor
	public KeyFunction() {
	}

	// Behaviour
	//Shuffle a player's deck method
	public void shuffleDeck(Player player) {
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

	//Display a player's frontline
	public void displayFrontline(Player player, String cardType) {
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
				// Output the name, health, attack and position in the array of the Creature
				// stored there.
				System.out.print(player.getFrontline()[i].getName() + "\n" 
						+ player.getFrontline()[i].getHealth() + "\n"
						+ player.getFrontline()[i].getAttack() + "\n position: " + i);
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
	public void displayWasteland(Player player, String cardType) {
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
					// Output the name, health, attack and position in the array of the Creature
					// stored there.
					System.out.print(player.getWasteland().get(i).getName() + "\n"
							+ ((CreatureCard) player.getWasteland().get(i)).getHealth() + "\n"
							+ ((CreatureCard) player.getWasteland().get(i)).getAttack() + "\n position: " + i);
					System.out.print("|\n|\n|\n|\t");
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
					// Output the name, effect description, attack and position in the array of the
					// Support Card stored there.
					System.out.print(player.getWasteland().get(i).getName() + "\n"
							+ ((SupportCard) player.getWasteland().get(i)).getEffectDesc() + "\n position: " + i);
					System.out.print("|\n|\t");
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
	public void displayDeck(Player player, String cardType) {
		// If cardType equals:
		switch (cardType) {
		// Magic Creature, then:
		case "Magic Creature":
			// Melee Creature, then:
		case "Melee Creature":
			// Loop for integer i is less than the length of the player's wasteland array
			// list, increasing i by 1 for each loop
			for (int i = 0; i < player.getDeck().size(); i++) {
				// If item at position i in player's wasteland array's card type is equal to
				// cardType parameter, then:
				if (player.getDeck().get(i).getCardType() == cardType) {
					// Output the name, health, attack and position in the array of the Creature
					// stored there.
					System.out.print(player.getDeck().get(i).getName() + "\n"
							+ ((CreatureCard) player.getDeck().get(i)).getHealth() + "\n"
							+ ((CreatureCard) player.getDeck().get(i)).getAttack() + "\n position: " + i);
					System.out.print("|\n|\n|\n|\t");
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
			for (int i = 0; i < player.getDeck().size(); i++) {
				// If item at position i in player's wasteland array's card type is equal to
				// 'Magic Creature', then:
				if (player.getDeck().get(i).getCardType() == cardType) {
					// Output the name, health, attack and position in the array of the Creature
					// stored there.
					System.out.print(player.getDeck().get(i).getName() + "\n"
							+ ((SupportCard) player.getDeck().get(i)).getEffectDesc() + "\n position: " + i);
					System.out.print("|\n|\t");
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
}
