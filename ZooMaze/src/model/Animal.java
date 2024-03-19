package model;

public abstract class Animal {
    protected int x, y; // Konum bilgisi
	
	//if z is true animal is female, if false animal is male
    public boolean isFemale;

    public Animal(int x, int y, boolean isFemale) {
        this.x = x;
        this.y = y;
        this.isFemale = isFemale;
    }

	public abstract int move(); // Hareket metodu

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
