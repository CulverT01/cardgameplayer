package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCard2Test {
	SupportCard2 support2;
	Player player1;
	CreatureCard creature1;
	CreatureCard [] frontline;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
				support2 = new SupportCard2("Strength Spell Lv 1", "Magic Support", "Increase the attack of one Magic Creature on your Frontline by 300", 300);
				creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
				player1 = new Player("PlayerName", 4000, null, null, null);
				CreatureCard [] frontline = {creature1, null, null, null};
				player1.setFrontline(frontline);
			}

			@Test
			void test_that_creature1s_attack_increases_by_300_to_600() {
				//Act
				support2.effect(player1);
				//Assert
				assertEquals(600, creature1.getAttack());
			}


}
