package ru.adtimokhin.screen.menuscreen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.adtimokhin.base.ActionListener;
import ru.adtimokhin.base.ScaledTouchUpButton;
import ru.adtimokhin.maths.Rect;


public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, ActionListener actionListener, float pressScale) {
        super(atlas.findRegion("btExit"), actionListener, pressScale);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
