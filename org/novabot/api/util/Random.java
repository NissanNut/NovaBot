package org.novabot.api.util;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Basic randomization class.
 * @version 0.1
 * @author Tanner
 */
public class Random {

	public static java.util.Random r = new java.util.Random();
	
	/**
	 * Generates a random number between to intigers
	 * @param min The min number
	 * @param max The max number
	 * @return int
	 */
	public static int random(final int min, final int max){
		if (min == max)
			return min;
		
		if (min > max)
			return r.nextInt(min + 1 - max) + max;
		
		return r.nextInt(max + 1 - min) + min;
	}
	
	/**
	 * Finds a random point within a rectangle
	 * @param r The rectangle
	 * @return Point within the rectangle
	 */
	public static Point pointInRect(Rectangle r){
		int x = random(r.x, r.x + r.width);
		int y = random(r.y, r.y + r.height);
		return new Point(x, y);
	}
}
