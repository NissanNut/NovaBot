package org.novabot.api.methods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.novabot.storage.FieldStorage;

/**
 * Basic Game methods.
 * @version 0.1
 * @authors Tanner, Motheen
 */
public class Game {
	
	public static final Rectangle VIEWPORT = new Rectangle(4, 54, 511, 333);
	public static final Rectangle MINIMAP = new Rectangle(551, 59, 152, 151);
	
	/**
	 * Grabs the game image.
	 * @return Game's BufferedImage.
	 */
	public static BufferedImage getImage() {
		return (BufferedImage) FieldStorage.getFieldVal("gameimage");
	}
	
	/**
	 * Gets the color at a specific game point.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return Color
	 */
	public static Color getColorAt(final int x, final int y) {
		return ColorUtil.getColorAt(getImage(), x, y);
	}
	
	/**
	 * Gets the color at a specific game point.
	 * @param p The point.
	 * @return Color
	 */
	public static Color getColorAt(final Point p) {
		return getColorAt(p.y, p.y);
	}
	
	/**
	 * Gets the dimensions of the game.
	 * @return Dimension
	 */
	public static Dimension getSize() {
		final BufferedImage i = getImage();
		return new Dimension(i.getWidth(), i.getHeight());
	}
	
	/**
	 * Checks if the game point is valid.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return <tt>true</tt> if the point is valid and <tt>false</tt> if it is not.
	 */
	public static boolean isPointValid(final int x, final int y){
		final Dimension d = getSize();
		if (x >= 0 && y >= 0 && x <= d.width && y <= d.height)
			return true;
		return false;
	}
	
	/**
	 * Checks if the game point is valid.
	 * @param p The point.
	 * @return <tt>true</tt> if the point is valid and <tt>false</tt> if it is not.
	 */
	public static boolean isPointValid(final Point p){
		return isPointValid(p.x, p.y);
	}
	
}
