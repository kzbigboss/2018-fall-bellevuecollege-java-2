import java.awt.*;

public class Bear extends Critter {
	
	// bear fields
	boolean isPolar;
	int moves = 0;

	// constructor
	public Bear(boolean polar) {
		super();
		isPolar = polar;
	}
	
	public Color getColor() {
		if (isPolar) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}
	
	public Action getMove(CritterInfo info) {
		moves++;
		
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.LEFT;
		}
	}
	
	public String toString() {
		if (moves % 2 == 0) {
			return "/";
		} else {
			return "\\";
		}
	}
}
