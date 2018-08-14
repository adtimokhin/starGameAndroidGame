package ru.adtimokhin.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.logging.Level;

import ru.adtimokhin.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    public MenuScreen(Game game) {
        super(game);
    }

    SpriteBatch batch;
    Texture img;
    Texture background;
    float x;
    float y;
    static int conter;
    int prevDirection = -1;
    float dist;
    //Flags
    static boolean VectorIsCalculated = false;
    static boolean velocityIsSet = false;
    //Vectors
    static Vector2 pos;
    static Vector2 velocity;
    Vector2 speedIncrement;
    static Vector2 destination;
    static Vector2 vector;
    // CONSTANTS
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int LEFT = 3;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        background = new Texture("spaceBG.jpg");// мой BG
        //Vectors
        pos = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
        speedIncrement = new Vector2(1.5f, 1.5f);
        vector = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();

        if (VectorIsCalculated)
            mouseMove();

        if (velocity.x != 0 || velocity.y != 0)
            pos.add(velocity.x, velocity.y);

    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
        background.dispose();
    }

    @Override
    public boolean keyTyped(char character) {
        if('w'==character)
            buttonMove(UP);
        else if('s'==character)
            buttonMove(DOWN);
        else if('d'==character)
            buttonMove(RIGHT);
        else if('a'== character)
            buttonMove(LEFT);
        return super.keyTyped(character);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(19 == keycode)
            keyTyped('w');
//            buttonMove(UP);
        else if(21 == keycode)
            keyTyped('a');
  //          buttonMove(LEFT);
        else if (20 == keycode)
            keyTyped('s');
    //        buttonMove(DOWN);
        else if(22 == keycode)
            keyTyped('d');
      //      buttonMove(RIGHT);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        speedIncrement.set(1.5f, 1.5f);
        prevDirection =-1;
        velocity.x = 0;
        velocity.y = 0;
        return super.keyUp(keycode);
    }

    private void buttonMove(int direction) {
        if (VectorIsCalculated) {
            VectorIsCalculated = false;
            velocity.set(0, 0);
        }
          if (direction ==UP){
            velocity.set(0,5*speedIncrement.y);
            speedIncrement.add(0.5f,0.5f);
          }else if (direction == DOWN){
              velocity.set(0,-5*speedIncrement.y);
              speedIncrement.add(0.5f,0.5f);
        }else if (direction == RIGHT){
              velocity.set(5*speedIncrement.x,0);
              speedIncrement.add(0.5f,0.5f);
          }else if(direction == LEFT){
              velocity.set(-5*speedIncrement.x,0);
              speedIncrement.add(0.5f,0.5f);
        }
    }

    private static void mouseMove() {
        if (!velocityIsSet) {
            if (vector.x != 0)
                velocity.x = vector.x / 30;
            else velocity.x = 0;
            if (vector.y != 0)
                velocity.y = vector.y / 30;
            else velocity.y = 0;
            velocityIsSet = true;
        }
        conter++;
        if (conter == 30 || destination.x == pos.x && destination.y == pos.y) {
            VectorIsCalculated = false;
            conter = 0;
            velocity.x = 0;
            velocity.y = 0;
            velocityIsSet = false;
        }
        /*pos.add(velocity.x, velocity.y);
        velocity.x =0;
        velocity.y =0;*/
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int normalY = Gdx.graphics.getHeight() - screenY;
        destination = new Vector2(screenX, normalY);
        vector = new Vector2(destination.x - pos.x, destination.y - pos.y);
        VectorIsCalculated = true;

        System.out.println(dist);
        return super.touchDown(screenX, normalY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        int normalHeight = Gdx.graphics.getHeight() - screenY;
        return super.touchUp(screenX, normalHeight, pointer, button);
    }

}
//KeyDown :29
//KeyTyped :a
//KeyUp:29
//KeyDown :47
//KeyTyped :s
//KeyUp:47
//KeyDown :51
//KeyTyped :w
//KeyUp:51
//KeyDown :32
//KeyTyped :d
//KeyUp:32

// KeyTyped :
//KeyUp:19
//KeyDown :21
//KeyTyped :
//KeyUp:21
//KeyDown :20
//KeyTyped :
//KeyUp:20
//KeyDown :22
//KeyTyped :
//KeyUp:22
