package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

/**
 * SoccerBallTest
 */
class SoccerBallTest {

	/**
	 * Gets the velocity test.
	 */
	@Test
	void getVelocityTest() {
		SoccerBall sb1 =  new SoccerBall();
		SoccerBall sb2 =  new SoccerBall();
		sb2.setVelocity(10.00);
		
		assertEquals(0.0, sb1.getVelocity());
		assertEquals(10.00, sb2.getVelocity());
	}

	/**
	 * Gets the position test.
	 */
	@Test
	void getPositionTest() {
		SoccerBall sb3 =  new SoccerBall();
		SoccerBall sb4 =  new SoccerBall();
		Point p = new Point(2,3);
		Point defaultPoint = new Point(480,500);
		sb3.setPosition(p);
		
		assertEquals(p, sb3.getPosition());
		assertEquals(defaultPoint, sb4.getPosition());
	}
	
	/**
	 * Gets the color test.
	 */
	@Test
	void getColorTest() {
		SoccerBall sb5 = new SoccerBall();
		Color WHITE = Color.white;
		
		assertEquals(WHITE, sb5.getColor());
	}
}
