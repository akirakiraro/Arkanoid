package dev.akira.arkanoid.controller;

import dev.akira.arkanoid.controller.screen.ScreenController;
import dev.akira.arkanoid.inputmanager.InputManager;
import dev.akira.arkanoid.navigation.Navigation;
import dev.akira.arkanoid.world.World;
import dev.akira.arkanoid.world.model.Player;

public class GameController implements ScreenController{
	private final Navigation nav;
	private InputManager input;
	private World world;
	private Player player;
	
    public GameController(Navigation nav, World world, InputManager input) {
        this.nav = nav;
        this.world = world;
        this.player = world.getPlayer();
        this.input = input;
    }
    
    public void update(float delta) {
    	player.setDirection(0);
    	
    	if (!player.getLife().isLive()) {
    		nav.goToGameOver();
    		return;
    	}
    	
    	if (input.startGame()) {
    		world.getBall().startBall();
    	}
    	if (input.isMovingLeft()) {
    		player.setDirection(-1);
    	}
    	if (input.isMovingRight()) {
    		player.setDirection(1);
    	}
    	
    	
    }

	@Override
	public void onButtonClicked(String buttonId) {
		switch (buttonId) {
			case "sair":
				System.out.println("Botão: Sair da partida!");
				nav.goToMainMenu();
				break;
		}
		
	}
	
	public int getLife() { return player.getLife().getLife(); }

}
