package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.math.Circle;

import dev.akira.arkanoid.config.GameConfig;

public class Ball {
	private Circle ball;
	private float movespeed;
	private int dX=1, dY=1;
	
	public Ball(float x, float y, float radius) {
		ball = new Circle(x, y, radius);
		movespeed = 5f;
	}
	
	public void update(float delta) {
		if (ball.x + ball.radius > GameConfig.getInstancia().getX2()) {
			dX = -1;
		}
		if (ball.x - ball.radius< GameConfig.getInstancia().getX1()) {
			dX = 1;
		}
		if (ball.y + ball.radius > GameConfig.getInstancia().getY2()) {
			dY = -1;
		}
		if (ball.y - ball.radius < GameConfig.getInstancia().getY1()) {
			dY = 1;
		}
		
		ball.x += movespeed * dX;
		ball.y += movespeed * dY;
	}
	
	public void playerCollision() {
		dY = 1;
	}
	public void blockCollision(int directionX, int directionY) {
		if (directionX != 0) {
			dX = directionX;
		}
		if (directionY != 0) {
			dY = directionY;
		}
	}
	
	public Circle getBounds() {
		return new Circle(ball.x, ball.y, ball.radius);
	}
	
	public float getX() { return ball.x;}
	public float getY() { return ball.y;}
	public float getRadius() { return ball.radius;}
	
}
