package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardResMe extends SupportCard {
	//Constructor
	public SupportCardResMe(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);
		// TODO Auto-generated constructor stub
	}
	//Behaviour
	@Override
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayWasteland method, passing player and 'Melee Creature' as arguments
		keyFunction.displayWasteland(player, "Melee Creature");
		//Loop for integer i is less than the length of the player's wasteland array list, increasing i by 1 for each loop
		for (int i = 0; i < player.getWasteland().size(); i++) {
			//If item at position i in player's wasteland array is equal to null, then:
			if(player.getWasteland().get(i) == null) {
				//Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			//If item at position i in player's wasteland array's card type is equal to 'Melee Creature', then:
			else if(player.getWasteland().get(i).getCardType() == "Melee Creature") {
				//Output the name, health, attack and position in the array of the Creature stored there.
				System.out
						.print(player.getWasteland().get(i).getName() + "\n" + ((CreatureCard) player.getWasteland().get(i)).getHealth()
								+ "\n" + ((CreatureCard) player.getWasteland().get(i)).getAttack() + "\n position: " + i);
				System.out.print("|\n|\n|\n|\t");
			}
			//Else, then:
			else {
				//Output whitespace
				System.out.print("");
			}
		}
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Melee Creature you wish to play from your Wasteland");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Loop for j is less than the length of the player's frontline array, increasing j for each loop
		for (int j = 0; j < player.getFrontline().length; j++) {
			//If the item at position j in the player's frontline is null, then:
			if(player.getFrontline()[j] == null) {
				//Set the item at positon j in the player's frontline to be the selected item in the wasteland array
				player.getFrontline()[j] = (CreatureCard) player.getWasteland().get(choice);
				//Remove the selected item from the wasteland array
				player.getWasteland().remove(choice);
				//End loop
				break;
			}
		}
	}

}
