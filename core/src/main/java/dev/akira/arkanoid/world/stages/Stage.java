package dev.akira.arkanoid.world.stages;

import com.badlogic.gdx.utils.Array;

import dev.akira.arkanoid.config.GameConfig;
import dev.akira.arkanoid.world.model.Block;

public class Stage {
	private Array<Block> stage;
	
	private float blockWidth, blockHeight;
	private float maxRow, maxCol;
	private float initialX, initialY;
	private float x, y;
	
	public Stage() {
		stage = new Array<>();
	}
	
	
	public Array<Block> getStage1(){
		blockWidth = 100;
		blockHeight = 60;
		maxRow = 5;
		maxCol = 6;
		initialX = GameConfig.getInstancia().getX1();
		initialY = GameConfig.getInstancia().getY1() + 400;
		for (float row = 0; row < maxRow; row++) {
			for (float col = 0; col < maxCol; col++) {
				x = initialX + (col * blockWidth);
				y = initialY + (row * blockHeight);
				stage.add(new Block(x, y,blockWidth,blockHeight));
			}
		}
		return stage;
	}
}
