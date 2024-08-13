package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardRecMaTest {
	SupportCardRecMa support1;
	Player player1;
	CreatureCard creature1;
	ArrayList<Card> wasteland;
	ArrayList<Card> deck;
	KeyFunction keyFunction;


	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardRecMa("Regeneration", "Magic Support", "Return a Magic Creature from the Wasteland to the bottom of the Deck");
		creature1 = new CreatureCard("Will o Wisp", "Magic Creature", 800, 300, null);
		wasteland = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		wasteland.add(creature1);
		player1 = new Player("PlayerName", 4000, wasteland, null, deck);
		keyFunction = new KeyFunction();
	}

	@Test
	void test() {
		//Act
		support1.effect(player1, keyFunction);
		//Assert
		assertEquals(1, player1.getDeck().size());
	}

}
