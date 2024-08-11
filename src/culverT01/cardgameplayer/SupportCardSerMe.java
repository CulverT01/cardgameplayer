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
	public void effect(Player player) {
		//Loop for integer i is less than the length of the player's deck array list, increasing i by 1 for each loop
		for (int i = 0; i < player.getDeck().size(); i++) {
			//If item at position i in player's deck array list is equal to null, then:
			if(player.getDeck().get(i) == null) {
				//Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			//If item at position i in player's deck array list's card type is equal to 'Melee Creature', then:
			else if(player.getDeck().get(i).getCardType() == "Melee Creature") {
				//Output the name, health, attack and position in the array of the Creature stored there.
				System.out
						.print(player.getDeck().get(i).getName() + "\n" + ((CreatureCard) player.getDeck().get(i)).getHealth()
								+ "\n" + ((CreatureCard) player.getDeck().get(i)).getAttack() + "\n position: " + i);
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
		System.out.println("Enter the position of the Melee Creature you wish to add to your Hand");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Add selected item to the hand array list
		player.getHand().add(player.getDeck().get(choice));
		//Remove selected item from the deck array list
		player.getDeck().remove(choice);
	}

}
