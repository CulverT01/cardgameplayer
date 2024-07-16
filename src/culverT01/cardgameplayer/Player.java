package culverT01.cardgameplayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	//Attributes
	private String playerName;
	private int defencePoints;
	private ArrayList<Card> wasteland;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	private CreatureCard [] frontline;

	//Constructor
	public Player(String playerName, int defensePoints) {
		this.setPlayerName(playerName);
		this.setDefencePoints(defensePoints);
		wasteland = new ArrayList<>();
		hand = new ArrayList<>();
		deck = new ArrayList<>();
		frontline = new CreatureCard [4];	
	}

	//Behaviours
	//Draw method
	public void draw() {
		//If deck array is empty, then:
		if(deck.isEmpty() == true) {
			//Subtract 500 from defence points
			defencePoints = defencePoints - 500;
		}
		//Else, then:
		else {
			//Add the card object at position 0 of deck to the hand array
			hand.add(deck.get(0));
			//Remove the card object at position 0 of deck
			deck.remove(0);
		}
		//Loop for integer i is less than the size of the hand array, increasing i by 1 each loop
		for (int i = 0; i < hand.size(); i++) {
			//If the card type at position i of hand is 'Melee Creature' or 'Magic Creature', then: 
			if(hand.get(i).getCardType() == "Melee Creature" || hand.get(i).getCardType() == "Magic Creature") {
				//Output the name, skill, health, attack and position in hand array of the card
				System.out.print(hand.get(i).getName() +"\n"+ ((CreatureCard) hand.get(i)).getSkill() 
						+"\n"+ ((CreatureCard) hand.get(i)).getHealth() +"\n"+ ((CreatureCard) hand.get(i)).getAttack() +"\n position: " + i);
				System.out.print("|\n|\n|\n|\n|\t");
			}
			else {
				//Output the name, skill, description of effect and position in hand array of the card
				System.out.print(hand.get(i).getName() +"\n"+ ((SupportCard) hand.get(i)).getEffectDesc() +"\n position: " + i);
				System.out.print("|\n|\n|\t");
			}	
		}
	}
	//Playing a card from hand method
	public void playCardFromHand() {
		//Try to:create new Scanner object to take input
		try (Scanner input = new Scanner(System.in)) {
			//Ask User to input the number of the position of the card they want to play
			System.out.println("Enter the position of the card in your hand you would like to play");
			//Set integer choice to be next inputed integer
			int choice = input.nextInt();
			//Set String type to equal the card type of the selected card in the hand array
			String type = hand.get(choice).getCardType();
			//If type equals:
			switch(type) {
			//Melee Creature, then
			case "Melee Creature":
			//Magic Creature, then
			case "Magic Creature":
				//Set boolean playedCreature to false
				boolean playedCreature = false;
				//Loop for f is less than the length of the frontline array, increasing f by 1 for each loop
				for(int f = 0; f < frontline.length; f++) {
					//If the item at position f in the frontline array is null, then:
					if( frontline[f] == null) {
						//Set the item at position f in the frontline array to be the selected card
						frontline[f] = (CreatureCard) hand.get(choice);
						//Remove the selected card from the hand
						hand.remove(choice);
						//Set playedCreature to true
						playedCreature = true;
						//Break loop
						break;
					}
				}
				//If playedCreature is equal to false, then:
				if(playedCreature == false) {
					//Output that the front line is full and Creature cards cannot be played
					System.out.println("Front Line is full. You cannot play any Creature cards");
				}
				//Prevent other cases running
				break;
			//Magic Support, then:	
			case "Magic Support":
				//Set boolean playedMagicSupport to false
				boolean playedMagicSupport = false;
				//For each Creature Card ma in frontline:
				for(CreatureCard ma: frontline) {
					//If the card type of ma is equal to 'Magic Creature', then
					if( ma.getCardType() == "Magic Creature") {
						//Run the selected card's effect method
						((SupportCard) hand.get(choice)).effect();
						//Add selected card to the wasteland array
						wasteland.add(hand.get(choice));
						//Remove the selected card from the hand
						hand.remove(choice);
						//Set playedMagicSupport to true
						playedMagicSupport = true;
						//Break loop
						break;
					}
				}
				//If playedMagicSupport is equal to false, then:
				if(playedMagicSupport == false) {
					//Output that their frontline doesn't have magic creatures and thus magic support cards can't be played
					System.out.println("Front Line does not have a Magic Creature card. You cannot play any Magic Support cards");
				}
				//Prevent other cases running
				break;
			//Item Support, then:
			case "Item Support":
				//Set boolean playedItemSupport to false
				boolean playedItemSupport = false;
				//For each Creature Card me in frontline:
				for(CreatureCard me: frontline) {
					//If the card type of me is equal to 'Melee Creature', then
					if( me.getCardType() == "Melee Creature") {
						//Run the selected card's effect method
						((SupportCard) hand.get(choice)).effect();
						//Add selected card to the wasteland array
						wasteland.add(hand.get(choice));
						//Remove the selected card from the hand
						hand.remove(choice);
						//Break loop
						break;
					}
				}
				//If playedItemSupport is equal to false, then:
				if(playedItemSupport == false) {
					//Output that their frontline doesn't have magic creatures and thus magic support cards can't be played
					System.out.println("Front Line does not have a Melee Creature card. You cannot play any Item Support cards");
				}
				//Prevent other cases running
				break;
			//Else, then:
			default:
				//Output 'Invalid card type'
				System.out.println("Invalid card type");
			}
		}
	}
	//Getters and Setters
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getDefencePoints() {
		return defencePoints;
	}
	public void setDefencePoints(int defencePoints) {
		this.defencePoints = defencePoints;
	}
	public ArrayList<Card> getDeck() {
		return deck;
	}
	public ArrayList<Card> getWasteland() {
		return wasteland;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public CreatureCard[] getFrontline() {
		return frontline;
	}
	
	/*public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	public void setWasteland(ArrayList<Card> wasteland) {
		this.wasteland = wasteland;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public void setFrontline(Card[] frontline) {
		this.frontline = frontline;
	}
	*/

}
