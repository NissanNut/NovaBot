package org.novabot.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import org.novabot.api.util.Random;

/**
 * Novabot basic color utilities.
 * @version 0.1
 * @author Tanner, Motheen
 */
public class ColorUtil {

	/**
	 * Grabs all of the colors within an image.
	 * @param image The BufferedImage.
	 * @return Color[][]
	 */
	public static Color[][] getColors(final BufferedImage image) {
		final int w = image.getWidth();
		final int h = image.getHeight();
		final Color[][] colors = new Color[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				colors[x][y] = getColorAt(image, x, y);
			}
		}
		return colors;
	}
	
	/**
	 * Gets color at a specific point.
	 * @param image The BufferedImage.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return Color
	 */
	public static Color getColorAt(final BufferedImage image, final int x,
			final int y) {
		if (x >= 0 && y >= 0 && x < image.getWidth() && y < image.getHeight()) {
			return new Color(image.getRGB(x, y));
		}
		return Color.BLACK;
	}
	
	/**
	 * Gets color at a specific point.
	 * @param image The BufferedImage.
	 * @param p The point.
	 * @return Color
	 */
	public static Color getColorAt(final BufferedImage image, final Point p) {
		if (p.x >= 0 && p.y >= 0 && p.x < image.getWidth() && p.y < image.getHeight()) {
			return new Color(image.getRGB(p.x, p.y));
		}
		return Color.BLACK;
	}
	
	/**
	 * Gets color at a specific point within the game.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return Color
	 */
	public static Color getColorAt(final int x, final int y) {
		final BufferedImage image = Game.getImage();
		if (x >= 0 && y >= 0 && x < image.getWidth() && y < image.getHeight()) {
			return new Color(image.getRGB(x, y));
		}
		return Color.BLACK;
	}
	
	/**
	 * Gets color at a specific point within the game.
	 * @param p The point.
	 * @return Color
	 */
	public static Color getColorAt(final Point p) {
		final BufferedImage image = Game.getImage();
		if (p.x >= 0 && p.y >= 0 && p.x < image.getWidth() && p.y < image.getHeight()) {
			return new Color(image.getRGB(p.x, p.y));
		}
		return Color.BLACK;
	}

	/**
	 * Lists the points with a specific color and tolerance within a rectangle.
	 * @param image The BufferedImage.
	 * @param bounds The bounds.
	 * @param color The Color.
	 * @param threshold The Tolerance.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final BufferedImage image, final Rectangle bounds, final Color color, final int threshold) {
		final LinkedList<Point> points = new LinkedList<Point>();
		final Color[][] colors = getColors(image);
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= threshold) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}
	
	/**
	 * Lists the points with a specific color and tolerance within a rectangle.
	 * @param image The BufferedImage.
	 * @param color The Color.
	 * @param threshold The Tolerance.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final BufferedImage image, final Color color, final int threshold) {
		final LinkedList<Point> points = new LinkedList<Point>();
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		final Color[][] colors = getColors(image);
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= threshold) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}

	/**
	 * Lists the points with a specific color and tolerance within a rectangle.
	 * @param bounds The bounds.
	 * @param color The Color.
	 * @param threshold The Tolerance.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final Rectangle bounds, final Color color, final int threshold) {
		final LinkedList<Point> points = new LinkedList<Point>();
		final Color[][] colors = getColors(Game.getImage());
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= threshold) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}
	
	/**
	 * Lists the points with a specific color and tolerance.
	 * @param color The Color.
	 * @param threshold The Tolerance.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final Color color, final int threshold) {
		final BufferedImage image = Game.getImage();
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		final LinkedList<Point> points = new LinkedList<Point>();
		final Color[][] colors = getColors(image);
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= threshold) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}
	
	/**
	 * Lists the points with a specific color.
	 * @param image The BufferedImage.
	 * @param color The Color.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final BufferedImage image, final Color color) {
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		final LinkedList<Point> points = new LinkedList<Point>();
		final Color[][] colors = getColors(image);
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= 1) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}
	
	/**
	 * Lists the points with a specific color.
	 * @param color The Color.
	 * @return LinkedList<Point>
	 */
	public static LinkedList<Point> getPointsWithColor(final Color color) {
		final BufferedImage image = Game.getImage();
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		final LinkedList<Point> points = new LinkedList<Point>();
		final Color[][] colors = getColors(image);
		for (int x = bounds.x; x < bounds.width + bounds.x; x++) {
			for (int y = bounds.y; y < bounds.height + bounds.y; y++) {
				if (getDistance(colors[x][y], color) <= 1) {
					points.add(new Point(x, y));
				}
			}
		}
		return points;
	}
	
	/**
	 * Grabs a point with a color.
	 * @param image The BufferedImage.
	 * @param bounds The bounds.
	 * @param color The Color.
	 * @param threshold The tolerance.
	 * @return The Point
	 */
	public static Point getPointWithColor(final BufferedImage image, final Rectangle bounds, final Color color, final int threshold){
		LinkedList<Point> l = getPointsWithColor(image, bounds, color, threshold);
		if (l.size() > 0)
			return l.get(Random.random(0, l.size()));
		return null;
	}
	
	/**
	 * Grabs a point with a color.
	 * @param image The BufferedImage.
	 * @param color The Color.
	 * @param threshold The tolerance.
	 * @return The Point
	 */
	public static Point getPointWithColor(final BufferedImage image, final Color color, final int threshold){
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		LinkedList<Point> l = getPointsWithColor(image, bounds, color, threshold);
		if (l.size() > 0)
			return l.get(Random.random(0, l.size()));
		return null;
	}
	
	/**
	 * Grabs a point with a color.
	 * @param image The BufferedImage.
	 * @param color The Color.
	 * @return The Point
	 */
	public static Point getPointWithColor(final BufferedImage image, final Color color){
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		LinkedList<Point> l = getPointsWithColor(image, bounds, color, 1);
		if (l.size() > 0)
			return l.get(Random.random(0, l.size()));
		return null;
	}
	
	/**
	 * Grabs a point with a color within the game.
	 * @param color The Color.
	 * @param threshold The tolerance.
	 * @return The Point
	 */
	public static Point getPointWithColor(final Color color, final int threshold){
		final BufferedImage image = Game.getImage();
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		LinkedList<Point> l = getPointsWithColor(image, bounds, color, threshold);
		if (l.size() > 0)
			return l.get(Random.random(0, l.size()));
		return null;
	}
	
	/**
	 * Grabs a point with a color within the game.
	 * @param color The Color.
	 * @return The Point
	 */
	public static Point getPointWithColor(final Color color){
		final BufferedImage image = Game.getImage();
		final Rectangle bounds = new Rectangle (image.getMinTileX(), image.getMinTileY(), image.getHeight(), image.getWidth());
		LinkedList<Point> l = getPointsWithColor(image, bounds, color, 1);
		if (l.size() > 0)
			return l.get(Random.random(0, l.size()));
		return null;
	}
	
	/**
	 * Gets the threshold distance between two colors.
	 * @param r1 Color 1, red.
	 * @param g1 Color 1, green.
	 * @param b1 Color 1, blue.
	 * @param r2 Color 2, red.
	 * @param g2 Color 2, green.
	 * @param b2 Color 2, blue.
	 * @return int threshold
	 */
	public static int getDistance(final int r1, final int g1, final int b1, final int r2, final int g2, final int b2) {
		int red = Math.abs(r2 - r1);
		int green = Math.abs(g2 - g1);
		int blue = Math.abs(b2 - b1);
		return (red + green + blue) / 3;
	}

	/**
	 * Gets the threshold distance between two colors.
	 * @param c1 Color 1.
	 * @param c2 Color 2.
	 * @return int threshold
	 */
	public static int getDistance(final Color c1, final Color c2) {
		return getDistance(c1.getRed(), c1.getGreen(), c1.getBlue(),
				c2.getRed(), c2.getGreen(), c2.getBlue());
	}
	
	/**
	 * Checks if two colors are similar.
	 * @param c1 Color 1.
	 * @param c2 Color 2.
	 * @param tol The tolerance.
	 * @return <tt>true</tt> if similar; else <tt>false</tt>.
	 */
	public static boolean areSimilar(final Color c1, final Color c2, final int tol){
		if (getDistance(c1, c1) <= tol)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if two colors are similar.
	 * @param c1 Color 1.
	 * @param c2 Color 2.
	 * @return <tt>true</tt> if similar; else <tt>false</tt>.
	 */
	public static boolean areSimilar(final Color c1, final Color c2){
		if (getDistance(c1, c1) <= 1)
			return true;
		else
			return false;
	}
	
	/**
	 * Grabs all the colors within a rectangle.
	 * @param r The rectangle.
	 * @return Color The color array.
	 */
	public static Color[] getColors(final Rectangle r){
		List <Color> colors = new LinkedList<Color>();
		for (int x = r.x; x < r.x + r.width; x++){
			for (int y = r.y; y < r.y + r.height; y++){
				final Point p = new Point(x, y);
				if (Game.isPointValid(p))
					colors.add(getColorAt(p));
			}
		}
		return colors.toArray(new Color[colors.size()]);
	}

}
