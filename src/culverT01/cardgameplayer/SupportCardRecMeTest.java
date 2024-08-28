package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardRecMeTest {
	SupportCardRecMe support1;
	Player player1;
	CreatureCard creature1;
	ArrayList<Card> wasteland;
	ArrayList<Card> deck;
	KeyFunction keyFunction;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardRecMe("Reincarnation", "Item Support","Ace", "Return a Melee Creature from the Wasteland to the bottom of the Deck");
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		wasteland = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		wasteland.add(creature1);
		player1 = new Player("PlayerName", 4000, wasteland, null, deck);
		keyFunction = new KeyFunction();
	}

	@Test
	void test_that_creature1_is_added_to_the_bottom_of_player1s_deck() {
		//Act
		boolean testEffect = support1.effect(player1, keyFunction);
		//Assert
		assertEquals(true, testEffect);
	}
	
	@Test
	void test_that_effect_fails_as_there_is_no_melee_creatures_in_players_wasteland() {
		//Arrange
		wasteland.remove(0);
		//Act
		boolean testEffect = support1.effect(player1, keyFunction);
		//Assert
		assertEquals(false, testEffect);
	}

}
