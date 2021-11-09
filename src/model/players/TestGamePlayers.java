package model.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

/**
 * The Class TestGamePlayers.
 */
public class TestGamePlayers {
	
	/** The factory. */
	final PlayerFactory factory = new PlayerFactory();
	
	/** The striker. */
	final GamePlayer striker = new Striker("Striker", Color.BLUE);
	
	/** The striker 2. */
	final GamePlayer striker2 = new Striker("Striker", Color.BLUE);
	
	/** The goalkeeper. */
	final GamePlayer goalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
	
	/** The goalkeeper 2. */
	final GamePlayer goalkeeper2 = new Goalkeeper("Goalkeeper", Color.YELLOW);
	
	/** The collection. */
	Collection<GamePlayer> collection = new ArrayList<GamePlayer>();
	
	/** The collection 2. */
	Collection<GamePlayer> collection2 = new ArrayList<GamePlayer>();
	
	/** The player collection. */
	PlayerCollection playerCollection = new PlayerCollection();

	/**
	 * Game player test.
	 */
	@Test
	public void GamePlayerTest() {
		playerCollection.add(striker);
		playerCollection.add(goalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(playerCollection.get("Striker"), striker);
		assertEquals(playerCollection.get("Goalkeeper"), goalkeeper);

		assertEquals(playerCollection.get(""), null);
		assertEquals(playerCollection.get(""), null);
	}
	
	/**
	 * Striker test.
	 */
	@Test
	public void StrikerTest() {		
		assertEquals("striker", striker.getPlayerName().toLowerCase());
		assertEquals(Color.BLUE, striker.getPlayerColor());
		assertEquals(true, striker.isPlayerHasBall());
		assertEquals(0, striker.compareTo(goalkeeper));
		striker.shootBall();
		assertEquals(new Point(500,450), striker.getPlayerPosition());
		striker.setPlayerStatistics(3);
		assertEquals(3, striker.getPlayerStatistics());
	}
	
	/**
	 * Striker move test.
	 */
	@Test
	public void strikerMoveTest() {
		Point leftResult = new Point(95, 100);
		Point downResult = new Point(100,105);
		Point defaultResult = new Point(100,100);
		
		// Check for if not
		striker.setPlayerPosition(new Point(10,10));
		striker.moveLeft();
		assertEquals(new Point(10,10), striker.getPlayerPosition());
		striker.setPlayerPosition(new Point(590,590));
		striker.moveRight();
		assertEquals(new Point(590,590), striker.getPlayerPosition());
		
		// Check for if condition true
		striker.setPlayerPosition(new Point(100,100));
		striker.moveLeft();
		assertEquals(leftResult, striker.getPlayerPosition());
		striker.moveRight();
		assertEquals(defaultResult, striker.getPlayerPosition());
		striker.moveDown();
		assertEquals(downResult, striker.getPlayerPosition());
		
		// Check for if not
		striker.moveUp();
		assertEquals(downResult, striker.getPlayerPosition());
		striker.setPlayerPosition(new Point(450,450));
		striker.moveDown();
		assertEquals(new Point(450,450), striker.getPlayerPosition());
		
		// Check for if condition true
		striker.setPlayerPosition(new Point(250,250));
		striker.moveUp();
		assertEquals(new Point(250,245), striker.getPlayerPosition());
	}
	
	/**
	 * Striker to string test.
	 */
	@Test
	public void StrikerToStringTest() {
		String result = striker.toString();
		
		assertEquals(result, striker2.toString());
	}
	
	/**
	 * Goal keeper test.
	 */
	@Test
	public void GoalKeeperTest() {
		assertEquals("goalkeeper", goalkeeper.getPlayerName().toLowerCase());
		assertEquals(Color.YELLOW, goalkeeper.getPlayerColor());
		goalkeeper.setInitialPosition();
		
		goalkeeper.setPlayerStatistics(2);
		assertEquals(2, goalkeeper.getPlayerStatistics());
		
		assertEquals("goalkeeper caught 2 balls" , "goalkeeper caught " + goalkeeper.getPlayerStatistics().toString() + " balls");
		
	}
	
	/**
	 * Gool keeper move test.
	 */
	@Test
	public void GoolKeeperMoveTest() {
		Point leftResult = new Point(95, 100);
		Point downResult = new Point(100,105);
		Point defaultResult = new Point(100,100);
		
		// Check for if not
		goalkeeper.setPlayerPosition(new Point(10,10));
		goalkeeper.moveLeft();
		assertEquals(new Point(10,10), goalkeeper.getPlayerPosition());
		goalkeeper.setPlayerPosition(new Point(590,590));
		goalkeeper.moveRight();
		assertEquals(new Point(590,590), goalkeeper.getPlayerPosition());
		
		// Check for if condition true
		goalkeeper.setPlayerPosition(new Point(100,100));
		goalkeeper.moveLeft();
		assertEquals(new Point(90,100), goalkeeper.getPlayerPosition());
		goalkeeper.moveRight();
		assertEquals(defaultResult, goalkeeper.getPlayerPosition());
		goalkeeper.moveDown();
		assertEquals(downResult, goalkeeper.getPlayerPosition());
		
		// Check for if not
		goalkeeper.moveUp();
		assertEquals(defaultResult, goalkeeper.getPlayerPosition());
		goalkeeper.setPlayerPosition(new Point(450,450));
		goalkeeper.moveDown();
		assertEquals(new Point(450,450), goalkeeper.getPlayerPosition());
		
		// Check for if condition true
		goalkeeper.setPlayerPosition(new Point(250,250));
		goalkeeper.moveUp();
		assertEquals(new Point(250,245), goalkeeper.getPlayerPosition());
	}
	
	/**
	 * Goal keeper to string test.
	 */
	@Test
	public void GoalKeeperToStringTest() {
		String result = goalkeeper.toString();
		
		assertEquals(result, goalkeeper2.toString());
	}
}