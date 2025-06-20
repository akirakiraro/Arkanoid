package dev.akira.arkanoid.world.levels;

import com.badlogic.gdx.utils.Array;

import dev.akira.arkanoid.config.GameConfig;
import dev.akira.arkanoid.world.model.Block;

public class Levels {
	private Array<Block> level;
	
	private float blockWidth, blockHeight;
	private float maxRow, maxCol;
	private float initialX, initialY;
	private float x, y;
	
	public Levels() {
		level = new Array<>();
	}
	
	
	public Array<Block> getLevel1(){
		level.clear();
		blockWidth = 100;
		blockHeight = 60;
		maxRow = 1;
		maxCol = 1;
		initialX = GameConfig.getInstancia().getX1();
		initialY = GameConfig.getInstancia().getY1() + 400;
		for (float row = 0; row < maxRow; row++) {
			for (float col = 0; col < maxCol; col++) {
				x = initialX + (col * blockWidth);
				y = initialY + (row * blockHeight);
				level.add(new Block(x, y,blockWidth,blockHeight));
			}
		}
		return level;
	}
	
	public Array<Block> getLevel2(){
		level.clear();
		blockWidth = 100;
		blockHeight = 60;
		maxRow = 5;
		maxCol = 3;
		initialX = GameConfig.getInstancia().getX1();
		initialY = GameConfig.getInstancia().getY1() + 400;
		for (float row = 0; row < maxRow; row++) {
			for (float col = 0; col < maxCol; col++) {
				x = initialX + (col * blockWidth * 2);
				y = initialY + (row * blockHeight);
				level.add(new Block(x, y,blockWidth,blockHeight));
			}
		}
		return level;
	}
}
