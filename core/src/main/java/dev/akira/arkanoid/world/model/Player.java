package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	private Rectangle bar;
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
	}
	
    public void update(float delta) {
        // velocidade da bola * fps * direcao
    	bar.x += direction * movespeed * delta;

        // Impede que o jogador saia da tela
        if (bar.x < 0) {
        	bar.x = 0;
        }
        if (bar.x + bar.width > Gdx.graphics.getWidth()) {
        	bar.x = Gdx.graphics.getWidth() - bar.width;
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
}
