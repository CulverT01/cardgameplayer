package culverT01.cardgameplayer;

import java.util.ArrayList;

public class KeyFunction {

	//Constructor
	public KeyFunction() {
	}
	//Behaviour
	public void shuffleDeck(Player player) {
		//Create an ArrayList that stores the Card Object called temp
		ArrayList<Card> temp = new ArrayList<Card>();
		//Loop for integer j is less than size of the player's deck array, increasing j by each loop
		for (int j = 0; j < player.getDeck().size(); j++) {
			//Add the item at position j to the temp array
			temp.add(player.getDeck().get(j));
		}
		//Remove all items from the player's deck array
		player.getDeck().clear();
		//While the size of the temp array is not 0:
		while (temp.size() != 0) {
			//Set integer randomNum to equal a random number between 0 and the size of the temp array
			int randomNum = (int)(Math.random() * temp.size());
			//Add to the player's deck the item at position randomNum in the temp array
			player.getDeck().add(temp.get(randomNum));
			//Remove item at position randomNum  in the temp array
			temp.remove(randomNum);	
		}
	}

}
