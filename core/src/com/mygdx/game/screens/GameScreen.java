package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Anm;
import com.mygdx.game.Main;

public class GameScreen implements Screen {

    private Main game;
    private SpriteBatch batch;
    private Texture img;
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private Rectangle startRect;
    private ShapeRenderer shapeRenderer;


    public GameScreen(Main game) {
        this.game = game;
        batch= new SpriteBatch();
        img=new Texture("gamer2.jpg");
        camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        TmxMapLoader tm = new TmxMapLoader();//наш формат хранения карты

        startRect=new Rectangle(0,0,img.getWidth(),img.getHeight());
        shapeRenderer=new ShapeRenderer();
        map=tm.load("map/карта 1.tmx");
        mapRenderer=new OrthogonalTiledMapRenderer(map);//указываем какую карту отрисовывать, метод,позволяющий отрисовать карту

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        camera.update();
        ScreenUtils.clear(Color.CHARTREUSE);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(img,0,0);
        batch.end();

        mapRenderer.setView(camera);//установили вид
        mapRenderer.render();///этот метод и метод выше позволяют отрисовать карту

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.rect(startRect.x, startRect.y, startRect.width, startRect.height);
        shapeRenderer.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            dispose();
            game.setScreen(new MenuScreen(game));

        }




    }

    @Override
    public void resize(int width, int height) {

    camera.viewportWidth=width;
    camera.viewportHeight=height;

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
        this.batch.dispose();
        this.img.dispose();

    }
}
