package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCard1 extends SupportCard {
	//Attribute
	private int strength;

	//Constructor
	public SupportCard1(String name, String cardType, String effectDesc, int strength) {
		super(name, cardType, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	//Effect method
	public void effect(Player player) {
		//Loop for integer i is less than the length of the player's frontline array, increasing i by 1 for each loop
		for (int i = 0; i < player.getFrontline().length; i++) {
			//If item at position i in player's frontline array is equal to null, then:
			if(player.getFrontline()[i] == null) {
				//Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			//If item at position i in player's frontline array's card type is equal to 'Melee Creature', then:
			else if(player.getFrontline()[i].getCardType() == "Melee Creature") {
				//Output the name, health, attack and position in the array of the Creature stored there.
				System.out.print(player.getFrontline()[i].getName() +"\n"+ player.getFrontline()[i].getHealth() +"\n"+ player.getFrontline()[i].getAttack() +"\n position: "+ i);
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
		System.out.println("Enter the position of the Melee Creature you wish to increase its Attaack by " + strength);
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Set the attack of chosen creature to equal itself + 300
		player.getFrontline()[choice].setAttack(player.getFrontline()[choice].getAttack() + strength);
	}

	//Getter and Setter
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	
	

}
