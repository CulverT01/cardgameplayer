package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardResMaTest {
	SupportCardResMa support1;
	Player player1;
	CreatureCard creature1;
	CreatureCard creature2;
	ArrayList<Card> wasteland;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		support1 = new SupportCardResMa("Necromancy", "Magic Support", "Play 1 Magic Creature from your Wasteland to your Frontline");
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		creature2 = new CreatureCard("Fairy Queen", "Magic Creature", 1000, 2500, "Legend");
		wasteland.add(creature2);
		player1 = new Player("PlayerName", 4000, wasteland, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
	}

	@Test
	void test_effect_method_plays_magic_creature_from_wasteland_to_frontline() {
		//Act
		support1.effect(player1);
		//Assert
		assertEquals(0, player1.getWasteland().size());
	}

}
