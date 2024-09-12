package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardHthIncMelTest {
	SupportCardHthIncMel support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardHthIncMel("Wooden Shield", "Item Support", null, "Increase the health of one Melee Creature on your Frontline by 300", 300);
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		player1 = new Player("PlayerName", 4000, null, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
	}

	@Test
	void test_creature1s_health_increases_from_500_to_800() {
		//Act
		boolean testEffect = support1.effect(player1);
		//Assert
		assertEquals(true, testEffect);
	}

}
