/*
 * Mark Kazzaz, 2018-09-28
 * Bellevue College Fall 2018
 * Chapter 9 Assignment
 * 
 */


import java.awt.*;

public class MK extends Critter {
	public Color getColor() {
		return Color.GREEN; // arbitrarily set
	}
	
	
	// derivative of fly trap
	// spin to the right unless
	// there's an emeny in front
	// that can be infected.
	
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else {
            return Action.RIGHT;
        }
    }
	
	public String toString() {
		return "K"; // arbitrarily set
	}
}
