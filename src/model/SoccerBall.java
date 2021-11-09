package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Class SoccerBall defines the position and speed and state of soccer ball.
 */
public class SoccerBall {

	/** Initializing soccerBall with SoccerBall object 
	 *
	 */
	private static final SoccerBall soccerBall = new SoccerBall();

	/** position of type Point. */
	private Point position;

	/** velocity of type double. */
	private double velocity;

	/** color of type Color. */
	private final Color color;

	/**
	 * Instantiates a new soccer ball.
	 * Constructor
	 */
	public SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/**
	 * Gets the soccer ball.
	 *
	 * @return the soccer ball
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Move ball.
	 *
	 * @param initialDistance of type integer -> initial distance
	 * @param initialVelocity of type double -> initial velocity
	 * @param acceleration of type acceleration
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Move ball Y.
	 *
	 * @param distance of type integer
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/**
	 * Reset soccer ball's velocity and position.
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * Checks if ball is on goalkeeper's side
	 *
	 * @return true, if successful
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * Check if ball is in gate.
	 *
	 * @return true, if successful
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

    /**
     * Gets the velocity.
     *
     * @return the velocity
     */
    public double getVelocity() {
        return velocity;
    }
	
	/**
	 * Sets the velocity.
	 *
	 * @param velocity of type double
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position of type Point
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
}
