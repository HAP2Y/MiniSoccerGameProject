package view;


import static org.junit.Assert.assertEquals;
import model.SoccerGame;
import java.awt.*;

import org.junit.jupiter.api.Test;

/**
 * The Class GameTest.
 */
public class GameTest {
	
	/**
	 * Game panel test.
	 */
	@Test
	public void gamePanelTest() {
		GamePanel gamePanel = new GamePanel();
		
		assertEquals(new Font("UI", Font.BOLD, 15), gamePanel.uiFont);
	}
	
	/**
	 * Gets the game test.
	 *
	 * @return the game test
	 */
	@Test
	public void getGameTest() {
		GamePanel gamePanel = new GamePanel();
		SoccerGame game = new SoccerGame();
		
		assertEquals(game.getGoal(), gamePanel.getGame().getGoal());
	}
}
