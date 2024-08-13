
package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardAtkIncMelTest {
	SupportCardAtkIncMel support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;
	KeyFunction keyFunction;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", "Increase the attack of one Melee Creature on your Frontline by 300", 300);
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		player1 = new Player("PlayerName", 4000, null, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
		 keyFunction = new KeyFunction();
	}

	@Test
	void test_that_creature1s_attack_increases_by_300_to_800() {
		//Act
		support1.effect(player1, keyFunction);
		//Assert
		assertEquals(800, creature1.getAttack());
	}

}
