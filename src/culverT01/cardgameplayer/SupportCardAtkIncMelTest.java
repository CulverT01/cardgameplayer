
package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardAtkIncMelTest {
	SupportCardAtkIncMel support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null, "Increase the attack of one Melee Creature on your Frontline by 300", 300);
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		player1 = new Player("PlayerName", 4000, null, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
	}

	@Test
	void test_that_creature1s_attack_increases_by_300_to_800() {
		//Act
		boolean testEffect = support1.effect(player1);
		//Assert
		assertEquals(true, testEffect);
	}

}
