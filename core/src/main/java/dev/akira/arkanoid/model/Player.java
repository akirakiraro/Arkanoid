package dev.akira.arkanoid.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	private Rectangle bar;
	
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
	
	/**
	 * Inicializa a barra
	 * @param sr Recebe o shapeRenderer
	 */
	public void initPlayer(ShapeRenderer sr) {
		sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1, 1, 1, 1);
        sr.rect(bar.x, bar.y, bar.width, bar.height);
        sr.end();
	}
	
	/**
	 * Move a posição da barra (x)
	 * @param posX posição do X.
	 */
	public void moveBar(float posX) {
		bar.x += posX;
	}
	
}
