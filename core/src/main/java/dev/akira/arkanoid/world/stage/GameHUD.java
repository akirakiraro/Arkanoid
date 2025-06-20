package dev.akira.arkanoid.world.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import dev.akira.arkanoid.controller.GameController;
import dev.akira.arkanoid.world.model.Score;

public class GameHUD {
	private GameController controller;
	private SpriteBatch batch;
	private Texture lifeTexture;
	private Stage stage;
	private Skin skin;
	private Label score;
	private ShapeRenderer sr;
	
	// Score
	private int scoreX = 670;
	private int scoreY = 800;
	private int scoreWidth = 210;
	private int scoreHeight = 50;
	
	public GameHUD(GameController gameController) {
		this.controller = gameController;
		this.batch = new SpriteBatch();
		this.sr = new ShapeRenderer();
		this.stage = new Stage(new FitViewport(900, 900));
		Gdx.input.setInputProcessor(stage);
		
		this.lifeTexture = new Texture("World/Player/paddle.png");
		
		setSkin();
		addButtonSair();
		addScore();
	}
	
	public void render(float delta) {
		// desenha o retangulo cinza do score
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.GRAY);
	    sr.rect(scoreX, scoreY, scoreWidth, scoreHeight);
		sr.end();
		// desenha o score
		score.setText("Score: " + Score.getInstancia().getScore());
		stage.act(delta);
		stage.draw();
		// desenha as vidas
		batch.begin();
		addLives();
		batch.end();
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
		lifeTexture.dispose();
		batch.dispose();
	}

	public void addLives() {
		for (int i = 0; i < controller.getLife(); i++) {
			batch.draw(lifeTexture, 50 + (i * 70), 20, 60, 20);
		}
	}
	
	private void addScore() {
		score = new Label("Score: 0", skin);
		score.setPosition(scoreX + 10, scoreY);
		score.setSize(scoreWidth, scoreHeight);
		stage.addActor(score);
	}
	
	private void addButtonSair() {
		TextButton sairBtn = new TextButton("Sair", skin);
		sairBtn.setSize(80, 30);
		sairBtn.setPosition(800, 50);
		sairBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				controller.onButtonClicked("sair");
			}
		});
		stage.addActor(sairBtn);
	}
	
	private void setSkin() {
		this.skin = new Skin(Gdx.files.internal("skin/game/uiskin.json"));
	}
}
