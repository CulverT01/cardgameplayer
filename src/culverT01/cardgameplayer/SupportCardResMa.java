package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardResMa extends SupportCard {

	//Constructor
	public SupportCardResMa(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);
		
	}

	//Behaviour
	@Override
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayWasteland method, passing player and 'Magic Creature' as arguments
		keyFunction.displayWasteland(player, "Magic Creature");
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Melee Creature you wish to play from your Wasteland");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//While freeSpace is false or j is less than 4:
		for (int j = 0; j < player.getFrontline().length; j++) {
			//If the item at position j in the player's frontline is null, then:
			if(player.getFrontline()[j] == null) {
				//Set the item at positon j in the player's frontline to be the selected item in the wasteland array
				player.getFrontline()[j] = (CreatureCard) player.getWasteland().get(choice);
				//Remove the selected item from the wasteland array
				player.getWasteland().remove(choice);
				break;
			}
		}
	}

}
