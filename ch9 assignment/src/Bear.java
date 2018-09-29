/*
 * Mark Kazzaz, 2018-09-28
 * Bellevue College Fall 2018
 * Chapter 9 Assignment
 * 
 */

import java.awt.*;

public class Bear extends Critter {
	
	// bear fields
	boolean isPolar; // true = polar bar; false = black bear
	int moves = 0; // count bear's moves

	// constructor to handle polar parameter
	public Bear(boolean polar) {
		super();
		isPolar = polar;
	}
	
	// color of bear depends on if it's a
	// polar bear or not
	public Color getColor() {
		if (isPolar) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}
	
	public Action getMove(CritterInfo info) {
		moves++; // advance move count
		
		// actions prescribed by assignment requirements
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.LEFT;
		}
	}
	
	public String toString() {
		// if move count is even, return a forward slash
		// if move count is odd, return a black slash
		if (moves % 2 == 0) {
			return "/";
		} else {
			return "\\";
		}
	}
}
