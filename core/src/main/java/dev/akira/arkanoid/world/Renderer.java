package dev.akira.arkanoid.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Player;

public class Renderer {
	private SpriteBatch batch;
    private Texture ballTexture, playerTexture, backgroundTexture;
    private Player player;
    private Ball ball;
    
    public Renderer(World world) {
    	this.ball = world.getBall();
    	this.player = world.getPlayer();
        this.batch = new SpriteBatch();
        this.playerTexture = new Texture("World/Player/paddle.png");
        this.backgroundTexture = new Texture("background/backgroud_game.png");
        this.ballTexture = new Texture("World/ball_red.png");
    }
    
    public void render() {
    	batch.begin();
    	batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	batch.draw(playerTexture, player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	batch.draw(ballTexture, ball.getX() - ball.getRadius(), ball.getY()-ball.getRadius(), ball.getRadius()*2, ball.getRadius()*2);
    	batch.end();
    }
    
    public void dispose() {
        batch.dispose();
        backgroundTexture.dispose();
        playerTexture.dispose();
        ballTexture.dispose();
    }
}
