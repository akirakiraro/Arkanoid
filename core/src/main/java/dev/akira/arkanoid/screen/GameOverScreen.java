package dev.akira.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import dev.akira.arkanoid.controller.GameOverController;
import dev.akira.arkanoid.navigation.Navigation;

public class GameOverScreen implements Screen{
	private GameOverController controller;
	private Stage stage;
	private Skin skin, skinTitle;
	
	public GameOverScreen(Navigation nav) {
		this.controller = new GameOverController(nav);
	}
	
	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skinTitle = new Skin(Gdx.files.internal("skinTitle/uiskin.json"));
		
        Table table = new Table();
        Table tableButtons = new Table();
        table.setFillParent(true);
        table.top();
        stage.addActor(table);
        
        Label title = new Label("Game Over", skinTitle);
        Label sss1 = new Label("case 1", skin);
        TextButton submitButton = new TextButton("Enviar", skin);
        TextButton backButton = new TextButton("Voltar", skin);
        
        table.add(title).top().pad(10).row();
        table.add(sss1).top().pad(30).row();
        
        tableButtons.add(submitButton).top().pad(30);
        tableButtons.add(backButton).top().pad(30).row();
        table.add(tableButtons).top();
        
        submitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.onButtonClicked("submit");
            }
        });

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.onButtonClicked("back");
            }
        });
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {
		stage.dispose();
    	skin.dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
    	skin.dispose();
	}

}
