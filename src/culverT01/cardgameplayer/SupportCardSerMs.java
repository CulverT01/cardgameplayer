package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardSerMs extends SupportCard {

	//Constructor
	public SupportCardSerMs(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);
	}

	//Behaviour
	@Override
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayDeck method, passing player and 'Magic Support' as arguments
		keyFunction.displayDeck(player, "Magic Support");
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
		keyFunction.shuffleDeck(player);
	}

}
