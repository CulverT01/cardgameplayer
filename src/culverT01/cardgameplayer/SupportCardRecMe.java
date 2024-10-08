package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardRecMe extends SupportCard {

	//Constructor
	public SupportCardRecMe(String name, String cardType, String skill, String effectDesc) {
		super(name, cardType, skill, effectDesc);
	}

	//Behaviour
	@Override
	public boolean effect(Player player) {
		//Call keyFunction's displayWasteland method, passing player and 'Melee Creature' as arguments
		KeyFunction.displayWasteland(player, "Melee Creature");
		//Set boolean successfulTarget to the returned value of keyFunction.checkWasteland
		boolean successfulTarget = KeyFunction.checkWasteland(player, "Melee Creature");
		//If successfulTarget equals to true, then:
		if (successfulTarget == true) {
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
			//Return the value true
			return true;
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}

}
