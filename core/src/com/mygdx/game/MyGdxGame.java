package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

    int clck;
    Anm animation;
    boolean dir;

    @Override
    public void create() {
        batch = new SpriteBatch();
    }
        @Override
        public void render() {
            ScreenUtils.clear(1, 1, 1, 1);

            float x = Gdx.input.getX() - animation.getFrame().getRegionWidth() / 2;
            float y = Gdx.graphics.getHeight() - Gdx.input.getY() - animation.getFrame().getRegionHeight() / 2;

            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) clck++;

            Gdx.graphics.setTitle("Clicked " + clck + " times");
            if (Gdx.input.isKeyJustPressed(Input.Keys.L)) dir = true;
            if (Gdx.input.isKeyJustPressed(Input.Keys.R)) dir = false;
            if (!animation.getFrame().isFlipX()) animation.getFrame().flip(true, false);
            batch.begin();
            //batch.draw(img, 0, 0);
            //batch.draw(img, x, y);
            batch.draw(animation.getFrame(), 0, 0);
            batch.end();
        }

        @Override
        public void dispose () {
            batch.dispose();


        }
    }

