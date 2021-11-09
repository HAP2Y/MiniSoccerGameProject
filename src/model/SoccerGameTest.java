package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;

/**
 * The Class SoccerGameTest.
 */
public class SoccerGameTest {
	
	/** soccerGame of type SoccerGame initialized to new SoccerGame. */
	SoccerGame soccerGame = new SoccerGame();
	
	/**
	 * gettimeremaining test
	 */
	@Test
	public void getTimeRemainingTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		soccerGame2.setTimeRemaining(30);
		
		assertEquals(60, soccerGame1.getTimeRemaining());
		assertEquals(30, soccerGame2.getTimeRemaining());
	}
	
	/**
	 * Settimeremaining test.
	 */
	@Test
	public void setTimeRemainingTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		soccerGame1.setTimeRemaining(30);
		
		assertEquals(30, soccerGame1.getTimeRemaining());
	}
	
	/**
	 * Setgoalcount test.
	 */
	@Test
	public void setGoalCountTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		soccerGame1.setGoal(3);
		
		assertEquals(3, soccerGame1.getGoal());
	}
	
	/**
	 * Getgoalcount test.
	 */
	@Test
	public void getGoalCountTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		soccerGame2.setGoal(5);
		
		assertEquals(0, soccerGame1.getGoal());
		assertEquals(5, soccerGame2.getGoal());
	}
	
	/**
	 * Checks if is paused test.
	 */
	@Test
	public void isPausedTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		
		soccerGame2.setPaused(true);
		
		assertEquals(false, soccerGame1.isPaused());
		assertEquals(true, soccerGame2.isPaused());
	}
	
	/**
	 * Checks if is over test.
	 */
	@Test
	public void isOverTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		
		soccerGame2.setOver(true);
		
		assertEquals(false, soccerGame1.isOver());
		assertEquals(true, soccerGame2.isOver());
	}
	
	/**
	 * Automate goal keeper test.
	 */
	@Test
	public void automateGoalKeeperTest() {
		SoccerGame soccerGame = new SoccerGame();
		GamePlayer goalkeeper = soccerGame.getGamePlayers().get("Goalkeeper");
		goalkeeper.setInitialPosition();
		
		Point initial = goalkeeper.getPlayerPosition();
		Point ballOnKeeperSide = new Point(100, 100); // On keeper's side
		SoccerBall.getSoccerBall().setPosition(ballOnKeeperSide);
		soccerGame.automateGoalkeeper();
		boolean statUpdated = goalkeeper.getPlayerStatistics() > 0 ? true : false;
		
		Point ballNotOnKeeperSide = new Point(100, 300); // Outside of the keeper's side
		SoccerBall.getSoccerBall().setPosition(ballNotOnKeeperSide);
		soccerGame.automateGoalkeeper();
		boolean keeperMoved = initial.x != goalkeeper.getPlayerPosition().x ? true : false;
		
		assertTrue(statUpdated);
		assertTrue(keeperMoved);
	}

	/**
	 * Checks if is scored test.
	 */
	@Test
	public void isScoredTest() {
		SoccerGame soccerGame = new SoccerGame();
		
		Point ballInGate = new Point(300, 30);
		SoccerBall.getSoccerBall().setPosition(ballInGate);
		
		assertEquals(true, soccerGame.isScored());
	}
	
	/**
	 * Getactiveplayer test.
	 */
	@Test
	public void getActivePlayerTest() {
		SoccerGame soccerGame = new SoccerGame();
		
		assertEquals("Striker", soccerGame.getActivePlayer().getPlayerName());
	}
	
	/**
	 * Startgame test.
	 */
	@Test
	public void startGameTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		
		assertEquals(false, soccerGame1.isPaused());
		assertEquals(false, soccerGame1.isOver());
	}
}
