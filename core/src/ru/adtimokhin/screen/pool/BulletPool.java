package ru.adtimokhin.screen.pool;

import ru.adtimokhin.base.SpritesPool;
import ru.adtimokhin.screen.gamescreen.Bullet;

/**
 * Пул пуль
 */

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void debugLog() {
        System.out.println("active/free:" + activeObjects.size() + "/" + freeObjects.size());
    }
}
