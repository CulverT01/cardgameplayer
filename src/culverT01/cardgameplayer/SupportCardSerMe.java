package culverT01.cardgameplayer;

import java.util.ArrayList;
import java.util.Scanner;

public class SupportCardSerMe extends SupportCard {

	//Constructor
	public SupportCardSerMe(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);

	}

	//Behaviour
	@Override
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayDeck method, passing player and 'Melee Creature' as arguments
		keyFunction.displayDeck(player, "Melee Creature");
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Melee Creature you wish to add to your Hand");
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
