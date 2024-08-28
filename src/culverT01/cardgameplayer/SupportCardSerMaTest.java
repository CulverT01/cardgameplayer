package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardSerMaTest {
	SupportCardSerMa support1;
	CreatureCard creature1;
	Player player1;
	ArrayList<Card> hand;
	ArrayList<Card> deck;
	KeyFunction keyFunction;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		support1 = new SupportCardSerMa("Graduation", "Magic Support", "Legend", "Search 1 Magic Creature from your Deck and add it to your Hand");
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		deck.add(creature1);
		player1 = new Player("PlayerName", 4000, null, hand, deck);
		keyFunction = new KeyFunction();
	}

	@Test
	void test_effect_method_to_add_magic_creature_to_hand_from_deck() {
		//Act
		boolean testEffect = support1.effect(player1, keyFunction);
		//Assert
		assertEquals(true, testEffect);
	}

	@Test
	void test_that_effect_fails_as_there_is_no_magic_creature_in_players_deck() {
		//Arrange
		deck.remove(0);
		//Act
		boolean testEffect = support1.effect(player1, keyFunction);
		//Assert
		assertEquals(false, testEffect);
	}

}
