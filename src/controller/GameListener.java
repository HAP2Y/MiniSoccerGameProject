package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Game listener interface for receiving game keyboard events.
 * The class that is interested in processing a game
 * event implements this KeyListener interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addGameListener<code> method. When
 * the game event occurs, that object's appropriate
 * method is invoked.
 *
 * @see GameEvent
 */
public class GameListener implements KeyListener {
	
	/** gamePanel of type GamePanel 
	*/
	private final GamePanel gamePanel;

	/**
	 * Instantiates a new game listener.
	 *
	 * @param panel of type GamePanel
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * Key typed.
	 *
	 * @param e of type KeyEvent
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
	 * KeyPressed method to instantiate what the arrow keys and space key does when pressed.  
	 *
	 * @param e of type KeyEvent
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}

	/**
	 * Key released.
	 *
	 * @param e of type KeyEvent
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
