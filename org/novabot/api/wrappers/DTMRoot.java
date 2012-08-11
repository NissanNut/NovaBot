package org.novabot.api.wrappers;

import java.awt.Color;

public class DTMRoot {
	public Color color;
	public int tolerance = 0;
	
	private DTMRoot(Color color, int tolerance){
		this.color = color;
		this.tolerance = tolerance;
	}
	
	private DTMRoot(Color color){
		this.color = color;
	}
	
}