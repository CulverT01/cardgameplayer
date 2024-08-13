package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardHthIncMagTest {
	SupportCardHthIncMag support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;
	KeyFunction keyFunction;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardHthIncMag("Healing Spell Lv 1", "Magic Support", "Increase the health of one Magic Creature on your Frontline by 300", 300);
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		player1 = new Player("PlayerName", 4000, null, null, null);
		CreatureCard[] frontline = { creature1, null, null, null };
		player1.setFrontline(frontline);
		keyFunction = new KeyFunction();
	}

	@Test
	void test() {
		//Act
		support1.effect(player1, keyFunction);
		//Assert
		assertEquals(1100, creature1.getHealth());
	}

}
