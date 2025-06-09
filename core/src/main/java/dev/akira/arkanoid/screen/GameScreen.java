package dev.akira.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dev.akira.arkanoid.controller.GameController;
import dev.akira.arkanoid.model.Player;
import dev.akira.arkanoid.navigation.Navigation;

public class GameScreen implements Screen {
	// controller
	private GameController controller;
	public GameScreen(Navigation nav) {
		this.controller = new GameController(nav);
	}
	
	// Inicializadores
	private SpriteBatch batch;
	private Texture bg;
	private ShapeRenderer sr;
	
	// Player
	private Player player;
	
	// Tela
	private float windowWidth, windowHeight;
	
	@Override
	public void show() {
		//tela 
		windowWidth = Gdx.graphics.getWidth();
		windowHeight = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		bg = new Texture("background/backgroud_game.png");
		sr = new ShapeRenderer();
		
		player = new Player(windowWidth / 2, 50, 100, 20);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bg, 0, 0, windowWidth, windowHeight);
        batch.end();
        player.initPlayer(sr);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override public void pause() {}

	@Override public void resume() {}

	@Override public void hide() {}

	@Override
	public void dispose() {
		bg.dispose();
		sr.dispose();
		batch.dispose();
	}

}
