package dev.akira.arkanoid.controller;

import dev.akira.arkanoid.controller.screen.ScreenController;
import dev.akira.arkanoid.navigation.Navigation;

public class GameOverController implements ScreenController{
	private final Navigation nav;
	
	public GameOverController(Navigation nav) {
        this.nav = nav;
    }
	
	@Override
	public void onButtonClicked(String buttonId) {
		
	}

}
