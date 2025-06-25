package dev.akira.arkanoid.world.levels;

import com.badlogic.gdx.utils.Array;
import dev.akira.arkanoid.world.model.Block;

public class LevelManager {
	private int stage = 0;
	private Levels level;
	private int currentLevel;
	private int maxLevel = 3;

	public LevelManager() {
		this.level = new Levels();
		this.currentLevel = 1;
	}
	
	public void nextLevel() {
		if (currentLevel < maxLevel) {
			currentLevel++;
			return;
		}
		if (currentLevel == maxLevel) {
			stage++;
			resetCurrentLevel();
			return;
		}
	}
	
	public void resetCurrentLevel() {
		currentLevel = 1;
	}
	
	public Array<Block> level() {
		switch (currentLevel) {
			case 1:
				return level.getLevel1();
			case 2:
				return level.getLevel2();
			case 3:
				return level.getLevel3();
		}
		return level.getLevel1();
	}
	
	public int getMaxLevel() { return maxLevel; }
	public int getCurrentLevel() { return currentLevel; }
	public int getStage() { return stage; }
}
