package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardSerMs extends SupportCard {

	//Constructor
	public SupportCardSerMs(String name, String cardType, String effectDesc) {
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
			//If item at position i in player's deck array list's card type is equal to 'Item Support', then:
			else if(player.getDeck().get(i).getCardType() == "Magic Support") {
				//Output the name, health, attack and position in the array of the Creature stored there.
				System.out.print(player.getDeck().get(i).getName() + "\n"
						+ ((SupportCard) player.getDeck().get(i)).getEffectDesc() + "\n position: " + i);
				System.out.print("|\n|\n|\t");
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
		System.out.println("Enter the position of the Magic Support Card you wish to add to your Hand");
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Add selected item to the hand array list
		player.getHand().add(player.getDeck().get(choice));
		//Remove selected item from the deck array list
		player.getDeck().remove(choice);

	}

}
