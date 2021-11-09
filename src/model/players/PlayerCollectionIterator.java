package model.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * The Class PlayerCollectionIterator.
 */
public class PlayerCollectionIterator implements Iterator<GamePlayer>{
    
	/** The gameplayer list of type List<GamePlayer>. */
	private List<GamePlayer> gameplayerList;
    
    /** The i of type integer. */
    private int i = 0;

    /**
     * Instantiates a new player collection iterator.
     *
     * @param collection of type Collection<GamePlayer>
     */
    public PlayerCollectionIterator(Collection<GamePlayer> collection) {
    	this.gameplayerList =  new ArrayList<GamePlayer>(collection);
    }
    
	/**
	 * Checks if the list has a next value or it ends right now..
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean hasNext() {
		boolean result = i < gameplayerList.size();
		return result;
	}

	/**
	 * Returns the next Object in the list.
	 *
	 * @return the game player
	 */
	@Override
	public GamePlayer next() {
		return gameplayerList.get(i++);
	}

}
