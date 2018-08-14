package ru.adtimokhin;

import com.badlogic.gdx.Game;

import ru.adtimokhin.screen.MenuScreen;

public class StarShooterGame extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
