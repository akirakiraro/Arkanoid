package dev.akira.arkanoid.controller;

import dev.akira.arkanoid.controller.screen.ScreenController;
import dev.akira.arkanoid.navigation.Navigation;

public class MainMenuController implements ScreenController{
	private final Navigation nav;

    public MainMenuController(Navigation nav) { 
        this.nav = nav; 
    }
    
	@Override
	public void onButtonClicked(String buttonId) {
		switch (buttonId) {
	        case "play":
	        	System.out.println("Botão jogar clicado!");
	            nav.goToGame();
	            break;
	        case "exit":
	            System.out.println("Saindo do jogo...");
	            com.badlogic.gdx.Gdx.app.exit();
	            break;
	        default:
	        	System.out.println("Ação desconhecida: " + buttonId);
		}
	}

}
