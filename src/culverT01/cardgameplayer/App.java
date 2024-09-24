package culverT01.cardgameplayer;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		//Set wasteland1 to be new ArrayList that stores the Card object
		ArrayList<Card> wasteland1 = new ArrayList<Card>();
		//Set wasteland2 to be new ArrayList that stores the Card object
		ArrayList<Card> wasteland2 = new ArrayList<Card>();
		
		//Set hand1 to be new ArrayList that stores the Card object
		ArrayList<Card> hand1 = new ArrayList<Card>();
		//Set hand2 to be new ArrayList that stores the Card object
		ArrayList<Card> hand2 = new ArrayList<Card>();
		
		//Construct new Player object player1 using values: "", 4000, wasteland1,
		//hand1, returned value from DeckLoad's loadDeck1 method
		Player player1 = new Player("", 4000, wasteland1, hand1, DeckLoad.loadDeck1());
		//Construct new Player object player1 using values: "", 4000, wasteland2,
		//hand2, returned value from DeckLoad's loadDeck2 method
		Player player2 = new Player("", 4000, wasteland2, hand2, DeckLoad.loadDeck2());

		//Set frontline as an array that stores 4 CreatureCard objects
		CreatureCard [] frontline1 = {null, null, null, null};
		//Set frontline2 as an array that stores 4 CreatureCard objects
		CreatureCard [] frontline2 = {null, null, null, null};
		//Set player1's frontline attribute to equal frontline1
		player1.setFrontline(frontline1);
		//Set player2's frontline attribute to equal frontline2
		player2.setFrontline(frontline2);
		
		//Create new Scanner object to take input
		Scanner input = new Scanner(System.in);
		//Ask User to input name of Player 1
		System.out.println("What is Player 1's name?");
		//Set String name1 to be next inputed string
		String name1 = input.nextLine();
		//Set player1's playerName attribute to equal name1
		player1.setPlayerName(name1);
		
		//Create new Scanner object to take input
		Scanner input2 = new Scanner(System.in);
		//Ask User to input name of Player 2
		System.out.println("What is Player 2's name?");
		//Set String name2 to be next inputed string
		String name2 = input2.nextLine();
		//Set player2's playerName attribute to equal name2
		player2.setPlayerName(name2);
		
		//Set playerList to be new ArrayList that stores the Player object
		ArrayList<Player> playerList = new ArrayList<Player>();
		//Add player1 to playerList
		playerList.add(player1);
		//Add player2 to playerList
		playerList.add(player2);
		
		//Call App class's playGame method, passing playerList as an argument
		App.playGame(playerList);
	}
	//plan Stage method
	public static void planStage(Player player) {
		//Set boolean finishedPlan to equal false
		boolean finishedPlan = false;
		//Loop while finishedPlan is equal to false
		while (finishedPlan == false) {
			//Call the KeyFunction class's displayHand method, passing player as an argument
			KeyFunction.displayHand(player);
			//Call the KeyFunction class's displayField method, passing player as an argument
			KeyFunction.displayField(player);
			//Call player's playCardFromHand method, passing player as an argument
			player.playCardFromHand(player);
			//If player's hand is empty, then
			if (player.getHand().isEmpty()) {
				//Set finishedPlan to true
				finishedPlan = true;
			}
			//Create new Scanner object to take input
			Scanner input = new Scanner(System.in);
			//Ask user if there are any more cards they want to play from their hand
			System.out.println("Are there any more cards you want to play from your hand? yes or no?");
			//Set String choice to equal the user's input on the next line
			String choice = input.nextLine();
			//Change choice to lower case
			choice.toLowerCase();
			//If choice is equal to 'no', then:
			if (choice.equals("no")) {
				//Set finishedPlan to true
				finishedPlan = true;
			}
		}
	}
	//battle Stage method
	public static void battleStage(Player player1, Player player2) {
		//Set temp to be new ArrayList that stores the CreatureCard object
		ArrayList<CreatureCard> temp = new ArrayList<CreatureCard>();
		//Set boolean finishedAttack to equal false
		boolean finishedAttack = false;
		//Loop for integer i, which equal to 0, is less than the length of player1's
		//frontline; increasing i by 1 for each successful loop
		for(int i = 0; i < player1.getFrontline().length; i++) {
			// If item at position i in player's frontline array is equal to null, then:
			if(player1.getFrontline()[i] == null) {
				// Output whitespace so NullPointerExeceptions don't occur
				System.out.print("");
			}
			//Else, then:
			else {
				//Add item at position i in player's frontline array to temp
				temp.add(player1.getFrontline()[i]);
				// Output the name, health, attack, skill and position in player1's frontline array of the Creature
				// stored at position i.
				System.out.println(player1.getFrontline()[i].getName() + "|\n" + player1.getFrontline()[i].getHealth()
						+ "|\n" + player1.getFrontline()[i].getAttack() + "|\n" + player1.getFrontline()[i].getSkill()
						+ "|\n position: " + i + "|");
				System.out.println("-------------------");
			}
		}
		//Loop while finishedAttack is equal to false
		while(finishedAttack == false) {
			//Create new Scanner object to take input
			Scanner input = new Scanner(System.in);
			//Ask user which Creature that wish to attack with
			System.out.println("Enter the position of the creature you wish to attack with");
			//Set integer choice to equal the user's input on the next line
			int choice = input.nextInt();
			//If temp contains the creature stored at position choice of player1's frontline, then:
			if (temp.contains(player1.getFrontline()[choice])) {
				//Call said creature's creatureAttack method, passing player2 as an argument
				player1.getFrontline()[choice].creatureAttack(player2);
				//Remove said creature from temp
				temp.remove(temp.indexOf(player1.getFrontline()[choice]));
				//Create new Scanner object to take input
				Scanner input2 = new Scanner(System.in);
				//Ask user if they are finished attacking with their Creatures
				System.out.println("Are you finished attacking with your Creatures? yes or no?");
				//Set String choice2 to equal the user's input on the next line
				String choice2 = input2.nextLine();
				//Change choice2 to lower case
				choice2.toLowerCase();
				//If choice2 is equal to 'yes', then:
				if (choice2.equals("yes")) {
					//Set finishedAttack to equal true
					finishedAttack = true;
				}
				//Else if temp is empty, then:
				else if (temp.isEmpty()) {
					//Set finishedAttack to equal true
					finishedAttack = true;
				}
			}
			//Else, then:
			else {
				//Output Creature has already attacked
				System.out.println("Creature has already attacked");
			}		
		}
	}
	//opening Hand Draw method
	public static void openingHandDraw (ArrayList<Player> playerList) {
		//Set boolean mulligan to equal false
		boolean mulligan = false;
		//Set boolean player1Mulligan to equal false
		boolean player1Mulligan = false;
		//Set boolean player2Mulligan to equal false
		boolean player2Mulligan = false;
		//Loop while mulligan equals false
		//Call the class KeyFunction's shuffleDeck method, passing the player object
		// in position 0 of playerList Array as an argument
		KeyFunction.shuffleDeck(playerList.get(0));
		//Call the class KeyFunction's shuffleDeck method, passing the player object
		// in position 0 of playerList Array as an argument
		KeyFunction.shuffleDeck(playerList.get(1));
		while(mulligan == false) {
			// Call the class KeyFunction's drawFourCards method, passing the player object
			// in position 0 of playerList Array as an argument
			KeyFunction.drawFourCards(playerList.get(0));
			// Call the class KeyFunction's drawFourCards method, passing the player object
			// in position 1 of playerList Array as an argument
			KeyFunction.drawFourCards(playerList.get(1));
			/* Set player1Mulligan to equal to result of the class KeyFunction's checkHand
			 * method (passing the player object in position 0 of playerList Array and
			 * 'Magic Creature' as arguments) OR the class KeyFunction's checkHand method
			 * (passing the player object in position 0 of playerList Array and 'Melee
			 * Creature' as arguments)
			 */
			player1Mulligan = KeyFunction.checkHand(playerList.get(0), "Magic Creature") == true
					|| KeyFunction.checkHand(playerList.get(0), "Melee Creature") == true;
			/* Set player2Mulligan to equal to result of the class KeyFunction's checkHand
			 * method (passing the player object in position 1 of playerList Array and
			 * 'Magic Creature' as arguments) OR the class KeyFunction's checkHand method
			 * (passing the player object in position 1 of playerList Array and 'Melee
			 * Creature' as arguments)
			 */
			player2Mulligan = KeyFunction.checkHand(playerList.get(1), "Magic Creature") == true
					|| KeyFunction.checkHand(playerList.get(1), "Melee Creature") == true;
			//If player1Mulligan is equal to false AND  player2Mulligan is equal to false, then:
			if (player1Mulligan == false && player2Mulligan == false) {
				//Output that the player object in position 0 of playerList Array has drawn a Mulligan
				System.out.println("Player " + playerList.get(0).getPlayerName() + ": Mulligan");
				//Output that the player object in position 1 of playerList Array has drawn a Mulligan
				System.out.println("Player " + playerList.get(1).getPlayerName() + ": Mulligan");
				// Call the class KeyFunction's shuffleFourCards method passing the player
				// object in position 0 of playerList Array as an argument
				KeyFunction.shuffleFourCards(playerList.get(0));
				// Call the class KeyFunction's shuffleFourCards method passing the player
				// object in position 1 of playerList Array as an argument
				KeyFunction.shuffleFourCards(playerList.get(1));
			}
			//Else if player1Mulligan is equal to true AND player2Mulligan is equal to false, then:
			else if (player1Mulligan == true && player2Mulligan == false) {
				//Loop while player2Mulligan is equal to false
				while (player2Mulligan == false) {
					//Output that the player object in position 1 of playerList Array has drawn a Mulligan
					System.out.println("Player " + playerList.get(1).getPlayerName() + ": Mulligan");
					//Call the player object in position 0 of playerList Array's draw method
					playerList.get(0).draw();
					// Call the class KeyFunction's shuffleFourCards method passing the player
					// object in position 1 of playerList Array as an argument
					KeyFunction.shuffleFourCards(playerList.get(1));
					// Call the class KeyFunction's drawFourCards method, passing the player object
					// in position 1 of playerList Array as an argument
					KeyFunction.drawFourCards(playerList.get(1));
					/* Set player2Mulligan to equal to result of the class KeyFunction's checkHand
					 * method (passing the player object in position 1 of playerList Array and
					 * 'Magic Creature' as arguments) OR the class KeyFunction's checkHand method
					 * (passing the player object in position 1 of playerList Array and 'Melee
					 * Creature' as arguments)
					 */
					player2Mulligan = KeyFunction.checkHand(playerList.get(1), "Magic Creature") == true
							|| KeyFunction.checkHand(playerList.get(1), "Melee Creature") == true;
					}
				//Set mulligan to equal true
				mulligan = true;
				}
			//Else if player1Mulligan is equal to false AND player2Mulligan is equal to true, then:
			else if (player1Mulligan == false && player2Mulligan == true) {
				//Loop while player2Mulligan is equal to false
				while (player1Mulligan == false) {
					//Output that the player object in position 0 of playerList Array has drawn a Mulligan
					System.out.println("Player " + playerList.get(0).getPlayerName() + ": Mulligan");
					//Call the player object in position 1 of playerList Array's draw method
					playerList.get(1).draw();
					// Call the class KeyFunction's shuffleFourCards method passing the player
					// object in position 0 of playerList Array as an argument
					KeyFunction.shuffleFourCards(playerList.get(0));
					// Call the class KeyFunction's drawFourCards method, passing the player object
					// in position 0 of playerList Array as an argument
					KeyFunction.drawFourCards(playerList.get(0));
					/* Set player1Mulligan to equal to result of the class KeyFunction's checkHand
					 * method (passing the player object in position 0 of playerList Array and
					 * 'Magic Creature' as arguments) OR the class KeyFunction's checkHand method
					 * (passing the player object in position 0 of playerList Array and 'Melee
					 * Creature' as arguments)
					 */
					player1Mulligan = KeyFunction.checkHand(playerList.get(0), "Magic Creature") == true
							|| KeyFunction.checkHand(playerList.get(0), "Melee Creature") == true;
					}
				//Set mulligan to equal true
				mulligan = true;
				}
			//Else, then:
			else {
				//Set mulligan to equal true
				mulligan = true;
			}
		}
	}
	//playGame method
	public static void playGame (ArrayList<Player> playerList) {
		//Set boolean gameOver to equal false
		boolean gameOver = false;
		//Set integer turnPlayer to equal a random integer between 0 and 1
		int turnPlayer = (int) (Math.random() * 2);
		//Set integer opponent to equal 1 - turnPlayer
		int opponent = 1 - turnPlayer;
		//Set integer turnCount to equal 1 
		int turnCount = 1;
		//Call the class App's openingHandDraw method, passing playerList as an argument
		App.openingHandDraw(playerList);
		//Output which player will go first
		System.out.println("Player " + playerList.get(turnPlayer).getPlayerName() + " will go first.");
		//Loop while gameOver equals false:
		while (gameOver == false) {
			//Output the turn number as well as whose turn it is
			System.out.println("Turn: " + turnCount + ". \n" + playerList.get(turnPlayer).getPlayerName() + "'s turn.");
			//Output 'Draw Stage'
			System.out.println("Draw Stage");
			//Call the player object in position turnPlayer in playerList array's draw method
			playerList.get(turnPlayer).draw();
			//If the player object in position turnPlayer in playerList array's defence points equal 0, then:
			if(playerList.get(turnPlayer).getDefencePoints() == 0) {
				//Output the player object in position opponent in playerList array wins at turn number
				System.out.println("Player " + playerList.get(opponent).getPlayerName() + " wins at turn " + turnCount + ".");
				//Set gameOver to equal true
				gameOver = true;
			}
			//Call the class KeyFunction's displayHand method, passing the player object in position turnPlayer in playerList array as an argument
			KeyFunction.displayHand(playerList.get(turnPlayer));
			//Output 'Plan Stage'
			System.out.println("Plan Stage");
			//Call the class KeyFunction's displayField method, passing the player object in position turnPlayer in playerList array as an argument
			KeyFunction.displayField(playerList.get(turnPlayer));
			//Call the class App's planStage method, passing the player object in position turnPlayer in playerList array as an argument
			App.planStage(playerList.get(turnPlayer));
			//If turnCount is more than 1, then:
			if(turnCount > 1) {
				//Output 'Battle Stage'
				System.out.println("Battle Stage");
				/* Call the class App's battleStage method, passing the player object in
				 * position turnPlayer in playerList array and the player object in position
				 * opponent in playerList array as arguments */
				App.battleStage(playerList.get(turnPlayer), playerList.get(opponent));
			}
			//Output 'End Stage'
			System.out.println("End Stage");
			//If the player object in position opponent in playerList array's defence points equals 0, then:
			if(playerList.get(opponent).getDefencePoints() == 0) {
				//Output the player object in position turnPlayer in playerList array wins at turn number
				System.out.println("Player " + playerList.get(turnPlayer).getPlayerName() + " wins at turn " + turnCount + ".");
				//Set gameOver to equal true
				gameOver = true;
			}
			//Else, then:
			else {
				//If turnPlayer == 0, then:
				if(turnPlayer == 0) {
					//Set turnPlayer to equal 1
					turnPlayer = 1;
					//Set opponent to equal 0
					opponent = 0;
					//Increase turnCount by 1
					turnCount++;
				}
				//Else if, turnPlayer == 1, then:
				else if(turnPlayer == 1) {
					//Set turnPlayer to equal 0
					turnPlayer = 0;
					//Set opponent to equal 1
					opponent = 1;
					//Increase turnCount by 1
					turnCount++;
				}
			}
		}
	}
}
