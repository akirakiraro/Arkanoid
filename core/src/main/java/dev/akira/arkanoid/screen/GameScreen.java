package dev.akira.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import dev.akira.arkanoid.controller.GameController;
import dev.akira.arkanoid.inputmanager.InputManager;
import dev.akira.arkanoid.navigation.Navigation;
import dev.akira.arkanoid.world.Renderer;
import dev.akira.arkanoid.world.World;
import dev.akira.arkanoid.world.stage.GameHUD;

public class GameScreen implements Screen {
	private GameController controller;
	private InputManager inputManager;
	private Navigation nav;
	private World world;
	private Renderer renderer;
	private GameHUD gameHUD;
	
	// Construtor
	public GameScreen(Navigation nav) {
		this.nav = nav;
	}
	
	@Override
	public void show() {
		
		inputManager = new InputManager();
		world = new World();
		controller = new GameController(nav, world, inputManager);
		renderer = new Renderer(world);
		gameHUD = new GameHUD(controller);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		inputManager.update();
		world.update(delta);
		controller.update(delta);
		renderer.render();
		gameHUD.render(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override public void pause() {}

	@Override public void resume() {}

	@Override public void hide() {}

	@Override
	public void dispose() {
		renderer.dispose();
		gameHUD.dispose();
	}

}
