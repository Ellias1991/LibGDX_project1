package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Main;

public class GameScreen implements Screen {

    private Main game;
    private SpriteBatch batch;
    private Texture img;

    public GameScreen(Main game) {
        this.game = game;
        batch= new SpriteBatch();
        img=new Texture("gamer2.jpg");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(Color.CHARTREUSE);

        batch.begin();
        batch.draw(img,0,0);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            dispose();
            game.setScreen(new MenuScreen(game));

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}