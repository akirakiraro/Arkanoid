package dev.akira.arkanoid.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.akira.arkanoid.world.model.Player;

public class Renderer {
	private SpriteBatch batch;
    private Texture playerTexture, backgroundTexture;
    private Player player;
    
    public Renderer(World world) {
    	this.player = world.getPlayer();
        this.batch = new SpriteBatch();
        this.playerTexture = new Texture("World/Player/paddle.png");
        this.backgroundTexture = new Texture("background/backgroud_game.png");
    }
    
    public void render() {
    	batch.begin();
    	batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	batch.draw(playerTexture, player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	batch.end();
    }
    
    public void dispose() {
        batch.dispose();
        backgroundTexture.dispose();
        playerTexture.dispose();
    }
}
