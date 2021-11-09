package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MenuBarlistener interface for receiving menu bar events.
 * This class is interested in processing a menu bar
 * event and implements ActionListener interface 
 * When the menu bar event occurs, that object's appropriate method is invoked.
 *
 * @see MenubarEvent
 */
public class MenubarListener implements ActionListener {

	/** gamePanel of type GamePanel */
	private final GamePanel gamePanel;

	/**
	 * Instantiates a new menu bar listener.
	 *
	 * @param panel of type GamePanel
	 */
	public MenubarListener(GamePanel panel) {
		gamePanel = panel;
	}


	/**
	 * This method performs action based on action initiated.
	 * New -> Sets up panel for new game with resetting everything	
	 * Exit -> Quits the panel
	 * Pause -> Pauses the game. Check if game is over or not
	 * Resume -> Resumes the paused game
	 * 
	 * @param e of type ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		switch (e.getActionCommand()) {
			case "NEW":
				gamePanel.setupSoccerGame();
				break;
			case "EXIT":
				System.exit(0);
				break;
			case "PAUSE":
				if (!soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(true);
				} else if (soccerGame.isPaused()) {
					System.out.println("game is already on pause!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			case "RESUME":
				if (soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(false);
				} else if (!soccerGame.isPaused()) {
					System.out.println("game is already running!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			default:
				throw new RuntimeException("Invalid action command " + e.getActionCommand());
		}
	}
}
