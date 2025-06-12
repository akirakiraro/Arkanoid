package dev.akira.arkanoid.world.model;

import com.badlogic.gdx.math.Rectangle;

public class Block {
	private Rectangle block;
	
	public Block(float x, float y, float width, float height) {
		block = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getBounds() {
    	return new Rectangle(block.x, block.y, block.width, block.height);
    }
	public float getX() { return block.x; }
	public float getY() { return block.y; }
	public float getWidth() { return block.width; }
	public float getHeight() { return block.height; }
	
}
