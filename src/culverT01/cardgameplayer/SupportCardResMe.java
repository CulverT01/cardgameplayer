package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardResMe extends SupportCard {
	//Constructor
	public SupportCardResMe(String name, String cardType, String skill, String effectDesc) {
		super(name, cardType, skill, effectDesc);
		// TODO Auto-generated constructor stub
	}
	//Behaviour
	@Override
	public boolean effect(Player player) {
		//Call keyFunction's displayWasteland method, passing player and 'Magic Creature' as arguments
		KeyFunction.displayWasteland(player, "Melee Creature");
		//Set boolean successfulTarget to the returned value of keyFunction.checkWasteland
		boolean successfulTarget = KeyFunction.checkWasteland(player, "Melee Creature");
		//If successfulTarget equals to true, then:
		if (successfulTarget == true) {
			//Create new Scanner object to take input
			Scanner input = new Scanner(System.in);
			//Ask User to input the number of the position of the card they want to apply this cards effect to
			System.out.println("Enter the position of the Melee Creature you wish to play from your Wasteland");
			//Set integer choice to be next inputed integer
			int choice = input.nextInt();
			//Set integer j to 0
			int j = 0;
			//Loop while j is less than the length of the player's frontline:
			while (j < player.getFrontline().length) {
				//If the item at position j in the player's frontline is null, then:
				if(player.getFrontline()[j] == null) {
					//Set the item at positon j in the player's frontline to be the selected item in the wasteland array
					player.getFrontline()[j] = (CreatureCard) player.getWasteland().get(choice);
					//Remove the selected item from the wasteland array
					player.getWasteland().remove(choice);
					//Stop loop
					break;
				}
				//Else, then:
				else {
					//Increase j by 1
					j++;
				}
			}
			//If j is less than the length of the player's frontline, then:
			if (j < player.getFrontline().length) {
				//Return the value true
				return true;
			}
			//Else, then:
			else {
				//Return the value false
				return false;
			}
		}
		//Else, then:
		else {
			//Return the value false
			return false;
		}
	}
}
