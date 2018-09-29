/*
 * Mark Kazzaz, 2018-09-28
 * Bellevue College Fall 2018
 * Chapter 9 Assignment
 * 
 */

import java.awt.*;

public class Giant extends Critter {
	//giant fields
	int labelPhase; // count of what label to show
	String labelText; //string holding label value for giants
	int moves; // count individual giant moves
	
	public Color getColor() {
		// color set via assignment requirements
		return Color.GRAY;
	}
	
	public Action getMove(CritterInfo info) {
		moves++; // advance move counter for given instance of giant
		
		// conditional to set action via assignment requirements
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() != Neighbor.EMPTY) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
	
	public String toString() {
		// requirements state label should change every time a
		// move multiple of 6 is reached.
		if (moves % 6 == 0) {
			setLabel();
		}
		
		return labelText;
	}
	
	public String setLabel() {
		// advance the label phase each time it's called
		// every 4 times, repeat from beginning
		
		labelPhase++;
		
		if (labelPhase == 1) {
			labelText = "fee";
		} else if (labelPhase == 2) {
			labelText = "fie";
		} else if (labelPhase == 3) {
			labelText = "foe";
		} else {
			labelPhase = 0; // restart conditional loop next call
			labelText= "fum";
		}
		return labelText;
	}
}
