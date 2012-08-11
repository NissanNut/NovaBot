package org.novabot.api.wrappers;

import java.awt.Point;
import java.util.LinkedList;

import org.novabot.api.methods.ColorUtil;
import org.novabot.api.methods.Game;

public class DTM {
	private DTMRoot root;
	private DTMBranch[] branches;

	private DTM(DTMRoot root, DTMBranch... branches){
		this.root = root;
		this.branches = branches;
	}
	
	public int getHeight(){
		int high = 0;
		int low = 0;
		
		for(DTMBranch b : branches){
			if (b.y > high)
				high = b.y;
			if (b.y < low)
				low = b.y;
		}
		
		return Math.abs(high) + Math.abs(low);
	}
	
	public int getWidth(){
		int high = 0;
		int low = 0;
		
		for(DTMBranch b : branches){
			if (b.x > high)
				high = b.x;
			if (b.x < low)
				low = b.x;
		}
		
		return Math.abs(high) + Math.abs(low);
	}
	
	
	
	public boolean isValid(){
		LinkedList<Point> rootPts = ColorUtil.getPointsWithColor(Game.getImage(), root.color, root.tolerance);
		if (rootPts.size() > 0){
			for(Point p : rootPts){
				int validPts = 0;
				for (DTMBranch b : branches){
					Point branchPt = new Point(p.x + b.x, p.y + b.y);
						if (ColorUtil.getDistance(ColorUtil.getColorAt(branchPt), b.color) <= b.tolerance)
							validPts++;
						else
							continue;
				}
				if (validPts == branches.length)
					return true;
			}
		}
		return false;
	}
	
	public LinkedList<Point> getValidPoints(){
		LinkedList<Point> valid = new LinkedList<Point>();
		LinkedList<Point> rootPts = ColorUtil.getPointsWithColor(Game.getImage(), root.color, root.tolerance);
		if (rootPts.size() > 0){
			for(Point p : rootPts){
				int validPts = 0;
				for (DTMBranch b : branches){
					Point branchPt = new Point(p.x + b.x, p.y + b.y);
						if (ColorUtil.getDistance(ColorUtil.getColorAt(branchPt), b.color) <= b.tolerance)
							validPts++;
						else
							continue;
				}
				if (validPts == branches.length)
					valid.add(p);
			}
		}
		return valid;
	}
	
	public Point getFirstPoint(){
		LinkedList<Point> rootPts = ColorUtil.getPointsWithColor(Game.getImage(), root.color, root.tolerance);
		if (rootPts.size() > 0){
			for(Point p : rootPts){
				int validPts = 0;
				for (DTMBranch b : branches){
					Point branchPt = new Point(p.x + b.x, p.y + b.y);
						if (ColorUtil.getDistance(ColorUtil.getColorAt(branchPt), b.color) <= b.tolerance)
							validPts++;
						else
							continue;
				}
				if (validPts == branches.length)
					return p;
			}
		}
		return null;
	}
	
}




