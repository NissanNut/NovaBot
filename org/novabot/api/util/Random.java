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
	 * Generates a random number between to integers.
	 * @param min The min number.
	 * @param max The max number.
	 * @return a random int.
	 */
	public static int random(final int min, final int max){
		if (min == max)
			return min;
		else if (min > max)
			throw new IllegalArgumentException("Minimum is more than Maximum.");
		else
			return r.nextInt(max + 1 - min) + min;
	}
	
	/**
	 * Finds a random point within a rectangle.
	 * @param r The rectangle.
	 * @return a point within the rectangle.
	 */
	public static Point point(final Rectangle r){
		int x = random(r.x, r.x + r.width);
		int y = random(r.y, r.y + r.height);
		return new Point(x, y);
	}
	
	/**
	 * Generates a random boolean.
	 * @return a random boolean.
	 */
	public boolean nextBoolean(){
		return r.nextBoolean();
	}

	/**
	 * Generates random byte.
	 * @param random bytes.
	 */
	public void nextBytes(byte[] bytes){
		r.nextBytes(bytes);
	}

	/**
	 * Generates a random double.
	 * @return a random double.
	 */
	public double nextDouble(){
		return r.nextDouble();
	}

	/**
	 * Generates a random float.
	 * @return a random float.
	 */
	public float nextFloat(){
		return r.nextFloat();
	}

	/**
	 * Generates a random gaussian.
	 * @return a random gaussian.
	 */
	public double nextGaussian(){
		return r.nextGaussian();
	}

	/**
	 * Generates a random int.
	 * @return a random int.
	 */
	public int nextInt(){
		return r.nextInt();
	}
	
	/**
	 * Generates a random int between 0 and the specified value.
	 * @param i the maximum number.
	 * @return a random int.
	 */
	public int nextInt(final int i){
		return r.nextInt(i);
	}

}
