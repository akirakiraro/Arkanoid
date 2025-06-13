package dev.akira.arkanoid.world.model;

public class Score {
	private static Score instancia;
	private int score;
	
	public Score() {
		this.score = 0;
	}
	
	public static Score getInstancia() {
		if (instancia == null) {
			instancia = new Score();
		}
		return instancia;
	}
	
	public void addScore() {
		score += 100;
	}
	
	public int getScore() {
		return score;
	}
	
}
