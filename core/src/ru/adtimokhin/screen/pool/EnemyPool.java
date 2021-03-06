package ru.adtimokhin.screen.pool;


import com.badlogic.gdx.audio.Sound;

import ru.adtimokhin.base.SpritesPool;
import ru.adtimokhin.maths.Rect;
import ru.adtimokhin.screen.gamescreen.Enemy;
import ru.adtimokhin.screen.gamescreen.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;
    private MainShip mainShip;
    private Sound sound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, MainShip mainShip, Sound sound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
        this.sound = sound;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, sound, mainShip, worldBounds);
    }
}
