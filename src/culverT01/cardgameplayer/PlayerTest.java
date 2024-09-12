package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Player player1;
	ArrayList<Card> wasteland;
	ArrayList<Card> hand;
	ArrayList<Card> deck;
	CreatureCard creature1;
	CreatureCard creature2;
	CreatureCard creature3;
	CreatureCard creature4;
	SupportCardAtkIncMel support1;
	SupportCardAtkIncMag support2;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		creature2 = new CreatureCard("Ace Hunter", "Melee Creature", 700, 1400, "Ace");
		creature3 = new CreatureCard("Fairy Queen", "Magic Creature", 1000, 2500, "Legend");
		creature4 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		support1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null, "Increase the attack of one Melee Creature on your Frontline by 300", 300);
		support2 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null, "Increase the attack of one Magic Creature on your Frontline by 300", 300);
		
		hand.add(creature1);
		hand.add(creature2);
		hand.add(support2);
		hand.add(support1);
		deck.add(creature3);
		
		player1 = new Player("PlayerName", 4000, wasteland, hand, deck);
		CreatureCard [] frontline = {null, null, null, null};
		player1.setFrontline(frontline);	
	}

	@Test
	void test_that_player_draws_card_from_deck_using_draw_method() {
		//Act
		player1.draw();
		//Assert
		assertEquals(0, player1.getDeck().size());
	}
	
	@Test
	void test_that_player_loses_500_defencepoints_as_their_deck_is_empty() {
		//Arrange
		deck.remove(0);
		player1.setDeck(deck);
		//Act
		player1.draw();
		//Assert
		assertEquals(3500, player1.getDefencePoints());
	}
	
	@Test
	void test_that_player_can_play_creature_cards_from_hand() {
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(3, player1.getHand().size());
	}
	
	@Test
	void test_that_player_cannot_play_creature_cards_from_hand_due_to_a_full_frontline() {
		//Arrange
		CreatureCard [] frontline1 = {creature1, creature2, creature3, creature4};
		player1.setFrontline(frontline1);
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(4, player1.getHand().size());
	}
	
	@Test
	void test_that_player_can_play_magic_support_cards_from_hand() {
		//Arrange
		CreatureCard [] frontline2 = new CreatureCard [4];
		frontline2[0] = creature1;
		player1.setFrontline(frontline2);
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(1, player1.getWasteland().size());
	}
	
	@Test
	void test_that_player_can_play_melee_support_cards_from_hand() {
		//Arrange
		CreatureCard [] frontline3 = new CreatureCard [4];
		frontline3[0] = creature2;
		player1.setFrontline(frontline3);
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(1, player1.getWasteland().size());
	}
	
	@Test
	void test_that_player_cannot_play_magic_support_cards_from_hand_as_there_is_a_melee_creature_on_the_frontline() {
		//Arrange
		CreatureCard [] frontline4 = new CreatureCard [4];
		frontline4[0] = creature2;
		player1.setFrontline(frontline4);
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(4, player1.getHand().size());
	}
	
	@Test
	void test_that_player_cannot_play_melee_support_cards_from_hand_as_there_is_a_magic_creature_on_the_frontline() {
		//Arrange
		CreatureCard [] frontline5 = new CreatureCard [4];
		frontline5[0] = creature1;
		player1.setFrontline(frontline5);
		//Act
		player1.playCardFromHand(player1);
		//Assert
		assertEquals(4, player1.getHand().size());
	}
}
