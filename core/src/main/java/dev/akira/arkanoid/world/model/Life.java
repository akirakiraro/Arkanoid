package dev.akira.arkanoid.world.model;

public class Life {
	
	private int lives, maxLives;
	private boolean isLive;
	
	public Life() {
		this.maxLives = 1;
		this.lives = maxLives;
		this.isLive = true;
	}
	
	public void hitLife() {
		if (lives == 1) {
			this.isLive = false;
		}
		if (lives == 0) {
			return;
		}
		this.lives -= 1;
	}
	
	public void addLife() {
		if (lives == maxLives) {
			return;
		}
		lives += 1;
	}
	
	public boolean isLive() { return isLive; }
	public int getLife() { return lives; }
}
