package org.novabot.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.novabot.api.util.Random;
/**
 * Basic Tab class.
 * @version 0.1
 * @author Tanner
 */
public class Tabs {
	
	public final static Rectangle BOUNDS = new Rectangle(522, 168, 240, 334);
	public final static Color OPEN_COLOR = new Color(86, 73, 42);
	
	/**
	 * Tab bounds and shortcuts.
	 * @author Tanner
	 */
	public enum Tab{
		Combat(new Rectangle(522, 168, 29, 32), KeyEvent.VK_F5),
		Task(new Rectangle(552, 168, 29, 32), -1),
		Stats(new Rectangle(582, 168, 29, 32), -1),
		Quest(new Rectangle(612, 168, 29, 32), -1),
		Inventory(new Rectangle(642, 168, 29, 32), KeyEvent.VK_F1),
		Equiptment(new Rectangle(672, 168, 29, 32), KeyEvent.VK_F2),
		Prayer(new Rectangle(702, 168, 29, 32), KeyEvent.VK_F3),
		Magic(new Rectangle(732, 168, 29, 32), KeyEvent.VK_F4),
		Squeal(new Rectangle(522, 466, 29, 32), -1),
		Friends_List(new Rectangle(552, 466, 29, 32), -1),
		Friends_Chat(new Rectangle(582, 466, 29, 32), -1),
		Clan_Chat(new Rectangle(612, 466, 29, 32), -1),
		Options(new Rectangle(642, 466, 29, 32), -1),
		Emotes(new Rectangle(672, 466, 29, 32), -1),
		Music(new Rectangle(702, 466, 29, 32), -1),
		Notes(new Rectangle(732, 466, 29, 32), -1);

		public final Rectangle bounds;
		public final int key;
		
		/**
		 * A new enum for organizing tabs.
		 * @param bounds The bounds of each tab
		 * @param key The shortcut key (if available)
		 */
		private Tab(final Rectangle bounds, final int key){
			this.bounds = bounds;
			this.key = key;
		}
		
		/**
		 * Gets the bounds of a tab.
		 * @return The tab's bounds
		 */
		public Rectangle getBounds(){
			return bounds;
		}
		
		/**
		 * Gets the center of the tab.
		 * @return The tab's center
		 */
		public Point getCenter(){
			return new Point((int) bounds.x + bounds.width/2, (int) bounds.y + bounds.height/2);
		}
		
		/**
		 * Checks if the tab is open.
		 * @return <tt>true</tt> if tab is open; else <tt>false</tt>
		 */
		public boolean isOpen(){
			return bounds.contains(ColorUtil.getPointWithColor(Game.getImage(), BOUNDS, OPEN_COLOR, 1));
		}
	}
	
	/**
	 * Opens a specified tab.
	 * @param tab The tab
	 */
	public void openTab(final Tab tab){
			Mouse.click(Random.pointInRect(tab.bounds));
	}
	
	/**
	 * Checks if a tab is open.
	 * @param tab The tab
	 * @return <tt>true<tt> if the tab is open and <tt>false</tt> if the tab is not
	 */
	public boolean isOpen(Tab tab){
		return false;
	}
	
	/**
	 * Finds the tab that is open.
	 * @return The open Tab
	 */
	public Tab getOpenTab(){
		Point p = ColorUtil.getPointWithColor(Game.getImage(), BOUNDS, OPEN_COLOR, 1);
		for (Tab tab : Tabs.Tab.values()){
			if (tab.bounds.contains(p))
				return tab;
		}
		return null;
	}

}
