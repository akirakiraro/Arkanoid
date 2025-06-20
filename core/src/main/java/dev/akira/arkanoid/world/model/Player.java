package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.math.Rectangle;

import dev.akira.arkanoid.config.GameConfig;

public class Player {
	private Rectangle bar;
	private Life life;
	private float movespeed = 500f;
	private int direction;
	
	/**
	 * Construtor para a barra
	 * @param x posição do x.
	 * @param y posição do y.
	 * @param width largura do retangulo.
	 * @param height altura do retangulo.
	 */
	public Player(float x, float y, float width, float height) {
		bar = new Rectangle(x, y, width, height);
		life = new Life();
	}
	
    public void update(float delta) {
        // velocidade da bola * fps * direcao
    	bar.x += direction * movespeed * delta;

        // Impede que o jogador saia da tela
        if (bar.x < GameConfig.getInstancia().getX1()) {
        	bar.x = GameConfig.getInstancia().getX1();
        }
        if (bar.x + bar.width > GameConfig.getInstancia().getX2()) {
        	bar.x = GameConfig.getInstancia().getX2() - bar.width;
        }
    }
	
    public void setDirection(int direction) {
    	this.direction = direction;
    }

    public Rectangle getBounds() {
    	return new Rectangle(bar.x, bar.y, bar.width, bar.height);
    }
    
    public float getX() {return bar.x;}
    public float getY() {return bar.y;}
    public float getWidth() {return bar.width;}
    public float getHeight() {return bar.height;}
    public float getMiddleX() {return bar.x + bar.width / 2;}
    public Life getLife() {return life;}
}
