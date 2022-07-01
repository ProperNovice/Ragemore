package enums;

import utils.Vector2;

public enum SelectPositionVector2 {

	CENTER(0.5, 0.5), CENTER_DOWN(0.5, 0.5), CENTER_LEFT(0.5, 0.5);

	private double x, y;

	private SelectPositionVector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2 getSelectPosition() {
		return new Vector2(x, y);
	}

}
