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
		support1 = new SupportCardDefInc("Wooden Stakes", "Item Support", null, "Increase your Defence Points by 500", 500);
		player1 = new Player("PlayerName", 4000, null, null, null);
	}

	@Test
	void test_players_defence_points_increase_from_4000_to_4500() {
		//Act
		boolean testEffect = support1.effect(player1);
		//Assert
		assertEquals(true, testEffect);
	}

}
