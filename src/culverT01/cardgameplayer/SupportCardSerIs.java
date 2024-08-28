package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardSerIs extends SupportCard {

	//Constructor
	public SupportCardSerIs(String name, String cardType, String skill, String effectDesc) {
		super(name, cardType, skill, effectDesc);

	}

	//Behaviour
	@Override
	public boolean effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayDeck method, passing player and 'Item Support' as arguments
		keyFunction.displayDeck(player, "Item Support");
		//Set boolean successfulTarget to the returned value of keyFunction's checkDeck method, passing player and 'Item Support' as arguments
		boolean successfulTarget = keyFunction.checkDeck(player, "Item Support");
		//If successfulTarget equals to true, then:
		if (successfulTarget == true) {
			//Create new Scanner object to take input
			Scanner input = new Scanner(System.in);
			//Ask User to input the number of the position of the card they want to apply this cards effect to
			System.out.println("Enter the position of the Item Support Card you wish to add to your Hand");
			//Set integer choice to be next inputed integer
			int choice = input.nextInt();
			//Add selected item to the hand array list
			player.getHand().add(player.getDeck().get(choice));
			//Remove selected item from the deck array list
			player.getDeck().remove(choice);
			//Call keyFunction's ShuffleDeck method, passing player as an argument to shuffle the deck
			keyFunction.shuffleDeck(player);
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}

}
