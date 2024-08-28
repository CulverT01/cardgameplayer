package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardResMeTest {
	SupportCardResMe support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard creature2;
	ArrayList<Card> wasteland;
	KeyFunction keyFunction;


	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		support1 = new SupportCardResMe("Passionate Prayer", "Item Support", "Legend", "Play 1 Melee Creature from your Wasteland to your Frontline");
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		creature2 = new CreatureCard("Ace Hunter", "Melee Creature", 700, 1400, "Ace");
		wasteland.add(creature2);
		player1 = new Player("PlayerName", 4000, wasteland, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
		keyFunction = new KeyFunction();
		
	}

	@Test
	void test_effect_method_plays_melee_creature_from_wasteland_to_frontline() {
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
	
	@Test
	void test_that_effect_fails_as_player_has_a_full_frontline() {
		//Arrange
		CreatureCard [] frontline1 = {creature1, creature1, creature1, creature1};
		player1.setFrontline(frontline1);
		//Act
		boolean testEffect = support1.effect(player1, keyFunction);
		//Assert
		assertEquals(false, testEffect);
	}

}
