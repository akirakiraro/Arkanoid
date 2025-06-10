package dev.akira.arkanoid.inputmanager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputManager {
	private boolean moveLeft;
	private boolean moveRight;
	
	public void update() {
        moveLeft = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
        moveRight = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    public boolean isMovingLeft() {
    	return moveLeft;
    }
    
    public boolean isMovingRight() {
    	return moveRight;
    }
	
}
