package dev.akira.arkanoid.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;

import dev.akira.arkanoid.world.model.Ball;
import dev.akira.arkanoid.world.model.Player;

public class World {
	private Player player;
	private Ball ball;
	
	public World() {
		player = new Player((Gdx.graphics.getWidth() / 2) - 50, 50, 100, 20);
		ball = new Ball((Gdx.graphics.getWidth() / 2), 100, 10);
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
	}
	
	public Player getPlayer() {
		return player;
	}
	public Ball getBall() {
		return ball;
	}
}
