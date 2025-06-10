package dev.akira.arkanoid.inputmanager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputManager {
	private boolean moveLeft;
	private boolean moveRight;
	
	public void update() {
        moveLeft = Gdx.input.isKeyPressed(Input.Keys.A);
        moveRight = Gdx.input.isKeyPressed(Input.Keys.D);
    }

    public boolean isMovingLeft() {
    	return moveLeft;
    }
    
    public boolean isMovingRight() {
    	return moveRight;
    }
	
}
