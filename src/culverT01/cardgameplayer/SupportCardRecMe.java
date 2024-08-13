package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardRecMe extends SupportCard {

	//Constructor
	public SupportCardRecMe(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);
	}

	//Behaviour
	@Override
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayWasteland method, passing player and 'Melee Creature' as arguments
		keyFunction.displayWasteland(player, "Melee Creature");
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Melee Creature you wish to return from your Wasteland to your deck");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Add selected item in player's wasteland array list to the end of player's deck array list
		player.getDeck().add(player.getWasteland().get(choice));
		//Remove the selected item from player's wasteland array list
		player.getWasteland().remove(choice);
	}

}
