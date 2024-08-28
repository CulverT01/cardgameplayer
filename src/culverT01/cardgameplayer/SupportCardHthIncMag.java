package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardHthIncMag extends SupportCard{
	//Attribute
	private int strength;

	//Constructor
	public SupportCardHthIncMag(String name, String cardType, String skill, String effectDesc, int strength) {
		super(name, cardType, skill, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	public boolean effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayFrontline method, passing player and 'Magic Creature' as arguments
		keyFunction.displayFrontline(player, "Magic Creature");
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Magic Creature you wish to increase its Health by " + strength);
		//Set integer choice to be next inputed integer
		int choice = input.nextInt();
		//Set the health of chosen creature to equal itself + 300
		player.getFrontline()[choice].setHealth(player.getFrontline()[choice].getHealth() + strength);
		//Return the value true
		return true;
	}
	//Getter and Setter
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}
