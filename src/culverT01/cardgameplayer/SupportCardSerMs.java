package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardSerMs extends SupportCard {

	//Constructor
	public SupportCardSerMs(String name, String cardType, String skill, String effectDesc) {
		super(name, cardType, skill, effectDesc);
	}

	//Behaviour
	@Override
	public boolean effect(Player player) {
		//Call the KeyFunction class's displayDeck method, passing player and 'Magic Creature' as arguments
		KeyFunction.displayDeck(player, "Magic Support");
		//Set boolean successfulTarget to the returned value of keyFunction's checkDeck method, passing player and 'Magic Support' as arguments
		boolean successfulTarget = KeyFunction.checkDeck(player, "Magic Support");
		//If successfulTarget equals to true, then:
		if (successfulTarget == true) {
			//Create new Scanner object to take input
			Scanner input = new Scanner(System.in);
			//Ask User to input the number of the position of the card they want to apply this cards effect to
			System.out.println("Enter the position of the Magic Support Card you wish to add to your Hand");
			//Set integer choice to be next inputed integer
			int choice = input.nextInt();
			//Add selected item to the hand array list
			player.getHand().add(player.getDeck().get(choice));
			//Remove selected item from the deck array list
			player.getDeck().remove(choice);
			//Call keyFunction's ShuffleDeck method, passing player as an argument to shuffle the deck
			KeyFunction.shuffleDeck(player);
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}

}
