package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardSerIsTest {
	SupportCardSerIs support1;
	SupportCardSerMe support2;
	Player player1;
	ArrayList<Card> hand;
	ArrayList<Card> deck;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		support1 = new SupportCardSerIs("Forging", "Item Support", "Ace", "Search 1 Item Support Card from your Deck and add it to your Hand");
		support2 = new SupportCardSerMe("Conscription", "Item Support", "Legend", "Search 1 Melee Creature from your Deck and add it to your Hand");		
		deck.add(support2);
		player1 = new Player("PlayerName", 4000, null, hand, deck);
	}

	@Test
	void test_effect_method_adds_item_support_card_to_hand_from_deck() {
		//Act
		boolean testEffect = support1.effect(player1);
		//Assert
		assertEquals(true, testEffect);
	}

	@Test
	void test_that_effect_fails_as_there_is_no_item_support_card_in_players_deck() {
		//Arrange
		deck.remove(0);
		//Act
		boolean testEffect = support1.effect(player1);
		//Assert
		assertEquals(false, testEffect);
	}

}
