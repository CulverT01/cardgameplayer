package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardRecMeTest {
	SupportCardRecMe support1;
	Player player1;
	CreatureCard creature1;
	ArrayList<Card> wasteland;
	ArrayList<Card> deck;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardRecMe("Reincarnation", "Item Support", "Return a Melee Creature from the Wasteland to the bottom of the Deck");
		creature1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		wasteland = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		wasteland.add(creature1);
		player1 = new Player("PlayerName", 4000, wasteland, null, deck);
	}

	@Test
	void test() {
		//Act
		support1.effect(player1);
		//Assert
		assertEquals(1, player1.getDeck().size());
	}

}
