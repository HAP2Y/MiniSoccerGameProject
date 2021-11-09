package model.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

/**
 * The Class TestPlayerCollection.
 */
public class TestPlayerCollection {
	
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
	 * Game player collection test.
	 */
	@Test
	public void GamePlayerCollectionTest() {
		final GamePlayer striker = new Striker("Striker", Color.BLUE);
		final GamePlayer striker2 = new Striker("Striker", Color.BLUE);
		playerCollection.add(striker);
		playerCollection.add(goalkeeper);
		
		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(striker);
		players.add(goalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(playerCollection.getGamePlayers(), players);
	}
	
	/**
	 * Gets the game player test.
	 */
	@Test
	public void getGamePlayerTest() {
		final GamePlayer striker = new Striker("Striker", Color.BLUE);
		final GamePlayer striker2 = new Striker("Striker", Color.BLUE);
		PlayerCollection PlayerCollectionTester = new PlayerCollection();

		GamePlayer gotStriker = new Striker("Striker", Color.BLUE);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);

		assertEquals(PlayerCollectionTester.get("Striker"), gotStriker);
		assertEquals(PlayerCollectionTester.get("Goalkeeper"), gotGoalkeeper);

		assertEquals(PlayerCollectionTester.get(""), null);
		assertEquals(PlayerCollectionTester.get(""), null);
		
		boolean result = ("Goalkeeper caught 0 balls" == PlayerCollectionTester.get(1).getPlayerName());
		
		assertEquals(false, result);
	}
	
	/**
	 * Gets the adds the all test.
	 */
	@Test
	public void getAddAllTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();
		PlayerCollection PlayerCollectionTester2 = new PlayerCollection();
		
		GamePlayer gotStriker = new Striker("Striker", Color.BLUE);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
		
		PlayerCollectionTester2.addAll(PlayerCollectionTester.getGamePlayers());
		
		assertEquals(PlayerCollectionTester.collection, PlayerCollectionTester2.collection);
	}
	

	/**
	 * Gets the collection of game players test.
	 */
	@Test
	public void getCollectionOfGamePlayersTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();
		GamePlayer gotStriker = new Striker("Striker", Color.BLUE);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
		

		Collection<GamePlayer> players = new ArrayList<GamePlayer>();
		players.add(gotStriker);
		players.add(gotGoalkeeper);

		//there is a Collection of players. Check they are equal
		assertEquals(PlayerCollectionTester.getGamePlayers(), players);
	}
	
	/**
	 * Game player iterator test.
	 */
	@Test
	public void gamePlayerIteratorTest() {
		PlayerCollection PlayerCollectionTester = new PlayerCollection();
		PlayerCollection PlayerCollectionTester2 = new PlayerCollection();
		PlayerCollection PlayerCollectionTester3 = new PlayerCollection();
		PlayerCollection PlayerCollectionTester4 = new PlayerCollection();
		
		GamePlayer gotStriker = new Striker("Striker", Color.BLUE);
		GamePlayer gotGoalkeeper = new Goalkeeper("Goalkeeper", Color.YELLOW);
		
		PlayerCollectionTester3.add(gotStriker);
		PlayerCollectionTester4.add(gotStriker);
		
		PlayerCollectionTester.add(gotStriker);
		PlayerCollectionTester.add(gotGoalkeeper);
		
		Collection<GamePlayer> players1 = new ArrayList<GamePlayer>();

		players1.add(gotStriker);
		players1.add(gotGoalkeeper);
		
		assertEquals(gotStriker, PlayerCollectionTester.get(0));
		assertEquals(2, PlayerCollectionTester.size());
		assertEquals(null, PlayerCollectionTester2.iterator());
		assertEquals(PlayerCollectionTester3.get(0).playerName, PlayerCollectionTester4.get(0).playerName);
	}
	
	/**
	 * Player collection iterator test.
	 */
	@Test
	public void PlayerCollectionIteratorTest() {
		
		collection.add(new Striker("Striker", Color.BLUE));
		collection.add(new Goalkeeper("Goalkeeper", Color.YELLOW));
		
		PlayerCollectionIterator pCollectionIterator = new PlayerCollectionIterator(collection);
		
		boolean isRightPlayer = false;
		
		for (GamePlayer playerName : collection) {
			if (pCollectionIterator.hasNext() && playerName.getPlayerName().equals(pCollectionIterator.next().getPlayerName())) {
				isRightPlayer = true;
			}
		}
		assertEquals(true, isRightPlayer);
	}
	
	/**
	 * Sort test.
	 */
	@Test
    public void sortTest() {
        collection = playerCollection.getGamePlayers();
        playerCollection.sort();

        Collection<GamePlayer> sortcollection = new ArrayList<GamePlayer>();
        assertEquals(sortcollection, collection);
    }
}