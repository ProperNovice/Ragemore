package utils;

import gui.GuiInstances;
import javafx.scene.Cursor;
import javafx.scene.Scene;

public enum CursorFX {

	INSTANCE;

	private Scene scene = GuiInstances.INSTANCE.getScene();

	private CursorFX() {

	}

	public void setWait() {
		this.scene.setCursor(Cursor.WAIT);
	}
	
	public void setDefault() {
		this.scene.setCursor(Cursor.DEFAULT);
	}

}
