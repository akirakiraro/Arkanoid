package dev.akira.arkanoid.world;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.config.GameConfig;
import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Block;
import dev.akira.arkanoid.world.model.Player;
import dev.akira.arkanoid.world.stages.Stage;

public class World {
	private Player player;
	private Ball ball;
	private Array<Block> blocks;
	
	public World() {
		player = new Player(GameConfig.getInstancia().getMiddleX() - 50, 100, 100, 20);
		ball = new Ball(GameConfig.getInstancia().getMiddleX(), 120, 10);
		blocks = new Stage().getStage1();
	}

	public void update(float delta) {
		player.update(delta);
		ball.update(delta);
		checkCollisions();
	}
	
	public void checkCollisions() {
		if (Intersector.overlaps(ball.getBounds(), player.getBounds())) {
			ball.playerCollision();
		}
		
		// Testa cada bloco
		for (int i = blocks.size - 1; i >= 0; i--) {
		    if (Intersector.overlaps(ball.getBounds(), blocks.get(i).getBounds())) {
		        if (ball.getY() < blocks.get(i).getY()) {
		        	ball.blockCollision(0, -1);
		        }
		        if (ball.getY() > blocks.get(i).getY() + blocks.get(i).getHeight()) {
			        ball.blockCollision(0, 1);
		        }
		        if (ball.getX() < blocks.get(i).getX()) {
		        	ball.blockCollision(-1, 0);
		        }
		        if (ball.getX() > blocks.get(i).getX() + blocks.get(i).getWidth()) {
		        	ball.blockCollision(1, 0);
		        }
		        blocks.removeIndex(i);
		        break;
		    }
		}

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
