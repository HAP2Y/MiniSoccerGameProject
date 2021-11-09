/**
 * 
 */
package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * A factory for creating TestPlayer objects.
 */
class TestPlayerFactory {

	/**
	 * Gets the player factory test.
	 */
	@Test
	void getPlayerFactoryTest() {
		PlayerFactory playerFactory = new PlayerFactory();
			
		GamePlayer gotStriker = new Striker("Striker", Color.BLUE);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
		
		assertEquals(playerFactory.getPlayer("Striker").getClass(), gotStriker.getClass());
		assertEquals(playerFactory.getPlayer("Striker").getPlayerName(), gotStriker.getPlayerName());
		assertEquals(playerFactory.getPlayer("Striker").getPlayerColor(), gotStriker.getPlayerColor());
		assertEquals(playerFactory.getPlayer("Goalkeeper").getClass(), gotGoalkeeper.getClass());
		assertEquals(playerFactory.getPlayer("Goalkeeper").getPlayerName(), gotGoalkeeper.getPlayerName());
		assertEquals(playerFactory.getPlayer("Goalkeeper").getPlayerColor(), gotGoalkeeper.getPlayerColor());
	}
	
	
}
