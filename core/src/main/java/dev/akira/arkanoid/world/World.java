package dev.akira.arkanoid.world;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.config.GameConfig;
import dev.akira.arkanoid.world.levels.LevelManager;
import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Block;
import dev.akira.arkanoid.world.model.Player;
import dev.akira.arkanoid.world.model.Score;

public class World {
	private Player player;
	private Ball ball;
	private Array<Block> blocks;
	private LevelManager level;
	
	public World() {
		level = new LevelManager();
		player = new Player(GameConfig.getInstancia().getMiddleX(), 100, 100, 20);
		ball = new Ball(GameConfig.getInstancia().getMiddleX(), 130, 10);
		blocks = new Array<>();
		Score.getInstancia().resetScore();
	}

	public void update(float delta) {
		if(blocks.isEmpty()) {
			blocks.addAll(level.level());
			ball.resetBall();
			level.nextLevel();
			
			if (level.getCurrentLevel() == level.getMaxLevel()) {
				level.resetCurrentLevel();
			}
		}
		player.update(delta);
		ball.update(delta);
		// mantem a bola em cima do player
		if (!ball.getStart()) {
			ball.startBallMove(player.getMiddleX());
		}
		// olha se colidiu com o bloco
		checkCollisionBlock();
		// olha se colidiu com o player e se perdeu
		if (ball.getDirectionY() < 0) {
			checkCollisionsPlayer();
			checkLoseBall();
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
	
	public void checkLoseBall() {
		if(ball.getY() < player.getY()) {
			player.getLife().hitLife();
			System.out.println("tomou um hit, Vida: " + player.getLife().getLife());
			ball.resetBall();
		}
	}
	
	public Player getPlayer() {return player;}
	public Ball getBall() {return ball;}
	public Array<Block> getBlocks() {return blocks;}
}
