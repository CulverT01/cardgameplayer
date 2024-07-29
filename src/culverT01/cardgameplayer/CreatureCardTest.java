package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatureCardTest {
	Player player1;
	CreatureCard creature1;
	CreatureCard creature2;
	ArrayList<Card> wasteland;
	

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		player1 = new Player("PlayerName", 4000, wasteland, null, null);
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		creature2 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		CreatureCard [] frontline = {null, null, null, null};
		player1.setFrontline(frontline);
		
	}

	@Test
	void test_creatureAttack_method_subtracts_from_opponents_defencepoints_when_their_frontline_is_empty() {
		//Act
		creature1.creatureAttack(player1);
		//Assert
		assertEquals(3500,player1.getDefencePoints());
	}
	
	@Test
	void test_creatureAttack_method_subtracts_from_opponents_creatures_health_and_its_health_is_more_than_attacking_creature() {
		//Arrange
		CreatureCard [] frontline2 = new CreatureCard [4];
		frontline2[0] = creature2;
		player1.setFrontline(frontline2);
		//Act
		creature1.creatureAttack(player1);
		//Assert
		assertEquals(300, creature2.getHealth());
	}
	
	@Test
	void test_creatureAttack_method_subtracts_from_opponents_creatures_health_and_its_health_is_less_than_or_equal_to_attacking_creature() {
		//Arrange
		CreatureCard [] frontline3 = new CreatureCard [4];
		frontline3[1] = creature2;
		player1.setFrontline(frontline3);
		creature2.setHealth(300);
		//Act
		creature1.creatureAttack(player1);
		//Assert
		assertEquals(1, player1.getWasteland().size());
	}

}
