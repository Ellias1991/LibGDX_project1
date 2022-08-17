package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Anm {
    private Texture img;
    private Animation<TextureRegion> anim;
    float time;//внутреннее время анимации

    public Anm(String name, int col, int row, Animation.PlayMode playMode) {
        img = new Texture(name);
        img = new Texture("character.png");
        TextureRegion region0 = new TextureRegion(img);
        int Xcnt = region0.getRegionWidth() / col;
        int Ycnt = region0.getRegionWidth() / row;
        TextureRegion[][] regions0 = region0.split(Xcnt, Ycnt);
        TextureRegion region1[] = new TextureRegion[regions0.length * regions0[0].length];
        int cnt = 0;
        for (int i = 0; i < regions0.length; i++) {
            for (int j = 0; j < regions0[0].length; j++) {
                region1[cnt++] = regions0[i][j];
            }
        }
        anim = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(1 / 0.6f, region1);
        anim.setFrameDuration(1 / 15f);
        anim.setPlayMode(com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_PINGPONG);
        int a = 0;

        time += Gdx.graphics.getDeltaTime();
    }

    public TextureRegion getFrame() {//получить кадр
        return anim.getKeyFrame(time);
    }//мы снаружи будем вытаскивать кадры

    public void setTime(float time) {
        this.time += time;
    }

    public void zeroTime() {//если нужно обнулить время
        this.time = 0;
    }

    public boolean isAnimationOver() {
        return anim.isAnimationFinished(time);
    }

    public void setPlayMode(Animation.PlayMode playMode) {
        anim.setPlayMode(playMode);
    }


    public void dispose() {//удалить анимацию(текстуру)
     img.dispose();
    }
}

