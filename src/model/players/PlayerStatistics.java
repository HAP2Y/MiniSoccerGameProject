package model.players;

/**
 * The Class PlayerStatistics.
 */
public class PlayerStatistics {

	/** The score. */
	private int score = 0;
	
	/**
	 * Gets number of goals scored if player.
	 * OR Gets number of goals saved if goalkeeper.
	 *
	 * @return the statistics
	 */
	public Integer getStatistics() {
		return score;
	}

	/**
	 * Sets number of goals scored if player.
	 * OR Sets number of goals saved if goalkeeper.
	 *
	 * @param newScore the new statistics
	 */
	public void setStatistics(Integer newScore) {
		score = newScore;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return Integer.toString(score);
	}

}
