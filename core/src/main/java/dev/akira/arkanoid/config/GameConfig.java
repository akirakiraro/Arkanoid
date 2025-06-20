package dev.akira.arkanoid.config;

import com.badlogic.gdx.Gdx;

public class GameConfig {

	private static GameConfig instancia;
	// Tela
	private float x1, x2, y1, y2;
	private float width, height;
	private float offsetX, offsetY;
	
	// Velocidade da bola base
	private float ballMovespeed;
	
	private GameConfig() {
		this.width = 600;
		this.height = 800;
		this.offsetX = -100;
		this.offsetY = 0;
		this.x1 = (Gdx.graphics.getWidth() / 2) - (width / 2) + offsetX;
		this.y1 = (Gdx.graphics.getHeight() / 2) - (height / 2) + offsetY;
		this.x2 = (Gdx.graphics.getWidth() / 2) + (width / 2) + offsetX;
		this.y2 = (Gdx.graphics.getHeight() / 2) + (height / 2) + offsetY;
		// Ball
		this.ballMovespeed = 400;
	}
	
	public static GameConfig getInstancia() {
        if (instancia == null) {
        	instancia = new GameConfig();
        }
        return instancia;
    }
	
	public float getX1() { return x1;}
	public float getY1() { return y1;}
	public float getX2() { return x2;}
	public float getY2() { return y2;}
	public float getWidth() { return width;}
	public float getHeight() { return height;}
	public float getMiddleX() { return (x2 - x1) / 2;}
	// ball
	public float getBallMovespeed() { return ballMovespeed;}
	
}
