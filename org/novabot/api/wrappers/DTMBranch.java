package org.novabot.api.wrappers;

import java.awt.Color;

public class DTMBranch {
	public Color color;
	public int tolerance = 0;
	public int x = 0;
	public int y = 0;
	
	private DTMBranch(Color color, int tolerance, int x, int y){
		this.color = color;
		this.tolerance = tolerance;
		this.x = x;
		this.y = y;
	}
	
	private DTMBranch(Color color, int tolerance){
		this.color = color;
		this.tolerance = tolerance;
	}
	
	private DTMBranch(Color color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	private DTMBranch(Color color){
		this.color = color;
	}
	
}