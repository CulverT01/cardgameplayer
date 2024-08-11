package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardRecMa extends SupportCard {

	//Constructor
	public SupportCardRecMa(String name, String cardType, String effectDesc) {
		super(name, cardType, effectDesc);
	}

	//Behaviour
	@Override
	public void effect(Player player) {
		//Loop for integer i is less than the length of the player's wasteland array list, increasing i by 1 for each loop
		for (int i = 0; i < player.getWasteland().size(); i++) {
			//If item at position i in player's wasteland array is equal to null, then:
			if(player.getWasteland().get(i) == null) {
				//Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			//If item at position i in player's wasteland array's card type is equal to 'Magic Creature', then:
			else if(player.getWasteland().get(i).getCardType() == "Magic Creature") {
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
		System.out.println("Enter the position of the Magic Creature you wish to return from your Wasteland to your deck");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Add selected item in player's wasteland array list to the end of player's deck array list
		player.getDeck().add(player.getWasteland().get(choice));
		//Remove the selected item from player's wasteland array list
		player.getWasteland().remove(choice);

	}

}
