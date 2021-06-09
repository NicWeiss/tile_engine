package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Ui;

import java.util.ArrayList;


public class MainMenu extends View implements UiObject.Callback {

    public Ui ui;

    ButtonCommon[] menuButtonList;

    public void init(){
        ui = new Ui();
        ui.init(store);

        String[][] buttonsData = new String[4][2];

        buttonsData[0][0] = "New game";
        buttonsData[0][1] = "menu_newGame";

        buttonsData[1][0] = "Load game";
        buttonsData[1][1] = "menu_loadGame";

        buttonsData[2][0] = "Settings";
        buttonsData[2][1] = "menu_settings";

        buttonsData[3][0] = "Exit";
        buttonsData[3][1] = "menu_exit";

        menuButtonList = ui.createButtonList(buttonsData);

        for (ButtonCommon menuButton: menuButtonList) {
            menuButton.registerCallBack(this);
        }

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);

        for (ButtonCommon menuButton: menuButtonList) {
            menuButton.checkTouch(fingerX, fingerY);
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (ButtonCommon menuButton: menuButtonList) {
            menuButton.touchOut();
        }

        return false;
    }

    public void log(String message){
    }

    public void render(SpriteBatch batch) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float) 0xf0 / 0xff, (float) 0xf0 / 0xff, (float) 0xf0 / 0xff, 1);

        for (ButtonCommon menuButton: menuButtonList) {
            menuButton.draw(batch);
        }
    }

    @Override
    public void callingBack(String str) {
        Gdx.app.log("Debug",str);
    }
}
