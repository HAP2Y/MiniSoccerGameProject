package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * The Class SoccerGame.
 */
public class SoccerGame {

	/** The time remaining of type integer */
	private Integer timeRemaining;

	/** The goal of of type integer */
	private Integer goal;

	/** isPaused of type boolean */
	private Boolean isPaused;

	/** isOver of type boolean */
	private Boolean isOver;

	/** gamePlayers of type PlayerCollection 
	 * stores game players in player collection list
	 */
	private final PlayerCollection gamePlayers;
	
	/** timerTask of type TimerTask */
	private TimerTask timerTask;

	/**
	 * This is a default constructor
	 * 
	 * The timer is set for 60 seconds and the number of goals initialized as zero
	 * A soccer ball is set to the initial position, and new game players are added to a collection.
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("Striker"));
		gamePlayers.add(playerFactory.getPlayer("Goalkeeper"));
		startGame();
	}

	/**
	 *  Initializing a new game.
	 */
	public void startGame() {
		Timer timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Returns the remaining time left.
	 *
	 * @return remaining time left
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets a new remaining time .
	 *
	 * @param timeRemaining of type integer
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Return the number of goals achieved.
	 *
	 * @return the number of goals in total
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * Sets a new number of goals.
	 *
	 * @param newGoal of type integer
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * Shows whether the game is paused.
	 *
	 * @return true if the game is paused, otherwise false
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * Sets the game as paused or not paused.
	 *
	 * @param paused of type boolean
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}

	/**
	 * Shows whether the game is over.
	 *
	 * @return true if the game is over, otherwise false
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * Sets the game is over or still continuing.
	 *
	 * @param over of type boolean
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * Gets the game players.
	 *
	 * @return the game players of type PlayerCollection
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * This instructs how a goalkeeper is supposed to move
	 * If a soccer ball is in the area of the goalkeeper, then it will grab the ball and shoot back
	 * Then, the number of caught balls increment by one
	 * Otherwise, the goalkeeper keeps moving randomly.
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}
	
	/**
	 * This shows whether it is goal or not.
	 *
	 * @return true if it is a successful goal, otherwise false
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * This returns a player, striker.
	 *
	 * @return the player, striker of type GamePlayer
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
