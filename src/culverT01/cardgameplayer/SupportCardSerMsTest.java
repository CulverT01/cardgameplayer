package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardSerMsTest {
	SupportCardSerMs support1;
	SupportCardSerMa support2;
	Player player1;
	ArrayList<Card> hand;
	ArrayList<Card> deck;
	KeyFunction keyFunction;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		support1 = new SupportCardSerMs("Memory Spell Lv 1", "Magic Support", "Search 1 Magic Support Card from your Deck and add it to your Hand");
		support2 = new SupportCardSerMa("Graduation", "Magic Support", "Search 1 Magic Creature from your Deck and add it to your Hand");
		deck.add(support2);
		player1 = new Player("PlayerName", 4000, null, hand, deck);
		keyFunction = new KeyFunction();
	}

	@Test
	void test_effect_method_adds_magic_support_card_to_hand_from_deck() {
		//Act
		support1.effect(player1, keyFunction);
		//Assert
		assertEquals(1, player1.getHand().size());
	}

}
