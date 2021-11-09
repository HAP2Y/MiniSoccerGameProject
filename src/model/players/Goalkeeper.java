package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

/**
 * The Class Goalkeeper.
 * Extends Class Game Player with name and color that represents the player.
 * 
 * @param name of type String
 * @param color of type Color
 */
public class Goalkeeper extends GamePlayer {

	/** The movement step of type integer */
	private int movementStep;

	/**
	 * Instantiates a new goalkeeper.
	 *
	 * @param name of type String
	 * @param color of type Color
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	/**
	 * Move left by 10 units if x-Position - 10 is greater than 0
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Move right by 10 units if x-Position + 50 + 10 is less than 600
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Move up by 5 units if y-Position - 5 is greater than 0
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Move down by 5 units if y-position + 50 is less than 300
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Shoot ball.
	 * Shoots the ball away from the goal with 5 velocity and 0.05 acceleration.
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}

	/**
	 * Move randomly in front of the Gate to Catch the ball.
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	/**
	 * Sets the initial position to in front of the Gate.
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
