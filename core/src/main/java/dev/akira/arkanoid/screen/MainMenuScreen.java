package dev.akira.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import dev.akira.arkanoid.controller.MainMenuController;
import dev.akira.arkanoid.navigation.Navigation;

/** First screen of the application. Displayed after the application is created. */
public class MainMenuScreen implements Screen {
	private Stage stage;
    private Skin skin, skinTitle;
	private MainMenuController controller;
	
	public MainMenuScreen(Navigation nav) {
		this.controller = new MainMenuController(nav);
	}
	
	@Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skinTitle = new Skin(Gdx.files.internal("skinTitle/uiskin.json"));
        
        Table tableGeral = new Table();
        tableGeral.setFillParent(true);
        stage.addActor(tableGeral);

        Table tableLeftButtons = new Table();
        Table tableRightHelp = new Table();
        
        Label title = new Label("Arkanoid", skinTitle);
        Label helpTitle = new Label("HELP", skin);
        Label helpText = new Label("a - esquerda\n b - direita", skin);
        TextButton playButton = new TextButton("Jogar", skin);
        TextButton exitButton = new TextButton("Sair", skin);
        
        tableLeftButtons.add(playButton).top().padTop(20).padBottom(50).row();
        tableLeftButtons.add(exitButton).row();
        
        tableRightHelp.add(helpTitle).top().padTop(20).padBottom(10).row();
        tableRightHelp.add(helpText).row();
        
        tableGeral.add(title).padTop(100).top().colspan(2).height(50).row();
        tableGeral.add(tableLeftButtons).expand().padRight(20);
        tableGeral.add(tableRightHelp).expand().padLeft(20);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.onButtonClicked("play");
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.onButtonClicked("exit");
            }
        });
    }

    @Override public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {
    	stage.dispose();
    	skin.dispose();
    }
    @Override public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}