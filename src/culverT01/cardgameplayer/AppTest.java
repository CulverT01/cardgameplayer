package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
	Player player1;
	Player player2;
	ArrayList<Card> wasteland;
	ArrayList<Card> hand;
	ArrayList<Card> deck;
	ArrayList<Card> wasteland2;
	ArrayList<Card> hand2;
	ArrayList<Card> deck2;
	CreatureCard creature1;
	CreatureCard creature2;
	CreatureCard creature3;
	CreatureCard creature4;
	SupportCardAtkIncMel support1;
	SupportCardAtkIncMag support2;
	SupportCardAtkIncMel support3;
	SupportCardAtkIncMag support4;
	ArrayList<Player> playerList;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		
		wasteland2 = new ArrayList<Card>();
		hand2 = new ArrayList<Card>();
		deck2 = new ArrayList<Card>();

		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		creature2 = new CreatureCard("Ace Hunter", "Melee Creature", 700, 1400, "Ace");
		creature3 = new CreatureCard("Fairy Queen", "Magic Creature", 1000, 2500, "Legend");
		creature4 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		support1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null,
				"Increase the attack of one Melee Creature on your Frontline by 300", 300);
		support2 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null,
				"Increase the attack of one Magic Creature on your Frontline by 300", 300);
		support3 = new SupportCardAtkIncMel("Steel Sword", "Item Support", null,
				"Increase the attack of one Melee Creature on your Frontline by 600", 600);
		support4 = new SupportCardAtkIncMag("Strength Spell Lv 2", "Magic Support", null,
				"Increase the attack of one Magic Creature on your Frontline by 600", 600);

		deck.add(creature1);
		deck.add(creature2);
		deck.add(creature3);
		deck.add(creature4);
		deck.add(support1);
		deck2.add(support2);
		deck2.add(support1);
		deck2.add(support3);
		deck2.add(support4);
		deck2.add(creature1);
		

		player1 = new Player("PlayerName", 4000, wasteland, hand, deck);
		player2 = new Player("PlayerName", 4000, wasteland2, hand2, deck2);
		CreatureCard [] frontline = {null, null, null, null};
		CreatureCard [] front2line = {null, null, null, null};
		player1.setFrontline(frontline);
		player1.setFrontline(front2line);
		
		playerList = new ArrayList<Player>();
		playerList.add(player1);
		playerList.add(player2);
	}

	@Test
	void test_planStage_method() {
		//Act
		hand.add(creature1);
		hand.add(creature2);
		hand.add(creature3);
		hand.add(support1);
		player1.setHand(hand);
		App.planStage(player1);
		//Assert
		assertEquals(0, player1.getHand().size());
	}
	
	@Test
	void test_battleStage_method_with_a_single_monster_on_the_frontline() {
		//Act
		CreatureCard [] frontline1 = {creature4, null, null, null};
		CreatureCard [] frontline2 = {creature1, null, null, null};
		player1.setFrontline(frontline1);
		player2.setFrontline(frontline2);
		App.battleStage(player1, player2);
		//Assert
		assertEquals(300, creature1.getHealth());
	}

	@Test
	void test_battleStage_method_with_null_as_the_first_item_in_the_frontline_array() {
		//Act
		CreatureCard [] frontline1 = {null, creature4, null, null};
		CreatureCard [] frontline2 = {creature1, null, null, null};
		player1.setFrontline(frontline1);
		player2.setFrontline(frontline2);
		App.battleStage(player1, player2);
		//Assert
		assertEquals(300, creature1.getHealth());
	}
	
	@Test
	void test_openingHandDraw_method_where_player2_does_not_have_a_creature_card_in_their_opening_hand() {
		//Act
		App.openingHandDraw(playerList);
		//Assert
		assertEquals(5, player1.getHand().size());
	}
	@Test
	void test_openingHandDraw_method_where_player1_does_not_have_a_creature_card_in_their_opening_hand() {
		//Act
		deck.clear();
		deck.add(support1);
		deck.add(support2);
		deck.add(support3);
		deck.add(support4);
		deck.add(creature1);
		deck2.set(0, creature4);
		
		App.openingHandDraw(playerList);
		//Assert
		assertEquals(5, player2.getHand().size());
	}
}
