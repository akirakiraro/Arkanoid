package dev.akira.arkanoid.world.stage;

import com.badlogic.gdx.Gdx;
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
	private Stage stage;
	private Skin skin;
	private Label score;
	
	public GameHUD(GameController gameController) {
		this.controller = gameController;
		this.stage = new Stage(new FitViewport(900, 900));
		Gdx.input.setInputProcessor(stage);
		
		setSkin();
		addButtonSair();
		addScore();
	}
	
	public void render(float delta) {
		score.setText("Score: " + Score.getInstancia().getScore());
		stage.act(delta);
		stage.draw();
	}
	
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}

	private void addScore() {
		score = new Label("Score: 0", skin);
		score.setPosition(670, 800);
		score.setSize(100, 50);
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
