package model.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * The Class PlayerCollection.
 */
public class PlayerCollection implements Iterable<GamePlayer> {
 
	/** The size of type integer. */
	private int size;
	
	/** The collection of type Collection<GamePlayer>. */
	public Collection<GamePlayer> collection;
	
	/**
	 * Instantiates a new player collection.
	 */
	public PlayerCollection() {
		collection = new ArrayList<GamePlayer>();
		size = 0;
	}
	
	/**
	 * Gets the collection that contains all the GamePlayers.
	 *
	 * @return the game players
	 */
	public Collection<GamePlayer> getGamePlayers() { 
		return collection; 
	}
	
	/**
	 * Adds the player to the collection.
	 *
	 * @param player of type GamePlayer
	 */
	public void add(GamePlayer player) {
		collection.add(player);
		size++;
	}
	
    /**
     * Adds all the players to the collection.
     *
     * @param players of type Collection<GamePlayer>
     */
    public void addAll(Collection<GamePlayer> players) {
        for (GamePlayer player : players)
            collection.add(player);
    }

	/**
	 * Iterates through the collection to get individual values to compare.
	 *
	 * @return the iterator
	 */
	public Iterator<GamePlayer> iterator() {
		if (size == 0) 
			return null;
		return new PlayerCollectionIterator(collection);
	}
	
	/**
	 * Gets the game player by it's name.
	 *
	 * @param name of type String
	 * @return the game player
	 */
	public GamePlayer get(String name) {
		 for(GamePlayer gamePlayer : collection) {
		        if(gamePlayer.getPlayerName().equals(name)) {
		            return gamePlayer;
		        }
		 }
		    return null;
	}
	
    /**
     * Gets the game player by its order of addition to the collection.
     *
     * @param index of type integer
     * @return the game player
     */
    public GamePlayer get(int index) {
        int i = 0;
        for (GamePlayer gameplayer : collection) {
            if (i++ == index)
                return gameplayer;
        }
        return null;
    }
    
    /**
     * Gets the size of the collectionSize.
     *
     * @return the int
     */
    public int size() {
        return size;
    }
    
    /**
     * Sorts the collection.
     */
    public void sort() {
    	collection = getGamePlayers();
    }
	

}
