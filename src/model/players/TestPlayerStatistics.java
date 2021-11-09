/**
 * 
 */
package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * The Class TestPlayerStatistics.
 */
class TestPlayerStatistics {

	/**
	 * Test get statistic.
	 */
	@Test
	void testGetStatistic() {
		PlayerStatistics playerStatistics = new PlayerStatistics();
		
		Random random = new Random();
		int max = 60;
		int i = random.nextInt(max+1); // 0 to 60
		
		playerStatistics.setStatistics(i);
		assertEquals(i, playerStatistics.getStatistics());
	}
	
	/**
	 * Test to string.
	 */
	@Test
	void testToString() {
		PlayerStatistics testGetStat = new PlayerStatistics();
		
		Random random = new Random();
		int max = 30;
		Integer i = random.nextInt(max+1);
		testGetStat.setStatistics(i);
		
		assertEquals(i.toString(), testGetStat.toString());
	}


}
