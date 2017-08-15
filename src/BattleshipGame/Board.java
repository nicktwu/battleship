package BattleshipGame;
import java.util.Set;
import java.util.HashSet;

/**
 * Class represents the game board for a battleship game
 * @author nwu
 */
public class Board {
	/*
	 * Rep Invariant: all boats are valid, no boats intersect
	 */
	private final int sizeX;
	private final int sizeY;
	private final Fleet playerBoats;
	private final Fleet computerBoats;
	private final Set<Location> computerGuesses;
	
	public Board(int xSize, int ySize, Fleet aSet, Fleet anotherSet) {
		this.sizeX = xSize;
		this.sizeY = ySize;
		this.playerBoats = aSet;
		this.computerBoats = anotherSet;
		this.computerGuesses = new HashSet<Location>();
	}
	
	public boolean isValid() {
		return (sizeX > 0) && (sizeY > 0) && (playerBoats.isValid(sizeX, sizeY)) && (computerBoats.isValid(sizeX, sizeY));
	}
	
	public Status computerAttack() {
		int guessX = (int) Math.random()*this.sizeX;
		int guessY = (int) Math.random()*this.sizeY;
		while (computerGuesses.contains(new Location(guessX, guessY))) {
			guessX = (int) Math.random()*this.sizeX;
			guessY = (int) Math.random()*this.sizeY;
		}
		return this.playerBoats.attackFleet(new Location(guessX, guessY));
	}
	
	public Status playerAttack(Location l) {
		return this.computerBoats.attackFleet(l);
	}
}
