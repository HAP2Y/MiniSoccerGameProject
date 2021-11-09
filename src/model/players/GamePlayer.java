package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * The Class GamePlayer.
 */
public abstract class GamePlayer implements Comparable<GamePlayer> {
	
	/** 
	 * The player name of type String. 
	 */
	protected final String playerName;
	
	/** 
	 * The player color of type Color. 
	 */
	protected final Color playerColor;
	
	/**
	 *  The player position of type Point. 
	 */
	protected Point playerPosition;
	
	/**
	 * The player statistics of type PlayerStatistics. 
	 */
	protected final PlayerStatistics playerStatistics;

	/**
	 * Instantiates a new game player.
	 *
	 * @param name of type String
	 * @param color of type Color
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	/**
	 * Checks if is player has ball.
	 *
	 * @return true, if is player has ball
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	/**
	 * Grabs ball.
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Move left.
	 */
	public abstract void moveLeft();

	/**
	 * Move right.
	 */
	public abstract void moveRight();

	/**
	 * Move up.
	 */
	public abstract void moveUp();

	/**
	 * Move down.
	 */
	public abstract void moveDown();

	/**
	 * Shoot ball.
	 */
	public abstract void shootBall();


	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Gets the player color.
	 *
	 * @return the player color
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

	/**
	 * Gets the player position.
	 *
	 * @return the player position
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * Sets the initial position.
	 */
	public abstract void setInitialPosition();

	/**
	 * Sets the player position.
	 *
	 * @param newPosition the new player position
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	/**
	 * Gets the player statistics.
	 *
	 * @return the player statistics
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	/**
	 * Sets the player statistics.
	 *
	 * @param newStatistics the new player statistics
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	/**
	 * Compare to.
	 *
	 * @param otherPlayer the other player
	 * @return the int
	 */
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public abstract String toString();
}
