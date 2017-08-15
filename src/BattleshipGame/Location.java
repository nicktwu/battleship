package BattleshipGame;

public class Location {
	private final int X;
	private final int Y;
	
	public Location(int aX, int aY) {
		this.X = aX;
		this.Y = aY;
	}
	
	public boolean isWithin(int boundX, int boundY) {
		return (X>=0)&&(X<boundX)&&(Y>=0)&&(Y<boundY);
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}
	
}
