package dev.akira.arkanoid.navigation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import dev.akira.arkanoid.screen.GameOverScreen;
import dev.akira.arkanoid.screen.GameScreen;
import dev.akira.arkanoid.screen.MainMenuScreen;

public class Navigation {
	private final Game game;
	
	public Navigation(Game game) {
		this.game = game;
	}
	
	public void goToMainMenu() {
		game.setScreen(new MainMenuScreen(this));
	}
	
	public void goToGame() {
		game.setScreen(new GameScreen(this));
	}
	public void goToGameOver() {
		game.setScreen(new GameOverScreen(this));
	}
	
	public void setScreen(Screen screen) {
		game.setScreen(screen);
	}
	
}
