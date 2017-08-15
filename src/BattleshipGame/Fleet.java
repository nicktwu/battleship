package BattleshipGame;
import java.util.Set;

public class Fleet {
	/*
	 * Represents a fleet of boats
	 */
	
	private final Set<Boat> boats;
	
	public Fleet(Set<Boat> aSet) {
		this.boats = aSet;
	}
	
	public boolean isValid(int X, int Y) {
		for(Boat b : boats) {
			if (!b.isValid(X, Y)) {
				return false;
			}
		}
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				int count = 0;
				for (Boat b : boats) {
					if (b.occupies(new Location(i, j))) {
						count++;
					}
				}
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isDestroyed() {
		for(Boat boat : boats) {
			if (!boat.isSunk()) {
				return false;
			}
		}
		return true;
	}
	
	public Status attackFleet(Location l) {
		for(Boat b : boats) {
			Status attackStatus = b.processAttack(l);
			if (attackStatus != Status.MISSED) {
				if (isDestroyed()) {
					return Status.DESTROYED;
				}
				return attackStatus;
			}
		}
		return Status.MISSED;
	}
	
}
