package ru.adtimokhin.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.adtimokhin.maths.Rect;
import ru.adtimokhin.maths.Rnd;
import ru.adtimokhin.screen.gamescreen.Enemy;
import ru.adtimokhin.screen.pool.EnemyPool;

public class EnemyEmitter {
    // small ship
    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_SMALL_BULLET_VY = -0.3f;
    private static final int ENEMY_SMALL_BULLET_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 1.5f;
    private static final int ENEMY_SMALL_HP = 1;
    private TextureRegion[] enemySmallRegion;
    private Vector2 enemySmallV = new Vector2(0f, -0.2f);
    // medium ship
    private static final float ENEMY_MEDIUM_HEIGHT = 0.15f;
    private static final float ENEMY_MEDIUM_BULLET_HEIGHT = 0.015f;
    private static final float ENEMY_MEDIUM_BULLET_VY = -0.3f;
    private static final int ENEMY_MEDIUM_BULLET_DAMAGE = 2;
    private static final float ENEMY_MEDIUM_RELOAD_INTERVAL = 2f;
    private static final int ENEMY_MEDIUM_HP = 2;
    private TextureRegion[] enemyMediumRegion;
    private Vector2 enemyMediumV = new Vector2(0f, -0.15f);
    // big ship
    private static final float ENEMY_BIG_HEIGHT = 0.2f;
    private static final float ENEMY_BIG_BULLET_HEIGHT = 0.02f;
    private static final float ENEMY_BIG_BULLET_VY = -0.3f;
    private static final int ENEMY_BIG_BULLET_DAMAGE = 3;
    private static final float ENEMY_BIG_RELOAD_INTERVAL = 2.5f;
    private static final int ENEMY_BIG_HP = 5;
    private TextureRegion[] enemyBigRegion;
    private Vector2 enemyBigV = new Vector2(0f, -0.1f);

    private Rect worldBounds;
    //Small Intervals
    private float generateSmallInterval = 4f;
    private float generateSmallTimer;
    // Medium Intervals
    private float generateMediumInterval = 8f;
    private float generateMediumTimer;
    // Big Intervals
    private float generateBigInterval = 12f;
    private float generateBigTimer;



    private TextureRegion bulletRegion;

    private EnemyPool enemyPool;

    public EnemyEmitter(TextureAtlas atlas, Rect worldBounds, EnemyPool enemyPool) {
        this.worldBounds = worldBounds;
        this.enemyPool = enemyPool;
        // small realisation
        TextureRegion textureRegion0 = atlas.findRegion("enemy0");
        this.enemySmallRegion = Regions.split(textureRegion0, 1, 2,2);
        // medium realisation
        textureRegion0 = atlas.findRegion("enemy1");
        this.enemyMediumRegion = Regions.split(textureRegion0, 1, 2,2);
        // big realisation
        textureRegion0 = atlas.findRegion("enemy2");
        this.enemyBigRegion = Regions.split(textureRegion0, 1, 2,2);
        // bullet realisation
        this.bulletRegion = atlas.findRegion("bulletEnemy");

    }

    public void generateEnemies(float delta) {
        generateSmallTimer += delta;
        generateMediumTimer += delta;
        generateBigTimer += delta;
        if (generateSmallTimer >= generateSmallInterval) {
            generateSmallTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemySmallRegion,
                    enemySmallV,
                    bulletRegion,
                    ENEMY_SMALL_BULLET_HEIGHT,
                    ENEMY_SMALL_BULLET_VY,
                    ENEMY_SMALL_BULLET_DAMAGE,
                    ENEMY_SMALL_RELOAD_INTERVAL,
                    ENEMY_SMALL_HEIGHT,
                    ENEMY_SMALL_HP
            );

                enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
                enemy.setBottom(worldBounds.getTop());

        }
        if (generateMediumTimer >= generateMediumInterval){
            generateMediumTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemyMediumRegion,
                    enemyMediumV,
                    bulletRegion,
                    ENEMY_MEDIUM_BULLET_HEIGHT,
                    ENEMY_MEDIUM_BULLET_VY,
                    ENEMY_MEDIUM_BULLET_DAMAGE,
                    ENEMY_MEDIUM_RELOAD_INTERVAL,
                    ENEMY_MEDIUM_HEIGHT,
                    ENEMY_MEDIUM_HP
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
        if (generateBigTimer >= generateBigInterval){
            generateBigTimer = 0f;
           Enemy  enemy = enemyPool.obtain();
            enemy.set(
                    enemyBigRegion,
                    enemyBigV,
                    bulletRegion,
                    ENEMY_BIG_BULLET_HEIGHT,
                    ENEMY_BIG_BULLET_VY,
                    ENEMY_BIG_BULLET_DAMAGE,
                    ENEMY_BIG_RELOAD_INTERVAL,
                    ENEMY_BIG_HEIGHT,
                    ENEMY_BIG_HP
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }
}
