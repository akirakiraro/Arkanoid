package dev.akira.arkanoid.controller;

import dev.akira.arkanoid.inputmanager.InputManager;
import dev.akira.arkanoid.navigation.Navigation;
import dev.akira.arkanoid.world.model.Player;

public class GameController {
	private final Navigation nav;
	private InputManager input;
	private Player player;
	
    public GameController(Navigation nav, Player player, InputManager input) {
        this.nav = nav;
        this.player = player;
        this.input = input;
    }
    
    public void update(float delta) {
    	player.setDirection(0);
    	if (input.isMovingLeft()) {
    		player.setDirection(-1);
    	}
    	if (input.isMovingRight()) {
    		player.setDirection(1);
    	}
    }
    	
}
