package org.novabot.api.methods;

import java.awt.Point;

import org.novabot.Client;
import org.novabot.input.MouseHandler;

/**
 * Basic mouse class
 * @version 0.1
 * @author Tanner, Motheen
 */
public class Mouse {

	private final Client client;
	private MouseHandler mouseHandler;
	
	public Mouse(final Client client) {
		this.client = client;
		mouseHandler = client.getMouseHandler();
	}
	
	/**
	 * Clicks the mouse at specific x and y coordinates.
	 * @param x The x coordinate 
	 * @param y The y coordinate
	 * @param left <tt>true</tt> for left-click or <tt>false</tt> for right-click.
	 */
	public static void click(final int x, final int y, final boolean left){
		getMouseHandler().clickAt(x, y, left);
	}
	
	/**
	 * Clicks the mouse at specific x and y coordinates.
	 * @param x The x coordinate 
	 * @param y The y coordinate
	 */
	public static void click(final int x, final int y){
		click(x, y, true);
	}
	
	
	/**
	 * Clicks the mouse at a specific point.
	 * @param p The point 
	 * @param left <tt>true</tt> for left-click or <tt>false</tt> for right-click.
	 */
	public static void click(final Point p, final boolean left){
		click(p.x, p.y, left);
	}
	
	/**
	 * Clicks the mouse at a specific point.
	 * @param p The point 
	 */
	public static void click(final Point p){
		click(p.x, p.y, true);
	}
	
	/**
	 * Clicks the mouse.
	 * @param left <tt>true</tt> for left-click or <tt>false</tt> for right-click.
	 */
	public static void click(final boolean left){
		click(getBotX(), getBotY(), left);
	}

	/**
	 * Clicks the mouse.
	 */
	public static void click(){
		click(true);
	}
	
	/**
	 * Moves the mouse to a specific point
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public static void move(final int x, final int y) {
		getMouseHandler().moveTo(x, y);
	}
	
	/**
	 * Moves the mouse to a specific point
	 * @param p The point
	 */
	public static void move(final Point p){
		move(p.x, p.y);
	}
	
	/**
	 * Grabs the bot mouse y position
	 * @return int
	 */
	public static int getBotY() {
		return getMouseHandler().botY;
	}

	/**
	 * Grabs the bot mouse x position
	 * @return int
	 */
	public static int getBotX() {
		return getMouseHandler().botX;
	}
	
	/**
	 * Grabs the bot mouse location
	 * @return Point
	 */
	public static Point getLocation(){
		return new Point(getBotX(), getBotY());
	}
	
	public Client getClient() {
		return client;
	}
	
	public static MouseHandler getMouseHandler() {
		return mouseHandler;
	}
	
}
