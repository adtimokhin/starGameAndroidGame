package ru.adtimokhin.screen.gamescreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.adtimokhin.base.ActionListener;
import ru.adtimokhin.base.ScaledTouchUpButton;

public class ButtonNewGame extends ScaledTouchUpButton {
    private static final float HEIGHT = 0.07f;
    private static final float BOTTOM_MARGIN = -0.25f;

    public ButtonNewGame(TextureRegion region, ActionListener actionListener, float pressScale) {
        super(region, actionListener, pressScale);
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);
    }

}
