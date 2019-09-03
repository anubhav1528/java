package TestingJUnit;

public class Calculator {
	public int x;
	public int y;

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

	public Calculator() {
		super();
	}

	public Calculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int compare() {
		if (x > y) {
			return 1;
		} else {
			return -1;
		}
	}
}
