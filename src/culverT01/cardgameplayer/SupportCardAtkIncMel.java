package culverT01.cardgameplayer;

import java.util.Scanner;

public class SupportCardAtkIncMel extends SupportCard {
	//Attribute
	private int strength;

	//Constructor
	public SupportCardAtkIncMel(String name, String cardType, String effectDesc, int strength) {
		super(name, cardType, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	//Effect method
	public void effect(Player player, KeyFunction keyFunction) {
		//Call keyFunction's displayFrontline method, passing player and 'Melee Creature' as arguments
		keyFunction.displayFrontline(player, "Melee Creature");
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input the number of the position of the card they want to apply this cards effect to
		System.out.println("Enter the position of the Melee Creature you wish to increase its Attack by " + strength);
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
