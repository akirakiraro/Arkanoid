package dev.akira.arkanoid.world.levels;

import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.world.model.Block;

public class LevelManager {
	private Levels level;
	private int currentLevel = 1;
	private int maxLevel = 2;

	public LevelManager() {
		this.level = new Levels();
	}
	
	public void nextLevel() {
		if (currentLevel < maxLevel) {
			currentLevel++;
		}
	}
	
	public void resetCurrentLevel() {
		currentLevel = 1;
	}
	
	public Array<Block> getCurrentLevel() {
		switch (currentLevel) {
			case 1:
				return level.getLevel1();
			case 2:
				return level.getLevel2();
		}
		return level.getLevel1();
	}
}
