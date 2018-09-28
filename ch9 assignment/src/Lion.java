import java.awt.*;

public class Lion extends Critter {
	//lion fields
	int moves; // count moves of this lion
	Color lionColor; //track assigned color
	
	// helper for picking a random integer
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
		// if no moves yet, pick a random color
		if (moves == 0) {
			lionColor = getRandomColor();
		// when move is multiple of 3, pick a random color
		} else if (moves % 3 == 0) {
			lionColor = getRandomColor();
		}
		return lionColor;
	}
	
	
// TODO figure out lion color
	
	public Action getMove(CritterInfo info) {
		//count this action as a move
		moves++;
		
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
	
	public String toString() {
		return "L";
	}
	
}
