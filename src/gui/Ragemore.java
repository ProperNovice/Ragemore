package gui;

import controllers.Credentials;
import controllers.InstantiateComponents;
import controllers.Lists;
import gameStates.JUnit;
import gameStates.RestartGame;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.Flow;
import utils.Logger;
import utils.ObjectPool;
import utils.ShutDown;
import utils.Text;
import utils.Vector2;

public class Ragemore extends Application {

	private Vector2 dimensionsInsets = new Vector2(16, 39);
	private double pixesOnTheLeft = 180;

	@Override
	public void start(Stage primaryStage) throws Exception {

		logJavaVersion();

		Panel panel = new Panel();

		double width = Credentials.INSTANCE.dFrame.x + this.dimensionsInsets.x;
		double height = Credentials.INSTANCE.dFrame.y + this.dimensionsInsets.y;

		Scene scene = new Scene(panel);
		GuiInstances.INSTANCE.setScene(scene);
		setKeyPressed(scene);

		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle(Credentials.INSTANCE.primaryStageTitle);

		primaryStage.setX(
				(Screen.getPrimary().getBounds().getWidth() - width) / 2 - this.pixesOnTheLeft);

		if (Credentials.INSTANCE.dFrame.y == 1368)
			primaryStage.setY(0);
		else
			primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - height) / 2);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.INSTANCE.execute();
			}

		});

		primaryStage.show();

		Lists.INSTANCE.instantiate();
		Text.INSTANCE.toString();

		long start = System.currentTimeMillis();
		Logger.INSTANCE.log("instantiating imageviews");
		InstantiateComponents.INSTANCE.instantiate();
		long end = System.currentTimeMillis();
		Logger.INSTANCE.logNewLine((end - start) + "ms");

		Lists.INSTANCE.saveListsOriginal();

		Flow.INSTANCE.executeGameState(JUnit.class);

	}

	private void setKeyPressed(Scene scene) {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				KeyCode keyCode = event.getCode();

				Logger.INSTANCE.logNewLine(keyCode + " key code pressed");

				if (keyCode.equals(KeyCode.ESCAPE))
					ShutDown.INSTANCE.execute();

				else if (Animation.INSTANCE.isAnimatingSynchronous())
					return;

				else if (keyCode.equals(KeyCode.BACK_QUOTE))
					Flow.INSTANCE.executeGameState(RestartGame.class);

				else if (keyCode.equals(KeyCode.O))
					ObjectPool.INSTANCE.print();

				else
					Flow.INSTANCE.getGameStateCurrent().executeKeyPressed(keyCode);

			}

		});

	}

	private void logJavaVersion() {

		Logger.INSTANCE.log("Java -> " + System.getProperty("java.version"));
		Logger.INSTANCE.log("JavaFX -> " + System.getProperty("javafx.version"));
		Logger.INSTANCE.newLine();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
