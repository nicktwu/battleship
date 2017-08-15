package BattleshipGame;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Boat {
	
	/*
	 * Rep invariant: coordinates should be in a line, the true locations are the hit locations
	 */
	private final Map<Location, Boolean> coordinates;
	
	public Boat(Map<Location, Boolean> aSet) {
		this.coordinates = aSet;
	}
	
	public Status processAttack(Location l) {
		if (!coordinates.containsKey(l)) {
			return Status.MISSED;
		} else {
			if (coordinates.put(l, true)) {
				return Status.MISSED;
			} else if (isSunk()) {
				return Status.SUNK;
			}
			return Status.HIT;
		}
	}
	
	public boolean isSunk() {
		for (Location l: coordinates.keySet()) {
			if (!coordinates.get(l)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid(int X, int Y) {
		for (Location l: coordinates.keySet()) {
			if (!l.isWithin(X, Y)) {
				return false;
			}
		}
		Set<Integer> xs = new HashSet<Integer>();
		Set<Integer> ys = new HashSet<Integer>();
		for (Location l: coordinates.keySet()) {
			xs.add(l.getX());
			ys.add(l.getY());
		}
		return (xs.size() == 1 || ys.size() == 1);
	}
	
	public boolean occupies(Location l) {
		return coordinates.containsKey(l);
	}
}
