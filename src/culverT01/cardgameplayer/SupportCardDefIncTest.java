package culverT01.cardgameplayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportCardDefIncTest {
	SupportCardDefInc support1;
	Player player1;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		support1 = new SupportCardDefInc("Wooden Stakes", "Item Support", "Increase your Defence Points by 500", 500);
		player1 = new Player("PlayerName", 4000, null, null, null);
	}

	@Test
	void test() {
		//Act
		support1.effect(player1);
		//Assert
		assertEquals(4500, player1.getDefencePoints());
	}

}
