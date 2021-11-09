package model.players;

import java.awt.Color;

/**
 * A factory for creating Player objects.
 */
public class PlayerFactory {
	
	private static PlayerFactory playerFactory;
			
	/** The striker color of type Color. */
	private Color strikerColor = Color.BLUE;
	
	/** The goal keeper color of type Color. */
	private Color goalKeeperColor = Color.YELLOW;

	/**
	 * Instantiates a new player factory.
	 */
	public PlayerFactory() {
						
	}
	
	public static PlayerFactory getInstance() {
		if(playerFactory == null) {
			playerFactory = new PlayerFactory();
		}
		return playerFactory;
	}
		
	/**
	 * Gets the player requested by type.
	 *
	 * @param type of type String
	 * @return the player
	 */
	public GamePlayer getPlayer(String type) {
		if (type.equals("Striker"))
			return new Striker("Striker", strikerColor);
		else
			return new Goalkeeper("Goalkeeper", goalKeeperColor);	
	}
}

