package dev.akira.arkanoid;

import com.badlogic.gdx.Game;
import dev.akira.arkanoid.navigation.Navigation;
import dev.akira.arkanoid.screen.MainMenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Akiranoid extends Game {
	private Navigation nav;
	
    @Override
    public void create() {
    	nav = new Navigation(this);
        setScreen(new MainMenuScreen(nav));
    }
}