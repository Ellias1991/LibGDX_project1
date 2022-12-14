package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.MenuScreen;

public class Main extends Game {

    @Override
    public void create() {
setScreen(new MenuScreen(this));
    }

    @Override
    public void render() { //метод вызывается когда нужно отрисовать нашу картинку
        super.render();
    }//вызывается когда нужно отрисовать картинку

    @Override
    public void setScreen(Screen screen) {///метод с помощью которого можно установить новую картинку
        super.setScreen(screen);
    }//с помощью него можем установить новую картинку(скрину). Скрин---класс,в котором что-то происходит.

    @Override
    public void dispose() {
        super.dispose();
    }
}
