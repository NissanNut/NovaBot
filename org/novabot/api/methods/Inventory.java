package org.novabot.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.novabot.api.util.Random;

/**
 * Basic Inventory class.
 * @version 0.1
 * @author Tanner
 */
public class Inventory {
	
	public final Rectangle BOUNDS = new Rectangle(563, 213, 161, 247);
	
	/**
	 * Inventory slot bounds.
	 * @author Tanner
	 */
	public enum Slot {
		SLOT_0(new Rectangle (563, 213, 35, 31)),
		SLOT_1(new Rectangle (605, 213, 35, 31)),
		SLOT_2(new Rectangle (647, 213, 35, 31)),
		SLOT_3(new Rectangle (689, 213, 35, 31)),
		SLOT_4(new Rectangle (563, 249, 35, 31)),
		SLOT_5(new Rectangle (605, 249, 35, 31)),
		SLOT_6(new Rectangle (647, 249, 35, 31)),
		SLOT_7(new Rectangle (689, 249, 35, 31)),
		SLOT_8(new Rectangle (563, 285, 35, 31)),
		SLOT_9(new Rectangle (605, 285, 35, 31)),
		SLOT_10(new Rectangle (647, 285, 35, 31)),
		SLOT_11(new Rectangle (689, 285, 35, 31)),
		SLOT_12(new Rectangle (563, 321, 35, 31)),
		SLOT_13(new Rectangle (605, 321, 35, 31)),
		SLOT_14(new Rectangle (647, 321, 35, 31)),
		SLOT_15(new Rectangle (689, 321, 35, 31)),
		SLOT_16(new Rectangle (563, 357, 35, 31)),
		SLOT_17(new Rectangle (605, 357, 35, 31)),
		SLOT_18(new Rectangle (647, 357, 35, 31)),
		SLOT_19(new Rectangle (689, 357, 35, 31)),
		SLOT_20(new Rectangle (563, 393, 35, 31)),
		SLOT_21(new Rectangle (605, 393, 35, 31)),
		SLOT_22(new Rectangle (647, 393, 35, 31)),
		SLOT_23(new Rectangle (689, 393, 35, 31)),
		SLOT_24(new Rectangle (563, 429, 35, 31)),
		SLOT_25(new Rectangle (605, 429, 35, 31)),
		SLOT_26(new Rectangle (647, 429, 35, 31)),
		SLOT_27(new Rectangle (689, 429, 35, 31));
		
		public final Rectangle bounds;
		
		/**
		 * A new enum for organizing slots.
		 * @param bounds The bounds of the slot
		 */
		private Slot(final Rectangle bounds){
			this.bounds = bounds;
		}
		
		/**
		 * Gets the bounds of the slot.
		 * @return The slot's bounds
		 */
		public Rectangle getBounds(){
			return bounds;
		}
		
		/**
		 * Gets the center of the slot.
		 * @return The slot's center
		 */
		public Point getCenter(){
			return new Point((int) bounds.x + bounds.width/2, (int) bounds.y + bounds.height/2);
		}
		
		/**
		 * Gets the colors within a slot.
		 * @return Color Array
		 */
		public Color[] getColors(){
			return ColorUtil.getColors(bounds);
		}
	}
	
	/**
	 * Selects or clicks the specified slot.
	 * @param slot The slot to be selected
	 */
	public void select(Slot slot){
		Mouse.click(Random.point(slot.bounds));		
	}
	
	/**
	 * Gets the colors within the inventory.
	 * @return Color Array
	 */
	public Color[] getColors(){
		return ColorUtil.getColors(BOUNDS);
	}
	
}
