/*
 * Mark Kazzaz, 2018-09-28
 * Bellevue College Fall 2018
 * Chapter 9 Assignment
 * 
 */

import java.awt.*;

public class Lion extends Critter {
	//lion fields
	int moves; // count moves of this lion
	Color lionColor; //track assigned color
	
	// helper for picking a random integer
	// derived from https://stackoverflow.com/questions/7961788/math-random-explanation
	public static int getRandom(int min, int max) {
		int range = (max - min + 1);
		return (int)(Math.random() * range) + 1;
	}
	
	// helper for picking a random color
	public Color getRandomColor() {
		int result = getRandom(1,3);
		if (result == 1) {
			return Color.RED;
		} else if (result == 2) {
			return Color.BLUE;
		} else {
			return Color.GREEN;
		}
	}
	
	public Color getColor() {
		// when moves is 0 or multiple of 3, assign random color
		if (moves % 3 == 0) {
			lionColor = getRandomColor();
		}
		
		return lionColor;
	}
	
	public Action getMove(CritterInfo info) {
		// count this action as a move
		moves++;
		
		// actions prescribed by assignment requirements
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
	
	// print string prescribed by assignment requirements
	public String toString() {
		return "L";
	}
	
}
