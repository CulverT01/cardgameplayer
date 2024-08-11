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


	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		wasteland = new ArrayList<Card>();
		support1 = new SupportCardResMe("Passionate Prayer", "Item Support", "Play 1 Melee Creature from your Wasteland to your Frontline");
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		creature2 = new CreatureCard("Ace Hunter", "Melee Creature", 700, 1400, "Ace");
		wasteland.add(creature2);
		player1 = new Player("PlayerName", 4000, wasteland, null, null);
		CreatureCard [] frontline = {creature1, null, null, null};
		player1.setFrontline(frontline);
		
	}

	@Test
	void test() {
		//Act
		support1.effect(player1);
		//Assert
		assertEquals(0, player1.getWasteland().size());
	}

}
