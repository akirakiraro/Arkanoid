package dev.akira.arkanoid.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Block;
import dev.akira.arkanoid.world.model.Player;

public class Renderer {
	private SpriteBatch batch;
    private Texture ballTexture, playerTexture, backgroundTexture, blockTexture, gameBackgroundTexture;
    private Player player;
    private Ball ball;
    private Array<Block> blocks;
    
    public Renderer(World world) {
    	this.ball = world.getBall();
    	this.player = world.getPlayer();
    	this.blocks = world.getBlocks();
        this.batch = new SpriteBatch();
        this.playerTexture = new Texture("World/Player/paddle.png");
        this.backgroundTexture = new Texture("background/backgroud_game.png");
        this.gameBackgroundTexture = new Texture("background/telaGame.png");
        this.ballTexture = new Texture("World/ball_red.png");
        this.blockTexture = new Texture("World/OrangeBlock.png");
    }
    
    public void render() {
    	batch.begin();
    	batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	batch.draw(gameBackgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	batch.draw(playerTexture, player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	batch.draw(ballTexture, ball.getX() - ball.getRadius(), ball.getY()-ball.getRadius(), ball.getRadius()*2, ball.getRadius()*2);
    	for (int i = blocks.size - 1; i >= 0; i--) {
    		batch.draw(blockTexture, blocks.get(i).getX(), blocks.get(i).getY(), blocks.get(i).getWidth(), blocks.get(i).getHeight());
		}
    	batch.end();
    }
    
    public void dispose() {
        batch.dispose();
        backgroundTexture.dispose();
        gameBackgroundTexture.dispose();
        playerTexture.dispose();
        ballTexture.dispose();
        blockTexture.dispose();
    }
}
