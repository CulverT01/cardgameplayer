package culverT01.cardgameplayer;

import java.util.Scanner;

public class CreatureCard extends Card{
	//Attributes
	private int health;
	private int attack;
	private String skill;
	
	//Constructor
	public CreatureCard(String name, String cardType, int health, int attack, String skill) {
		super(name, cardType);
		this.setHealth(health);
		this.setAttack(attack);
		this.setSkill(skill);
	}

	//Behaviour
		// Attack Method
		public void creatureAttack(Player opponent){
			//Integer to keep track of number of null values in opponent's frontline array.
			int nullCounter = 0;
			//Loop for integer i is less than the length of the opponent's frontline array, increasing i by 1 for each loop
			for (int i = 0; i < opponent.getFrontline().length; i++) {
				//If item at position i in opponent's frontline array is equal to null, then:
				if(opponent.getFrontline()[i] == null) {
					//Increase nullCounter by 1
					nullCounter++;
				}
				//Else, then:
				else {
					//Output the name, health, attack and position in the array of the Creature stored there.
					System.out.print(opponent.getFrontline()[i].getName() +"\n"+ opponent.getFrontline()[i].getHealth() +"\n"+ opponent.getFrontline()[i].getAttack() +"\n position: "+ i);
					System.out.print("|\n|\n|\n|\t");
				}	
			}
			//If nullCounter is less than 4, then:
			if( nullCounter < 4) {
				//Create new Scanner object to take input
				Scanner input = new Scanner(System.in);
					//Ask User to input the number of the position of the creature they want to attack
					System.out.println("Enter the number of the position of the creature you want to attack");
					//Set integer choice to be next inputed integer
					int choice = input.nextInt();
					//Output that this creature attacks selected creature
					System.out.println(name + " attacks " + opponent.getFrontline()[choice].getName());
					//Set integer result to equal to result of the selected creature's health subtract this creature's attack
					int result = opponent.getFrontline()[choice].getHealth() - attack;
					//If result is less than or equal to 0, then:
					if (result <= 0) {
						//Add selected creature to opponent's wasteland array
						opponent.getWasteland().add(opponent.getFrontline()[choice]);
						//Set the value at selected position in opponent's frontline array to null
						opponent.getFrontline()[choice] = null;
					}
					//Else, then:
					else {
						//Set the selected creature's health to equal result
						opponent.getFrontline()[choice].setHealth(result);
					}
					//input.close();
			}
			//Else, then:
			else {
				//Set integer directResult to equal to result of the opponent's defence Points subtract this creature's attack
				int directResult = opponent.getDefencePoints() - attack;
				//If directResult is less than 0, then:
				if (directResult < 0) {
					//Set opponent's defence Points to 0
					opponent.setDefencePoints(0);
				}
				//Else, then:
				else {
					//Set opponent's defence points to equal directResult
					opponent.setDefencePoints(directResult);
				}
			}
		}
		
	//Getters and Setters
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}
