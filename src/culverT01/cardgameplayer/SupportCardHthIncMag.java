package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardHthIncMag extends SupportCard{
	//Attribute
	private int strength;

	//Constructor
	public SupportCardHthIncMag(String name, String cardType, String effectDesc, int strength) {
		super(name, cardType, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	public void effect(Player player) {
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Magic Creature you wish to increase its Health by " + strength);
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Set the health of chosen creature to equal itself + 300
		player.getFrontline()[choice].setHealth(player.getFrontline()[choice].getHealth() + strength);
		
	}
	//Getter and Setter
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}
