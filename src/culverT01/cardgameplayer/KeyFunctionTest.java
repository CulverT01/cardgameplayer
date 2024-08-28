package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KeyFunctionTest {
	KeyFunction keyFunction;
	Player player1;
	CreatureCard creature1;
	CreatureCard creature2;
	CreatureCard creature3;
	SupportCardAtkIncMel support1;
	SupportCardAtkIncMag support2;
	ArrayList<Card> deck;
	ArrayList<Card> wasteland;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		deck = new ArrayList<Card>();
		wasteland = new ArrayList<Card>();
		keyFunction = new KeyFunction();
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		creature2 = new CreatureCard("Ace Hunter", "Melee Creature", 700, 1400, "Ace");
		creature3 = new CreatureCard("Fairy Queen", "Magic Creature", 1000, 2500, "Legend");
		support1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null, 
				"Increase the attack of one Melee Creature on your Frontline by 300", 300);
		support2 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null,
				"Increase the attack of one Magic Creature on your Frontline by 300", 300);
		deck.add(creature1);
		deck.add(creature2);
		deck.add(support2);
		wasteland.add(support1);
		wasteland.add(creature3);
		player1 = new Player("PlayerName", 4000, wasteland, null, deck);
	}

	@Test
	void test_shuffleDeck_method_shuffles_the_deck() {
		//Act
		keyFunction.shuffleDeck(player1);
		//Assert
		assertEquals(3, player1.getDeck().size());
	}

	@Test
	void test_checkWasteland_method_checks_the_wasteland_and_returns_true_if_finds_correct_cardType() {
		//Act
		boolean checkWasteland = keyFunction.checkWasteland(player1, "Magic Creature");
		//Assert
		assertEquals(true, checkWasteland);
	}
	
	@Test
	void test_checkWasteland_method_checks_the_wasteland_and_returns_false_if_finds_incorrect_cardType() {
		//Act
		boolean checkWasteland = keyFunction.checkWasteland(player1, "Melee Creature");
		//Assert
		assertEquals(false, checkWasteland);
	}
	
	@Test
	void test_checkDeck_method_checks_the_wasteland_and_returns_true_if_finds_correct_cardType() {
		//Act
		boolean checkDeck = keyFunction.checkDeck(player1, "Magic Creature");
		//Assert
		assertEquals(true, checkDeck);
	}
	
	@Test
	void test_checkDeck_method_checks_the_wasteland_and_returns_false_if_finds_incorrect_cardType() {
		//Act
		boolean checkDeck = keyFunction.checkDeck(player1, "Item Support");
		//Assert
		assertEquals(false, checkDeck);
	}
}
