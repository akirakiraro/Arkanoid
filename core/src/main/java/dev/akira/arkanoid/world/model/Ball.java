package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;

public class Ball {
	private Circle ball;
	private float movespeed;
	private int dX=1, dY=1;
	
	public Ball(float x, float y, float radius) {
		ball = new Circle(x, y, radius);
		movespeed = 5f;
	}
	
	public void update(float delta) {
		if (ball.x > Gdx.graphics.getWidth()) {
			dX = -1;
		}
		if (ball.x < 0) {
			dX = 1;
		}
		if (ball.y > Gdx.graphics.getHeight()) {
			dY = -1;
		}
		if (ball.y < 0) {
			dY = 1;
		}
		
		ball.x += movespeed * dX;
		ball.y += movespeed * dY;
	}
	
	public void playerCollision() {
		dY = 1;
	}
	
	public Circle getBounds() {
		return new Circle(ball.x, ball.y, ball.radius);
	}
	
	public float getX() { return ball.x;}
	public float getY() { return ball.y;}
	public float getRadius() { return ball.radius;}
	
}
