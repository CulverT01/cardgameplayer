package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardHthIncMagTest {
	SupportCardHthIncMag support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardHthIncMag("Wooden Shield", "Item Support", "Increase the health of one Melee Creature on your Frontline by 300", 300);
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		player1 = new Player("PlayerName", 4000, null, null, null);
		CreatureCard[] frontline = { creature1, null, null, null };
		player1.setFrontline(frontline);
	}

	@Test
	void test() {
		//Act
		support1.effect(player1);
		//Assert
		assertEquals(1100, creature1.getHealth());
	}

}
