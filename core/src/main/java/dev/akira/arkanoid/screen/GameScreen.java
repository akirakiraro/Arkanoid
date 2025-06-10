package dev.akira.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import dev.akira.arkanoid.controller.GameController;
import dev.akira.arkanoid.inputmanager.InputManager;
import dev.akira.arkanoid.navigation.Navigation;
import dev.akira.arkanoid.world.Renderer;
import dev.akira.arkanoid.world.World;

public class GameScreen implements Screen {
	// controller
	private GameController controller;
	
	// Input
	private InputManager inputManager;
	
	// Navigation
	private Navigation nav;
	
	// World
	private World world;
	
	// Renderer
	private Renderer renderer;
	
	// Construtor
	public GameScreen(Navigation nav) {
		this.nav = nav;
	}
	
	@Override
	public void show() {
		
		inputManager = new InputManager();
		world = new World();
		controller = new GameController(nav, world.getPlayer(), inputManager);
		renderer = new Renderer(world);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		inputManager.update();
		controller.update(delta);
		world.update(delta);
		renderer.render();
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
	}

}
