package dev.akira.arkanoid.world;

import com.badlogic.gdx.Gdx;

import dev.akira.arkanoid.world.model.Player;

public class World {
	private Player player;
	
	public World() {
		player = new Player((Gdx.graphics.getWidth() / 2) - 50, 50, 100, 20);
		
	}

	public void update(float delta) {
		player.update(delta);
	}
	
	public Player getPlayer() {
		return player;
	}
}
