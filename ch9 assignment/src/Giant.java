import java.awt.*;

public class Giant extends Critter {
	//giant fields
	boolean labelTest; // fee v fum
	int moves; // count individual giant moves
	
	public Color getColor() {
		return Color.GRAY;
	}
	
	public String labelHelper(boolean input) {
		if (input) {
			return "fee";
		} else {
			return "fum";
		}
	}
	
	public Action getMove(CritterInfo info) {
		moves++;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() != Neighbor.EMPTY) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
	
	public String toString() {
		if (moves % 6 == 0) {
			labelTest = !labelTest;
		}
		
		return labelHelper(labelTest);
	}
}
