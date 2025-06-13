package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import dev.akira.arkanoid.config.GameConfig;

public class Ball {
	private Circle ball;
	private Vector2 movespeed;
	
	public Ball(float x, float y, float radius) {
		this.ball = new Circle(x, y, radius);
		this.movespeed = new Vector2(GameConfig.getInstancia().getBallMovespeed(), GameConfig.getInstancia().getBallMovespeed());
	}
	
	public void update(float delta) {
		// bate na parede da direita
		if (ball.x + ball.radius > GameConfig.getInstancia().getX2() &&
			movespeed.x > 0) {
			reverseX();
		}
		// bate na parede da esquerda
		if (ball.x - ball.radius< GameConfig.getInstancia().getX1() &&
			movespeed.x < 0	) {
			reverseX();
		}
		// bate na parede de cima 
		if (ball.y + ball.radius > GameConfig.getInstancia().getY2() &&
			movespeed.y > 0) {
			reverseY();
		}
		// bate na parede de baixo 
		if (ball.y - ball.radius < GameConfig.getInstancia().getY1() &&
			movespeed.y < 0) {
			reverseY();
		}
		
		ball.x += movespeed.x * delta;
		ball.y += movespeed.y * delta;
	}
	
	public void playerCollision(float angle) {
		movespeed.setAngleDeg(angle);
	}
	public void blockCollision(boolean collisionX, boolean collisionY) {
		if (collisionX) {
			reverseX();
		}
		if (collisionY) {
			reverseY();
		}
	}
	
	private void reverseX() {
		movespeed.x *= -1;
	}
	private void reverseY() {
		movespeed.y *= -1;
	}
	
	public Circle getBounds() {
		return new Circle(ball.x, ball.y, ball.radius);
	}
	
	public float getDirectionX() { return movespeed.x; }
	public float getDirectionY() { return movespeed.y; }
	public float getX() { return ball.x;}
	public float getY() { return ball.y;}
	public float getRadius() { return ball.radius;}
	
}
