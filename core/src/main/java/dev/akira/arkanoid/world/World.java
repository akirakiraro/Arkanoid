package dev.akira.arkanoid.world;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.config.GameConfig;
import dev.akira.arkanoid.world.levels.Levels;
import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Block;
import dev.akira.arkanoid.world.model.Player;
import dev.akira.arkanoid.world.model.Score;

public class World {
	private Player player;
	private Ball ball;
	private Array<Block> blocks;
	
	public World() {
		player = new Player(GameConfig.getInstancia().getMiddleX() - 50, 100, 100, 20);
		ball = new Ball(GameConfig.getInstancia().getMiddleX(), 120, 10);
		blocks = new Levels().getLevel1();
	}

	public void update(float delta) {
		player.update(delta);
		ball.update(delta);
		if (ball.getDirectionY() > 0) {
			checkCollisionBlock();
		} 
		if (ball.getDirectionY() < 0) {
			checkCollisionsPlayer();
			checkCollisionBlock();
		} 
		
	}
	
	public void checkCollisionsPlayer() {
		if (Intersector.overlaps(ball.getBounds(), player.getBounds())) {
			
			float ballCollision = (ball.getX() - player.getX()) / player.getWidth();
			float angle = 145 - (ballCollision * 130);
			ball.playerCollision(angle);
		}
	}
	public boolean checkCollisionBlock() {	
		// Testa cada bloco
		for (int i = blocks.size - 1; i >= 0; i--) {
		    if (Intersector.overlaps(ball.getBounds(), blocks.get(i).getBounds())) {
		    	// guarda a variavel do bloco
		    	Block block = blocks.get(i);
		    	// remove o bloco
		    	blocks.removeIndex(i);
		    	// verifica a collision com o bloco
		        if (ball.getY() < block.getY()) {
		        	ball.blockCollision(false, true);
		        } else if (ball.getY() > block.getY() + block.getHeight()) {
			        ball.blockCollision(false, true);
		        } else if (ball.getX() < block.getX()) {
		        	ball.blockCollision(true, false);
		        } else if (ball.getX() > block.getX() + block.getWidth()) {
		        	ball.blockCollision(true, false);
		        }
		        Score.getInstancia().addScore();
		        return true;
		    }
		}
		return false;
	}
	
	public Player getPlayer() {
		return player;
	}
	public Ball getBall() {
		return ball;
	}
	public Array<Block> getBlocks() {
		return blocks;
	}
}
