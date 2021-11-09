package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * The Class Striker.
 * Extends Class Game Player with name and color that represents the player.
 * 
 * @param name of type String
 * @param color of type Color
 */
public class Striker extends GamePlayer {
	
	/**
	 * Instantiates a new striker.
	 *
	 * @param name of type String
	 * @param color of type Color
	 */
	public Striker(String name, Color color) {
		super(name, color);
	}

	/**
	 * Move left by 5 units if x-Position - 10 is greater than 0
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
	}

	/**
	 * Move right by 5 units if x-Position + 50 is less than 600
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
	}

	/**
	 * Move up by 5 units if y-Position - 5 is greater than 200
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Move down by 5 units if y-position + 50 is less than 500
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Shoot ball.
	 * Shoots the ball towards the goal with 5 velocity and 0.05 acceleration.
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
	}

	/**
	 * Sets the initial position to bottom right corner of the field.
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
